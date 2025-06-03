package com.mapstructcourse.mapstruct_lombok_demo.repository;

import com.mapstructcourse.mapstruct_lombok_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
