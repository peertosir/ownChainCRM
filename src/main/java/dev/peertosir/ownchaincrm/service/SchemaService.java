package dev.peertosir.ownchaincrm.service;

import dev.peertosir.ownchaincrm.domain.Schema;
import dev.peertosir.ownchaincrm.dto.request.DetailAmountInSchemaRequestModel;
import dev.peertosir.ownchaincrm.dto.request.DetailSchemaRequestModel;

import java.util.List;

public interface SchemaService {
    List<Schema> getAllSchemas();

    Schema getSchemaById(long id);

    long createSchema(Schema schema);

    void deleteSchema(long id);

    long updateSchema(Schema schema, long id);

    void addDetailToSchema(long id, DetailSchemaRequestModel dto);

    void deleteDetailFromSchema(long id, long detailId);

    void updateDetailInSchema(long id, long detailId, DetailAmountInSchemaRequestModel model);
}
