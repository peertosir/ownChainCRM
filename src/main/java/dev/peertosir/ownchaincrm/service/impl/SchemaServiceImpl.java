package dev.peertosir.ownchaincrm.service.impl;

import dev.peertosir.ownchaincrm.domain.Detail;
import dev.peertosir.ownchaincrm.domain.DetailSchema;
import dev.peertosir.ownchaincrm.domain.DetailSchemaId;
import dev.peertosir.ownchaincrm.domain.Schema;
import dev.peertosir.ownchaincrm.dto.request.DetailAmountInSchemaRequestModel;
import dev.peertosir.ownchaincrm.dto.request.DetailSchemaRequestModel;
import dev.peertosir.ownchaincrm.repository.DetailSchemaRepository;
import dev.peertosir.ownchaincrm.repository.SchemaRepository;
import dev.peertosir.ownchaincrm.service.DetailService;
import dev.peertosir.ownchaincrm.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SchemaServiceImpl implements SchemaService {
    private final SchemaRepository schemaRepository;
    private final DetailService detailService;
    private final DetailSchemaRepository detailSchemaRepository;

    @Autowired
    public SchemaServiceImpl(
            SchemaRepository schemaRepository,
            DetailService detailService,
            DetailSchemaRepository detailSchemaRepository
            ) {
        this.schemaRepository = schemaRepository;
        this.detailService = detailService;
        this.detailSchemaRepository = detailSchemaRepository;
    }

    public List<Schema> getAllSchemas() {
        return schemaRepository.findAll();
    }

    @Override
    public Schema getSchemaById(int id) {
        Optional<Schema> schema = schemaRepository.findById(id);
        if (schema.isPresent()) {
            return schema.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Schema with ID: " + id + " not found");
    }

    @Override
    public int createSchema(Schema schema) {
        return schemaRepository.save(schema).getId();
    }

    @Override
    public void deleteSchema(int id) {
        Schema schema = getSchemaById(id);
        schemaRepository.delete(schema);
    }

    @Override
    public int updateSchema(Schema updatedSchema, int id) {
        Schema schema = getSchemaById(id).updateWith(updatedSchema);
        schemaRepository.save(schema);
        return id;
    }

    @Override
    public void addDetailToSchema(int id, DetailSchemaRequestModel dto) {
        Schema schema = getSchemaById(id);
        Detail detail = detailService.getDetailById(dto.getDetailId());
        DetailSchema detailSchema = new DetailSchema(schema, detail, dto.getAmount());
        detailSchemaRepository.save(detailSchema);
    }

    @Override
    public void deleteDetailFromSchema(int id, int detailId) {
        DetailSchema detailSchema = findDetailInSchema(id, detailId);
        detailSchemaRepository.delete(detailSchema);
    }

    @Override
    public void updateDetailInSchema(int id, int detailId, DetailAmountInSchemaRequestModel model) {
        DetailSchema detailSchema = findDetailInSchema(id, detailId);
        detailSchema.setAmount(model.getAmount());
        detailSchemaRepository.save(detailSchema);
    }

    private DetailSchema findDetailInSchema(int schemaId, int detailId) {
        Optional<DetailSchema> detailSchema = detailSchemaRepository.findById(new DetailSchemaId(schemaId, detailId));
        if (detailSchema.isPresent()) {
            return detailSchema.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                String.format("Schema with ID %s doens't have detail with ID: %s",
                        schemaId,
                        detailId)
        );
    }
}
