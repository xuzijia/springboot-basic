package com.simple.springbootbasic.basic.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.springbootbasic.basic.annotation.Log;
import com.simple.springbootbasic.basic.constant.GlobalConstant;
import com.simple.springbootbasic.basic.properties.SimpleProperies;
import com.simple.springbootbasic.system.entity.SystemLog;
import com.simple.springbootbasic.system.service.SystemLogService;
import com.simple.springbootbasic.utils.HttpContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Description AOP 全局日志记录
 * @Author Simple
 * @Date 2018/9/18 10:05
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Autowired
    private SimpleProperies simpleProperies;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private SystemLogService systemLogService;

    @Pointcut("@annotation(com.simple.springbootbasic.basic.annotation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        String errorMessage="";//执行错误消息
        Integer status= GlobalConstant.SystemLog.success;//是否执行成功 1为成功
        Throwable ex=null;
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            status=GlobalConstant.SystemLog.error;
            errorMessage=e.getMessage();
            ex=e;

        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        if (simpleProperies.getOpenAopLog()){
            SystemLog log = new SystemLog();
            log.setStatus(status);
            log.setErrorMessage(errorMessage);
            log.setTime(time);
            // 保存日志
            saveLog(point, log);
        }
        if(ex!=null){
            throw ex;
        }
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, SystemLog log) throws JsonProcessingException {
        //todo 获取操作用户
        //User user = (User) SecurityUtils.getSubject().getPrincipal();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            log.setDescription(logAnnotation.value());
            //注解上的日志类型
            log.setLog_type(logAnnotation.logType());
        }

        // 请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = signature.getName();
        log.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null) {
            StringBuilder params = new StringBuilder();
            int i = 0;
            while (i < args.length) {
                params.append("  ").append(paramNames[i]).append(": ").append(this.mapper.writeValueAsString(args[i]));
                i++;
            }
            log.setParams(params.toString());
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
       // log.setIp(IPUtils.getIpAddr(request));
        log.setCreateTime(new Date());
       // log.setLocation(AddressUtils.getRealAddressByIP(log.getIp(), mapper));
        //设置请求方法类型
        log.setMethod_type(request.getMethod());
        //设置请求url
        log.setUrl(request.getRequestURL().toString());
        // 保存系统日志
        systemLogService.save(log);
    }
}
