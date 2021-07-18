package dev.peertosir.ownchaincrm.service.impl;

import dev.peertosir.ownchaincrm.domain.Product;
import dev.peertosir.ownchaincrm.domain.Schema;
import dev.peertosir.ownchaincrm.dto.request.ProductRequestModel;
import dev.peertosir.ownchaincrm.repository.ProductRepository;
import dev.peertosir.ownchaincrm.service.ProductService;
import dev.peertosir.ownchaincrm.service.SchemaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SchemaService schemaService;

    @Autowired
    public ProductServiceImpl(
            ProductRepository productRepository,
            SchemaService schemaService) {
        this.productRepository = productRepository;
        this.schemaService = schemaService;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Product with id: " + id);
    }

    @Override
    public Long createProduct(ProductRequestModel productRequestModel) {
        Product product = new Product();
        return saveProduct(productRequestModel, product);
    }

    @Override
    public long updateProduct(ProductRequestModel productRequestModel, long id) {
        Product product = getProductById(id);
        return saveProduct(productRequestModel, product);
    }

    @Override
    public void deleteProduct(long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    private long saveProduct(ProductRequestModel template, Product target) {
        BeanUtils.copyProperties(template, target,"id", "schema");
        Schema schema = schemaService.getSchemaById(template.getSchema());
        target.setSchema(schema);
        productRepository.save(target);
        return target.getId();
    }
}
