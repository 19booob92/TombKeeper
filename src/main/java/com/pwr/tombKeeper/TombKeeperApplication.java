package com.pwr.tombKeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MongoConfig.class)
@ComponentScan("com.pwr")
public class TombKeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(TombKeeperApplication.class, args);
    }
    
}
