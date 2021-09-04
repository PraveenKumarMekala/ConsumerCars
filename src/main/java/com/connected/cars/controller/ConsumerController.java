package com.connected.cars.controller;

import com.connected.cars.domain.Consumer;
import com.connected.cars.domain.FileType;
import com.connected.cars.response.ConsumerResponse;
import com.connected.cars.service.ConsumerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api/v1")
@Tag(name = "Consumer Application")
public class ConsumerController {

    private final ConsumerService service;

    public ConsumerController(ConsumerService service) {
        this.service = service;
    }


    @Transactional
    @PostMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    @Operation(method = "POST", summary = "Stores the data",
    description = "API to consume user data and send to other service")
    public ResponseEntity<Long> store(@Valid  @RequestBody Consumer consumer, @Parameter(
            description = "Name of file type",
            array = @ArraySchema(schema = @Schema(type = "string", allowableValues = {"CSV", "XML"}))
    ) @PathVariable("fileType") FileType fileType) {

        return status(HttpStatus.CREATED).body(service.save(consumer, fileType));
    }

    @GetMapping("/consumers")
    @Operation(method = "GET", summary = "Used to retrieve all consumer details")
    public ResponseEntity<ConsumerResponse> consumers() {
        return ok(service.getAllConsumers());
    }

    @PutMapping(produces = {APPLICATION_JSON_VALUE}, path = {"/id"})
    @Operation(method = "PUT", summary = "Update existing consumer")
    public ResponseEntity<Consumer> updateExistingCoustmer(@PathVariable Long id) {
        return ok(service.updateConsumer(id));
    }
}
