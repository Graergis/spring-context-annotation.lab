package org.shop.api.config;

import org.shop.api.*;
import org.shop.api.impl.*;
import org.shop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public ItemService itemService() {return new ItemServiceImpl(itemRepository);}

    @Bean
    public OrderService orderService() {return  new OrderServiceImpl();}

    @Bean
    public ProductService productService() {return new ProductServiceImpl(productRepository);}

    @Bean
    public ProposalService proposalService() {return new ProposalServiceImpl(proposalRepository, sellerService(), productService());}

    @Bean
    public SellerService sellerService() {return new SellerServiceImpl(sellerRepository);}

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.populate(userRepository);
        return userService;}
}