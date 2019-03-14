package com.tom.scratch;

import java.util.List;
import java.util.concurrent.Future;

public interface ProductRepository {
    List<Product> getAllProducts();
    Future<List<Product>> getAllProductsAsync();
    Future<List<String>> getAllStoresAsync();
}
