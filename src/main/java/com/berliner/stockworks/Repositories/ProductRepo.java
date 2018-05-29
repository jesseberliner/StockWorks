package com.berliner.stockworks.Repositories;

import com.berliner.stockworks.Models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long>
{
}
