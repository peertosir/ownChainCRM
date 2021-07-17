package dev.peertosir.ownchaincrm.controller;

import dev.peertosir.ownchaincrm.domain.Schema;
import dev.peertosir.ownchaincrm.dto.request.DetailSchemaRequestDto;
import dev.peertosir.ownchaincrm.service.SchemaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Schema getSchema(@PathVariable int id) {
        LOGGER.info("Getting Schema with ID: " + id);
        Schema schema = schemaService.getSchemaById(id);
        LOGGER.info("Schema with ID: " + id + " found. Returning...");
        return schema;
    }

    @PostMapping("")
    public int createSchema(@Valid @RequestBody Schema schema) {
        LOGGER.info("Creating new Schema");
        int createdSchemaId = schemaService.createSchema(schema);
        LOGGER.info("New Schema with ID: " + createdSchemaId + " created");
        return createdSchemaId;
    }

    @PutMapping("/{id}")
    public int updateSchema(@Valid @RequestBody Schema schema, @PathVariable int id) {
        LOGGER.info("Updating Schema with ID: " + id);
        int updatedSchemaId = schemaService.updateSchema(schema, id);
        LOGGER.info("Schema with ID: " + updatedSchemaId + "updated");
        return updatedSchemaId;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSchema(@PathVariable int id) {
        schemaService.deleteSchema(id);
    }

    @PostMapping("/{id}/add-detail")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDetailToSchema(@Valid @RequestBody DetailSchemaRequestDto dto, @PathVariable int id) {
        LOGGER.info(String.format("Adding new detail with ID: %s to schema with ID: %s",
                dto.getDetailId(),
                id));
        schemaService.addDetailToSchema(id, dto);
    }

    @DeleteMapping("/{id}/delete-detail/{detailId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteDetailFromSchema(@PathVariable int id, @PathVariable int detailId) {
        LOGGER.info(String.format("Deleting detail with ID: %s from schema with ID: %s",
                detailId,
                id));
        schemaService.deleteDetailFromSchema(id, detailId);
    }

}
