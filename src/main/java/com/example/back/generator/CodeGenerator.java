package com.example.back.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class CodeGenerator {

    private static DataSourceConfig.Builder getDataSourceConfig() {

        Properties props = new Properties();

        try (InputStream is = CodeGenerator.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (is == null) {
                throw new RuntimeException("找不到 application.properties");
            }
            props.load(is);

        } catch (Exception e) {
            throw new RuntimeException("读取数据库配置失败", e);
        }

        String url = props.getProperty("spring.datasource.url");
        String username = props.getProperty("spring.datasource.username");
        String password = props.getProperty("spring.datasource.password");

        return new DataSourceConfig.Builder(url, username, password);
    }


    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");

        FastAutoGenerator.create(getDataSourceConfig())
                .globalConfig(builder -> {
                    builder.author("Tomlzk")
                            .outputDir(projectPath + "/src/main/java")
                            .disableOpenDir()
                            .dateType(DateType.TIME_PACK);
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.back")
                            .entity("entity")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .xml("mapper")
                            .pathInfo(
                                    Map.of(
                                            OutputFile.xml,
                                            projectPath + "/src/main/resources/mapper"
                                    )
                            );
                })
                .strategyConfig(builder -> {
                    builder.addInclude("db_user", "enroll", "exam", "score")
                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            .enableRestStyle();
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
