package org.shop.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("org.shop")
@Import({FactoryConfig.class, InitializerConfig.class, RepositoryConfig.class, ServiceConfig.class})
public class RootConfig {

}
