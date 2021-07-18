package dev.peertosir.ownchaincrm.controller;

import dev.peertosir.ownchaincrm.domain.Product;
import dev.peertosir.ownchaincrm.dto.request.ProductRequestModel;
import dev.peertosir.ownchaincrm.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        LOGGER.info("Getting all Products");
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getDetail(@PathVariable long id) {
        LOGGER.info("Getting Product with ID: " + id);
        return productService.getProductById(id);
    }

    @PostMapping("")
    public Long createProduct(@Valid @RequestBody ProductRequestModel product) {
        LOGGER.info("Creating Product");
        Long createdProductId = productService.createProduct(product);
        LOGGER.info("Created Product with ID: " + createdProductId);
        return createdProductId;
    }

    @PutMapping("/{id}")
    public long updateProduct(@Valid @RequestBody ProductRequestModel product, @PathVariable long id) {
        LOGGER.info("Updating Product with ID: " + id);
        long updatedProductId = productService.updateProduct(product, id);
        LOGGER.info("Product with ID: " + updatedProductId + " updated");
        return updatedProductId;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDetail(@PathVariable long id) {
        LOGGER.info("Deleting Detail with ID: " + id);
        productService.deleteProduct(id);
        LOGGER.info("Detail with ID: " + id + " deleted");
    }
}
