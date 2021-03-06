package com.hidm.sso;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StringUtils;

@SpringBootApplication
@EnableScheduling
public class App extends SpringBootServletInitializer {
    private static final Logger log = LoggerFactory.getLogger(App.class);
    
    @Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            public Date convert(String source) {
                SimpleDateFormat sdf = null;
                Date date = null;
                try {
                    if (!StringUtils.isEmpty(source)) {
                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        if (source.length() == 19) {
                            date = sdf.parse((String) source);
                        }
                        
                        if (source.length() == 10) {
                            source += " 00:00:00";
                            date = sdf.parse((String) source);
                        }
                    }
                } catch (Exception e) {
                    log.error("Failed to convert string to date. source: " + source, e);
                }
                return date;
            }
        };
    }
    
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
