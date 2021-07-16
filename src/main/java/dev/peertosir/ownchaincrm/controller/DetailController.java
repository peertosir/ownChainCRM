package dev.peertosir.ownchaincrm.controller;

import dev.peertosir.ownchaincrm.domain.Detail;
import dev.peertosir.ownchaincrm.service.DetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/details")
public class DetailController {
    private final DetailService detailService;
    private static final Logger LOGGER = LoggerFactory.getLogger(DetailController.class);

    @Autowired
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("")
    public List<Detail> getAllDetails() {
        LOGGER.info("Getting all Details");
        return detailService.getAllDetails();
    }

    @GetMapping("/{id}")
    public Detail getDetail(@PathVariable int id) {
        LOGGER.info("Getting Detail with ID: " + id);
        return detailService.getDetailById(id);
    }

    @PostMapping("")
    public int getAllDetails(@Valid @RequestBody Detail detail) {
        LOGGER.info("Creating Detail");
        int createdDetailId = detailService.createDetail(detail);
        LOGGER.info("Created Detail with ID: " + createdDetailId);
        return createdDetailId;
    }

    @PutMapping("/{id}")
    public int updateDetail(@Valid @RequestBody Detail detail, @PathVariable int id) {
        LOGGER.info("Updating Detail with ID: " + id);
        int updatedDetailId = detailService.updateDetail(detail, id);
        LOGGER.info("Detail with ID: " + updatedDetailId + "updated");
        return updatedDetailId;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDetail(@PathVariable int id) {
        LOGGER.info("Deleting Detail with ID: " + id);
        detailService.deleteDetail(id);
        LOGGER.info("Detail with ID: " + id + " deleted");
    }
}
