package com.hidm.booksharingscore;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksharingscoreApplication extends SpringBootServletInitializer{

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BooksharingscoreApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(BooksharingscoreApplication.class, args);
	}
	
	/**  
     * 文件上传配置  
     * @return  
     */  
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //单个文件最大  
        factory.setMaxFileSize("1024000KB"); //KB,MB  
        /// 设置总上传数据总大小  
        factory.setMaxRequestSize("10240000KB");  
        return factory.createMultipartConfig();  
    }  

}
