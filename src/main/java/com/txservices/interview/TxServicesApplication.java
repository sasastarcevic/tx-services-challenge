package com.txservices.interview;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TxServicesApplication {

    private static final Logger LOGGER = LogManager.getLogger(TxServicesApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting TxServicesApplication Application...");
        SpringApplication.run(TxServicesApplication.class, args);
    }

}
