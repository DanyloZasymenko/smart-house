package com.smarthouse.smarthouse.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@EnableJpaRepositories(basePackages = "com.smarthouse.smarthouse.repository")
@Component
public class Beans {

}
