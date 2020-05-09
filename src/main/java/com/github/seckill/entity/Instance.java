package com.github.seckill.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.math.BigInteger;
import java.util.Date;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/9
 */
@Data
@Alias("instance")
public class Instance {

    private BigInteger id;

    private String instanceId;

    private String instanceName;

    private String status;

    private String instanceMode;

    private String instanceType;

    private String sourceInstanceId;

    private String engine;

    private String engineVersion;

    private String ip;

    private Integer port;

    private String vpcId;

    private String subnetId;

    private String regionId;

    private String tenantId;

    private String userId;

    private String ucaApiVersion;

    private Date destroyAt;

    private Date recordStartAt;

    private Date recordUpdateAt;


}
