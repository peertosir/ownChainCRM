package dev.peertosir.ownchaincrm.repository;

import dev.peertosir.ownchaincrm.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
