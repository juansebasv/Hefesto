package com.greek.hefesto.ports.input.controller;

import com.greek.hefesto.core.service.NameService;
import com.greek.hefesto.ports.input.mapper.NameMapper;
import com.greek.hefesto.ports.input.response.NameResponse;
import io.micrometer.observation.annotation.Observed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/discover")
@AllArgsConstructor
@Observed
@Tag(name = "Name Nationality", description = "API for discovering nationality information based on names")
public class NameController {

    private final NameService nameService;
    private final NameMapper nameMapper;

    @Operation(summary = "Get nationality information by name",
            description = "Retrieves nationality information for a given name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = NameResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid name supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Nationality information not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/{name}/info")
    public NameResponse getNationalityByName(
            @Parameter(description = "Name to get nationality information for", required = true, example = "John")
            @Valid @NotBlank @PathVariable("name") @Size(min = 3, max = 20) String name) {
        log.info("Received request to get nationality information for name: {}", name);
        var nameDO = nameService.getNationalityByName(name);
        var response = nameMapper.requestToDomain(nameDO);
        log.info("Returning nationality information for name: {}", name);
        return response;
    }
}