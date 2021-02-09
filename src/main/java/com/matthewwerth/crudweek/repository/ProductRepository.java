package com.matthewwerth.crudweek.repository;

import com.matthewwerth.crudweek.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

