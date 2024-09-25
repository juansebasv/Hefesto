package com.greek.hefesto.ports.input.controller;

import com.greek.hefesto.core.service.IpGeoService;
import com.greek.hefesto.ports.input.mapper.IpMapper;
import com.greek.hefesto.ports.input.response.IpResponse;
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
import jakarta.validation.constraints.NotEmpty;
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
@RequestMapping("/geo")
@AllArgsConstructor
@Observed
@Tag(name = "IP Geolocation", description = "API endpoints for IP geolocation services")
public class IpController {

    private IpGeoService ipGeoService;
    private IpMapper ipMapper;

    @Operation(summary = "Get geolocation information for an IP address",
            description = "Retrieves detailed geographical information based on the provided IP address.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = IpResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid IP address supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Geolocation information not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/{ip}/info")
    public IpResponse getIpGeoInfoByIp(
            @Parameter(description = "IP address to geolocate", required = true, example = "192.0.2.1")
            @Valid @NotBlank @NotEmpty @PathVariable("ip") @Size(min = 7, max = 15) String ip) {
            var ipGeoInfo = ipGeoService.getIpGeoInfoByIp(ip);
            return ipMapper.requestToDomain(ipGeoInfo);
    }
}