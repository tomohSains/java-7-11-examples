package com.tom.scratch;

import java.util.Collections;
import java.util.List;

public class ProductFeedGenerator {

    private ProductRepository productRepository;

    public ProductFeedGenerator(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<String> generateProductFeedForClientX() {
        // get all products

        // remove non-displayable products

        // format product into a string as: PRD_<id>_<name>

        return Collections.emptyList();
    }
}
