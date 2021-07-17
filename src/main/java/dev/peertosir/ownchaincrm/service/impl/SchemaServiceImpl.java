package dev.peertosir.ownchaincrm.service.impl;

import dev.peertosir.ownchaincrm.domain.Detail;
import dev.peertosir.ownchaincrm.domain.Schema;
import dev.peertosir.ownchaincrm.dto.request.DetailSchemaRequestDto;
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

    @Autowired
    public SchemaServiceImpl(
            SchemaRepository schemaRepository,
            DetailService detailService
            ) {
        this.schemaRepository = schemaRepository;
        this.detailService = detailService;
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
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Schema with ID: " + id + "not found");
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
    public void addDetailToSchema(int id, DetailSchemaRequestDto dto) {
        Schema schema = getSchemaById(id);
        Detail detail = detailService.getDetailById(dto.getDetailId());
        schema.addDetail(detail, dto.getAmount());
        schemaRepository.save(schema);
    }

    @Override
    public void deleteDetailFromSchema(int id, int detailId) {
        Schema schema = getSchemaById(id);
        Detail detail = detailService.getDetailById(detailId);
        schema.removeDetail(detail);
        schemaRepository.save(schema);
    }
}
