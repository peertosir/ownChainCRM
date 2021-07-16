package dev.peertosir.ownchaincrm.controller;

import dev.peertosir.ownchaincrm.domain.Detail;
import dev.peertosir.ownchaincrm.domain.Schema;
import dev.peertosir.ownchaincrm.service.SchemaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/schema")
public class SchemaController {

    private final SchemaService schemaService;
    private final Logger LOGGER = LoggerFactory.getLogger(SchemaController.class);

    @Autowired
    public SchemaController(SchemaService schemaService) {
        this.schemaService = schemaService;
    }

    @GetMapping("")
    public List<Schema> getAllSchemas() {
        LOGGER.info("Getting all Schemas");
        return schemaService.getAllSchemas();
    }

    @GetMapping("/{id}")
    public Schema getSchema(int id) {
        LOGGER.info("Getting Schema with ID: " + id);
        Schema schema = schemaService.getSchemaById(id);
        LOGGER.info("Schema with ID: " + id + " found. Returning...");
        return schema;
    }



}
