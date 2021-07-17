package dev.peertosir.ownchaincrm.service;

import dev.peertosir.ownchaincrm.domain.Schema;
import dev.peertosir.ownchaincrm.dto.request.DetailSchemaRequestDto;

import java.util.List;

public interface SchemaService {
    List<Schema> getAllSchemas();

    Schema getSchemaById(int id);

    int createSchema(Schema schema);

    void deleteSchema(int id);

    int updateSchema(Schema schema, int id);

    void addDetailToSchema(int id, DetailSchemaRequestDto dto);

    void deleteDetailFromSchema(int id, int detailId);
}
