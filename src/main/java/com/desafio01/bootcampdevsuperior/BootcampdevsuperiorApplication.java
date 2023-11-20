package com.desafio01.bootcampdevsuperior;

import com.desafio01.bootcampdevsuperior.entities.Order;
import com.desafio01.bootcampdevsuperior.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class BootcampdevsuperiorApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(BootcampdevsuperiorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the code: ");
        int code = sc.nextInt();

        System.out.println("Enter the Basic Value: ");
        Double basic = sc.nextDouble();

        System.out.println("Enter the discount percentage: ");
        double discount = sc.nextDouble();

        Order order = new Order();

        order.setCode(code);
        order.setBasic(basic);
        order.setDiscount(discount);

        sc.close();

        System.out.println("Code: " + code);

        double result = orderService.total(order);
        System.out.printf("Value Total: %.2f%n ", result);


    }
}
