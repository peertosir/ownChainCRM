package dev.peertosir.ownchaincrm.service;

import dev.peertosir.ownchaincrm.domain.Schema;
import dev.peertosir.ownchaincrm.dto.request.DetailAmountInSchemaRequestModel;
import dev.peertosir.ownchaincrm.dto.request.DetailSchemaRequestModel;

import java.util.List;

public interface SchemaService {
    List<Schema> getAllSchemas();

    Schema getSchemaById(int id);

    int createSchema(Schema schema);

    void deleteSchema(int id);

    int updateSchema(Schema schema, int id);

    void addDetailToSchema(int id, DetailSchemaRequestModel dto);

    void deleteDetailFromSchema(int id, int detailId);

    void updateDetailInSchema(int id, int detailId, DetailAmountInSchemaRequestModel model);
}
