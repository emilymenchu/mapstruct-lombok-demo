package com.mapstructcourse.mapstruct_lombok_demo.test;

import com.mapstructcourse.mapstruct_lombok_demo.dto.GetProduct;
import com.mapstructcourse.mapstruct_lombok_demo.entity.Product;
import com.mapstructcourse.mapstruct_lombok_demo.mapper.ProductMapper;
import com.mapstructcourse.mapstruct_lombok_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitDataBase {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public InitDataBase(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Bean
    public CommandLineRunner testProductMapperCommand() {
        return args -> {
            List<Product> products = productRepository.findAll();
            System.out.println("PRODUCTS:");
            products.forEach(System.out::println);

            System.out.println("GET PRODUCT");
            List<GetProduct> getProductList = productMapper.toGetDtoList(products);
            getProductList.forEach(System.out::println);

            System.out.println("MAPPED PRODUCTS");
            List<Product> mappedProducts = productMapper.toProductList(getProductList);
            mappedProducts.forEach(System.out::println);
        };
    }
}