package org.example;

import com.zaxxer.hikari.HikariDataSource;
import org.example.dao.UserRepository;
import org.example.model.Order;
import org.example.model.OrderItem;
import org.example.model.Product;
import org.example.model.User;
import org.example.service.OrderItemService;
import org.example.service.OrderService;
import org.example.service.ProductService;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


        /*    private static DataSource createDataSource1() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:users.sql'");
        return ds;
    }*/

    }
    @Override
    public void run(String... args) throws Exception {

        //Users
        User user1 = new User("Tom");
        userService.save(user1);

        User user2 = new User("Anna");
        userService.save(user2);

        User user3 = new User("Chris");
        userService.save(user3);

        //Products
        Product product1 = new Product();
        product1.setProductName("trousers");
        product1.setCategory("clothes");
        product1.setQuantityOnStock(15);
        productService.save(product1);

        Product product2 = new Product();
        product2.setProductName("t-shirt");
        product2.setCategory("clothes");
        product2.setQuantityOnStock(30);
        productService.save(product2);

        Product product3 = new Product();
        product3.setProductName("pens");
        product3.setCategory("stationery");
        product3.setQuantityOnStock(50);
        productService.save(product3);

        //Order
        Order order = new Order();
        //put OrderItems in the Order
//Hose 2 St für 15 Euro/st
        int quantity1 = 2;
        double pricePerUnit1 = 15.00;
        double totalPrice1 = quantity1 * pricePerUnit1;
        OrderItem createOrderItemResult1 = orderItemService.createOrderItem(order, product1, quantity1, pricePerUnit1, totalPrice1);
//T-shirt3 St für 10 Euro/St
        int quantity2 = 3;
        double pricePerUnit2 = 10.00;
        double totalPrice2 = quantity2 * pricePerUnit2;
        OrderItem createOrderItemResult2 = orderItemService.createOrderItem(order, product2, quantity2, pricePerUnit2, totalPrice2);
//Stifte 10 St für 1 Euro/St
        int quantity3 = 10;
        double pricePerUnit3 = 1.00;
        double totalPrice3 = quantity3 * pricePerUnit3;
        OrderItem createOrderItemResult3 = orderItemService.createOrderItem(order, product3, quantity3, pricePerUnit3, totalPrice3);

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(createOrderItemResult1);
        orderItems.add(createOrderItemResult2);
        orderItems.add(createOrderItemResult3);

        Order createOrderResult = orderService.create(order, orderItems);

    }
}