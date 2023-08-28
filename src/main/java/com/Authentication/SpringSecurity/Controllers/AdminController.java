package com.Authentication.SpringSecurity.Controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('Admin')")
@SecurityRequirement(name = "JWTBearer")
public class AdminController {



    @Operation(
            description = "Get endpoint for admin",
            summary = "This is a example summary for admin get endpoint",
            parameters = {
                    @Parameter(
                            name = "adminID",
                            required = true,
                            description = "param description"
                    )
            },
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
    @GetMapping("/GET/{AdminID}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<String> get(
            @PathVariable(value = "AdminID") int AdminID){

        return new ResponseEntity<>("Example Read Endpoint for Admin "+AdminID, HttpStatus.OK);
    }

    @Operation(
            description = "Put endpoint for admin",
            summary = "This is an example summary for admin put endpoint",
            parameters = {
                    @Parameter(
                            name = "Admin Name",
                            required = true,
                            description = "param description"
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Operation on Endpoint was created",
                            responseCode = "201"
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
    @PutMapping("/PUT/{AdminName}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<String> put(
            @PathVariable(value = "AdminName") String AdminName
    ){
        return new ResponseEntity<>("Example Update Endpoint for Admin "+AdminName, HttpStatus.CREATED);
    }

    @Operation(
            description = "Post endpoint for admin",
            summary = "This is a summary for admin get endpoint",
            parameters = {
                    @Parameter(
                            name = "Admin Name",
                            required = true,
                            description = "param description"
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Operation on Endpoint was a created",
                            responseCode = "201"
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
    @PostMapping("/POST/{AdminName}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<String> post(@PathVariable String AdminName){
        return new ResponseEntity<>("Example Create Endpoint for Admin "+AdminName, HttpStatus.CREATED);
    }

    @Operation(
            description = "Delete endpoint for admin",
            summary = "This is a example summary for admin delete endpoint",
            parameters = {
                    @Parameter(
                            name = "adminID",
                            required = true,
                            description = "param description"
                    )
            },
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
    @DeleteMapping("/DELETE/{AdminID}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<String> delete(@PathVariable String AdminID){
        return new ResponseEntity<>("Example Delete Endpoint for Admin "+ AdminID, HttpStatus.OK);
    }

}
