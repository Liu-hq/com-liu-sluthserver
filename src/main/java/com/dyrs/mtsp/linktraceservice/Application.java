package com.dyrs.mtsp.linktraceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

/**
 * Created by Administrator on 2017/11/28.
 */
@SpringBootApplication
@EnableZipkinStreamServer
public class Application {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class,args);
    }

}
