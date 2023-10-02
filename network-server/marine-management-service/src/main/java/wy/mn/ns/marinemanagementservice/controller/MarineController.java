package wy.mn.ns.marinemanagementservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wy.mn.ns.marinemanagementservice.dto.ErrorResponseDto;
import wy.mn.ns.marinemanagementservice.dto.MarineCreationDTO;
import wy.mn.ns.marinemanagementservice.dto.MarineDTO;
import wy.mn.ns.marinemanagementservice.dto.ResponseDto;
import wy.mn.ns.marinemanagementservice.service.MarineService;

import java.text.MessageFormat;

@Tag(
        name = "CRUD REST APIs for Marine Creation in Weyland-Yutani Network",
        description = "CRUD REST APIs in Weyland-Yutani Network to CREATE, UPDATE, FETCH AND DELETE marine details"
)
@RequestMapping(path = "/api/v1/marines", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
@AllArgsConstructor
public class MarineController {

    private final MarineService marineService;

    @Operation(
            summary = "Create Marine REST API",
            description = "REST API to create new Marine inside Weyland-Yutani Network"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    public ResponseEntity<MarineDTO> createMarine(@RequestBody MarineCreationDTO creationDTO) {
        MarineDTO marineDTO = marineService.createMarine(creationDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(marineDTO);
    }

    @Operation(
            summary = "Update Marine Details REST API",
            description = "REST API to update Marine details based on MarineDTO"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PutMapping("/update")
    public ResponseEntity<MarineDTO> updateMarine(@RequestBody MarineDTO marineDTO) {
        MarineDTO updatedDto = marineService.updateMarine(marineDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(updatedDto);
    }

    @Operation(
            summary = "Fetch Marine Details REST API",
            description = "REST API to fetch Marine details based on ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/get/{id}")
    public ResponseEntity<MarineDTO> getMarineById(@PathVariable("id") Long id) {
        MarineDTO marineDTO = marineService.fetchMarine(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(marineDTO);
    }

    @Operation(
            summary = "Delete Marine from database",
            description = "REST API to delete Marine details with ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteMarineById(@PathVariable("id") Long id) {
        marineService.deleteMarine(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK.value(),
                        MessageFormat.format("Marine with id {0} was deleted", id)));
    }
}