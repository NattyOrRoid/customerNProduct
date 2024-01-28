package com.etiqa.custNprod.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.etiqa.custNprod.domain.Product;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Optional<Product> findOneByTitle(String title);

    Optional<Product> findOneByAuthor(String author);
    
}
