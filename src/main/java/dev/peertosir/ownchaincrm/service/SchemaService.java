package dev.peertosir.ownchaincrm.service;

import dev.peertosir.ownchaincrm.domain.Schema;

import java.util.List;

public interface SchemaService {
    public List<Schema> getAllSchemas();

    Schema getSchemaById(int id);
}
