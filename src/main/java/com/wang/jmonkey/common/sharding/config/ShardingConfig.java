package com.wang.jmonkey.common.sharding.config;

import com.zaxxer.hikari.HikariDataSource;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

//@Data
//@ConfigurationProperties(prefix = "sharding.jdbc")
public class ShardingConfig {

  //  private Map<String, HikariDataSource> datasource = new HashMap<>();

    // private MasterSlaveRuleConfiguration masterSlaveRule;
}
