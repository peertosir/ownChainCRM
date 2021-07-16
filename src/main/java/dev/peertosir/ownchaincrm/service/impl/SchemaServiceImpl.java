package dev.peertosir.ownchaincrm.service.impl;

import dev.peertosir.ownchaincrm.domain.Schema;
import dev.peertosir.ownchaincrm.repository.SchemaRepository;
import dev.peertosir.ownchaincrm.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SchemaServiceImpl implements SchemaService {
    private final SchemaRepository schemaRepository;

    @Autowired
    public SchemaServiceImpl(SchemaRepository schemaRepository) {
        this.schemaRepository = schemaRepository;
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


}