package com.connected.cars.Controller;

import com.connected.cars.domain.Consumer;
import com.connected.cars.domain.FileType;
import com.connected.cars.service.ConsumerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/v1/consumer")
@Tag(name = "Consumer Application")
public class ConsumerController {

    private final ConsumerService service;

    public ConsumerController(ConsumerService service) {
        this.service = service;
    }


    @Transactional
    @PostMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    @Operation(method = "POST", summary = "Stores the data",
    description = "API to store consumer data")
    public ResponseEntity<Long> store(@RequestBody  Consumer consumer, @Parameter(
            description = "Name of file type",
            array = @ArraySchema(schema = @Schema(type = "string", allowableValues = {"CSV", "XML"}))
    ) @PathVariable("fileType") FileType fileType) {

        return ResponseEntity.ok(service.save(consumer, fileType));
    }
}
