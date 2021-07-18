package dev.peertosir.ownchaincrm.controller;

import dev.peertosir.ownchaincrm.domain.Schema;
import dev.peertosir.ownchaincrm.dto.request.DetailAmountInSchemaRequestModel;
import dev.peertosir.ownchaincrm.dto.request.DetailSchemaRequestModel;
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
    public Schema getSchema(@PathVariable long id) {
        LOGGER.info("Getting Schema with ID: " + id);
        Schema schema = schemaService.getSchemaById(id);
        LOGGER.info("Schema with ID: " + id + " found. Returning...");
        return schema;
    }

    @PostMapping("")
    public long createSchema(@Valid @RequestBody Schema schema) {
        LOGGER.info("Creating new Schema");
        Long createdSchemaId = schemaService.createSchema(schema);
        LOGGER.info("New Schema with ID: " + createdSchemaId + " created");
        return createdSchemaId;
    }

    @PutMapping("/{id}")
    public long updateSchema(@Valid @RequestBody Schema schema, @PathVariable long id) {
        LOGGER.info("Updating Schema with ID: " + id);
        long updatedSchemaId = schemaService.updateSchema(schema, id);
        LOGGER.info("Schema with ID: " + updatedSchemaId + " updated");
        return updatedSchemaId;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSchema(@PathVariable long id) {
        schemaService.deleteSchema(id);
    }

    @PostMapping("/{id}/detail")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDetailToSchema(
            @Valid @RequestBody DetailSchemaRequestModel dto,
            @PathVariable long id) {
        LOGGER.info(String.format("Adding new detail with ID: %s to schema with ID: %s",
                dto.getDetailId(),
                id));
        schemaService.addDetailToSchema(id, dto);
    }

    @DeleteMapping("/{id}/detail/{detailId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteDetailFromSchema(
            @PathVariable long id,
            @PathVariable long detailId) {
        LOGGER.info(String.format("Deleting detail with ID: %s from schema with ID: %s",
                detailId,
                id));
        schemaService.deleteDetailFromSchema(id, detailId);
    }

    @PutMapping("/{id}/detail/{detailId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDetailInSchema(
            @PathVariable long id,
            @PathVariable long detailId,
            @Valid @RequestBody DetailAmountInSchemaRequestModel amount) {
        LOGGER.info(String.format("Updating detail with ID: %s from schema with ID: %s",
                detailId,
                id));
        schemaService.updateDetailInSchema(id, detailId, amount);
    }
}
