package com.wang.jmonkey.common.sharding.config;

import com.google.common.collect.Maps;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

//@Configuration
// @EnableConfigurationProperties(ShardingConfig.class)
public class ShardingDataSourceConfig {

   /* @Autowired
    private ShardingConfig config;*/

   /* @Bean
    public DataSource jMonkyeDataSource() throws SQLException {
        Map<String, DataSource> dataSourceMap = Maps.newHashMap();
        dataSourceMap.putAll(config.getDatasource());
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, config.getMasterSlaveRule(), Maps.newHashMap());
        return dataSource;
    }*/

}
