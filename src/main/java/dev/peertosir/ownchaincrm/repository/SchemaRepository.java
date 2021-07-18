package dev.peertosir.ownchaincrm.repository;

import dev.peertosir.ownchaincrm.domain.Schema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchemaRepository extends JpaRepository<Schema, Long> {
}
