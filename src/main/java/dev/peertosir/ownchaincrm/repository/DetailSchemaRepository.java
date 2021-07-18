package dev.peertosir.ownchaincrm.repository;

import dev.peertosir.ownchaincrm.domain.DetailSchema;
import dev.peertosir.ownchaincrm.domain.DetailSchemaId;
import org.springframework.data.repository.CrudRepository;

public interface DetailSchemaRepository extends CrudRepository<DetailSchema, DetailSchemaId> {
}
