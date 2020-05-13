package com.github.seckill.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author wushunyu
 * @date 2020/5/12
 */
@Component
@ConfigurationProperties(prefix = "user")
@PropertySource("classpath:/config/server.properties")
@Data
public class ServerConfig {

    private String name;

}
