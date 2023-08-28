package com.Authentication.SpringSecurity.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager")
@SecurityRequirement(name = "JWTBearer")
public class MangerController {

    @Operation(
            description = "Get endpoint for manager",
            summary = "This is a summary for management get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Operation on Endpoint was a success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized ",
                            responseCode = "403"
                    ),
                    @ApiResponse(
                            description = "Invalid Token",
                            responseCode = "403"
                    )
            }

    )
    @GetMapping
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("Example Read Endpoint for Manager");
    }

    @PutMapping
    public ResponseEntity<String> put(){
        return ResponseEntity.ok("Example Put Endpoint for Manager");
    }
    @PostMapping
    public ResponseEntity<String> post(){
        return ResponseEntity.ok("Example Create Endpoint for Manager");
    }
    @DeleteMapping
    public ResponseEntity<String> delete(){
        return ResponseEntity.ok("Example Delete Endpoint for Manager");
    }

}
