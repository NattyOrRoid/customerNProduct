package com.etiqa.custNprod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.etiqa.custNprod.controller.CustomerController;
import com.etiqa.custNprod.controller.ProductController;

@SpringBootApplication
@ComponentScan(basePackageClasses = CustomerController.class)
@ComponentScan(basePackageClasses = ProductController.class)
@ComponentScan("com.etiqa.custNprod")
public class CustNprodApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustNprodApplication.class, args);
	}

}
