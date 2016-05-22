package org.shop.api.config;

import org.shop.repository.*;
import org.shop.repository.map.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:/applications.properties")
public class RepositoryConfig {

    @Value("${sequence}")
    private Long sequence;

    @Bean
    public ItemRepository itemRepository() { return new ItemMapRepository();}

    @Bean
    public OrderRepository orderRepository(){
        OrderMapRepository result = new OrderMapRepository();
        result.setSequence(sequence);
        return result;
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository(){
        return new ProposalMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository(){
        return new SellerMapRepository();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
