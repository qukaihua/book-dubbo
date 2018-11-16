package com.qu.Config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import com.google.code.kaptcha.util.Config;

/**
 * Created by 96283 on 2018/11/16.
 */
@Configuration
public class CaptchaConfig {

    @Bean(name="cProducer")
    public DefaultKaptcha getKaptchaBean(){
        DefaultKaptcha defaultKaptcha=new DefaultKaptcha();
        Properties properties=new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.image.width", "125");
        properties.setProperty("kaptcha.image.height", "45");
        properties.setProperty("kaptcha.session.key", "code");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        Config config=new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }


}
