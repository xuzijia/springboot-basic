package com.simple.springbootbasic.basic.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

/**
 *
 *
 * @Title: MyBatisConfig.java
 * @Description: mybtis实现正则扫描java bean包
 * @author bamboo
 * @date 2017年4月26日 下午2:15:02
 * @version V1.0
 */

@Configuration
@PropertySource("classpath:application.yml")
@Slf4j
public class MyBatisConfig {
    @Autowired
    private Environment env;


    static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    public static String setTypeAliasesPackage(String typeAliasesPackage) {
        ResourcePatternResolver resolver = (ResourcePatternResolver) new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(
                resolver);
        typeAliasesPackage = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                + ClassUtils.convertClassNameToResourcePath(typeAliasesPackage)
                + "/" + DEFAULT_RESOURCE_PATTERN;
        try {
            List<String> result = new ArrayList<String>();
            Resource[] resources = resolver.getResources(typeAliasesPackage);
            if (resources != null && resources.length > 0) {
                MetadataReader metadataReader = null;
                for (Resource resource : resources) {
                    if (resource.isReadable()) {
                        metadataReader = metadataReaderFactory
                                .getMetadataReader(resource);
                        try {
                            result.add(Class
                                    .forName(
                                            metadataReader.getClassMetadata()
                                                    .getClassName())
                                    .getPackage().getName());
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (result.size() > 0) {
                HashSet<String> h = new HashSet<String>(result);
                result.clear();
                result.addAll(h);
                typeAliasesPackage= String.join(",",(String[]) result.toArray(new String[0]));
                System.out.println(typeAliasesPackage);
            } else {
               log.warn(
                        "mybatis typeAliasesPackage 路径扫描错误,参数typeAliasesPackage:"
                                + typeAliasesPackage + "未找到任何包");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return typeAliasesPackage;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
            throws Exception {
        log.info(">>>>>>>>>>>配置[typeAliasesPackage,mapperLocations]START>>>>>>>>>>>>>>");
        Properties props = new Properties();
        String typeAliasesPackage = env
                .getProperty("mybatis.typeAliasesPackage");
        String mapperLocations = env.getProperty("mybatis.mapperLocations");
        typeAliasesPackage=setTypeAliasesPackage(typeAliasesPackage);

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage(typeAliasesPackage);
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(mapperLocations);
        sessionFactory.setMapperLocations(resources);
       log.info(">>>>>>>>>>>配置[typeAliasesPackage,mapperLocations]END>>>>>>>>>>>>>>");
        return sessionFactory.getObject();
    }
}