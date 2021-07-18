package dev.peertosir.ownchaincrm.service;

import dev.peertosir.ownchaincrm.domain.Product;
import dev.peertosir.ownchaincrm.dto.request.ProductRequestModel;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    Long createProduct(ProductRequestModel product);

    long updateProduct(ProductRequestModel product, long id);

    void deleteProduct(long id);
}
