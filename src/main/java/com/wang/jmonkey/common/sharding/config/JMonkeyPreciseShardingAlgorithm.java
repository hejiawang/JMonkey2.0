package com.wang.jmonkey.common.sharding.config;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;
import java.util.Date;

/**
 * @Description: 自定义分片算法
 * @Auther: HeJiawang
 * @Date: 2019/1/22
 */
public class JMonkeyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> shardingValue) {

        System.out.println(shardingValue.getValue().getDay());


        /*for (String tableName : availableTargetNames) {
            if (tableName.endsWith(shardingValue.getValue() % 4 + "")) {
                return tableName;
            }
        }

        throw new IllegalArgumentException();*/


        return "sys_log_0";
    }
}

