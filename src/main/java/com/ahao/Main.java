package com.ahao;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Main  {
    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();
        //数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/epidemic?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        generator.setDataSource(dataSourceConfig);
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        globalConfig.setAuthor("Ahao");
        globalConfig.setOpen(false);
        globalConfig.setServiceName("%sService");
        generator.setGlobalConfig(globalConfig);
        //包信息
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.ahao");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("entity");
        generator.setPackageInfo(packageConfig);
        //配置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        generator.setStrategy(strategyConfig);

        generator.execute();

    }
}
