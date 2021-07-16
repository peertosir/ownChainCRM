package dev.peertosir.ownchaincrm.service;

import dev.peertosir.ownchaincrm.domain.Schema;

import java.util.List;

public interface SchemaService {
    List<Schema> getAllSchemas();

    Schema getSchemaById(int id);

    int createSchema(Schema schema);

    void deleteSchema(int id);

    int updateDetail(Schema schema, int id);
}
