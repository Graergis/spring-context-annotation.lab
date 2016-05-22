package org.shop;


import org.shop.api.config.RootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        DataInitializer result1 = applicationContext.getBean(DataInitializer.class);
        SellerInitializer result2 = applicationContext.getBean(SellerInitializer.class);
        ProductInitializer result3 = applicationContext.getBean(ProductInitializer.class);
        ProposalInitializer result4 = applicationContext.getBean(ProposalInitializer.class);
        UserInitializer result5 = applicationContext.getBean(UserInitializer.class);
        result1.init(result2, result4, result3, result5);
        result1.initData();
    }
}
