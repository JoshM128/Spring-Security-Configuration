package com.Authentication.SpringSecurity.Controllers;

import com.Authentication.SpringSecurity.DTO.UpdateUserByIDRequest;
import com.Authentication.SpringSecurity.DTO.UserDTO;
import com.Authentication.SpringSecurity.Service.RoleService.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo")
@SecurityRequirement(name = "JWTBearer")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Operation(
            description = "Get endpoint for user",
            summary = "Returns the user by its ID",
            parameters = {
                    @Parameter(
                            name = "userID",
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
    @GetMapping("/get/{userID}")
    public ResponseEntity<UserDTO> getUser(@PathVariable ("userID") int userID){
        return ResponseEntity.ok(userService.getUserByID(userID));
    }

    @Operation(
            description = "Update the user information by user ID",
            summary = "Returns the update user",
            parameters = {
                    @Parameter(
                            name = "userID",
                            required = true,
                            description = "param description"
                    ),
                    @Parameter(
                            name = "userDTO",
                            required = true,
                            description = "the desired values to be update for the user"
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
    @PutMapping("/update/{userID}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UpdateUserByIDRequest userDTO,
                                              @PathVariable ("userID") int userID){
        return ResponseEntity.ok(userService.updateUserByID(userDTO,userID));
    }

    @Operation(
            description = "Delete the user by its ID",
            summary = "Returns a string upon success",
            parameters = {
                    @Parameter(
                            name = "userID",
                            required = true,
                            description = "The ID of the user that needs to be deleted"
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
    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<String> deleteUserByID(@PathVariable ("userID") int userID){
        userService.deleteUser(userID);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
