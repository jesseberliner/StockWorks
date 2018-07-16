package com.berliner.stockworks.Repositories;

import com.berliner.stockworks.Models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProductRepo extends CrudRepository<Product, Long>
{
    Set<Product> findByDeletedIsFalse();
}
