package com.mountmeru.entitymanagement.repository;

import com.mountmeru.entitymanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.CreatedBy = :createdBy")
    Optional<Product> findByCreatedBy(long createdBy);


}
