package com.azhya.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.azhya.repositories")
@EnableJpaAuditing
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfiguration {

}
