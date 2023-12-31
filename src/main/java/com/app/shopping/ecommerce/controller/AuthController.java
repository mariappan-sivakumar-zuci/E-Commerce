package com.app.shopping.ecommerce.controller;

import com.app.shopping.ecommerce.payload.AdminRegistrationDto;
import com.app.shopping.ecommerce.payload.JWTAuthResponse;
import com.app.shopping.ecommerce.payload.LoginDto;
import com.app.shopping.ecommerce.payload.SupplierPassword;
import com.app.shopping.ecommerce.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication Controller", description = "APIs for Authentication like login, register, etc.")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

//    Build Login Rest Api
    @Operation(summary = "Login", description = "Login with email and password")
    @ApiResponse(responseCode = "200", description = "Login successfully")
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }
    @PostMapping("/admin/register")
    @Operation(summary = "Register Admin", description = "Register Admin admin with 3 roles")
    @ApiResponse(responseCode = "200", description = "Admin registered successfully")
    public ResponseEntity<AdminRegistrationDto> registerAdmin(@RequestBody AdminRegistrationDto adminRegistrationDto){
        return ResponseEntity.ok(authService.registerAdmin(adminRegistrationDto));
    }
    @Operation(summary = "Get All Admins", description = "Get All Admins Details")
    @GetMapping("/admin/all")
    public ResponseEntity<List<AdminRegistrationDto>> getAllAdmins(){
        return ResponseEntity.ok(authService.getAllAdmins());
    }

    @Operation(summary = "Update Supplier Password", description = "Update Supplier Password")
    @PutMapping("/supplier/{id}")
    public ResponseEntity<String> updateSupplierPassword(@PathVariable Long id, @RequestBody SupplierPassword supplierPassword){
        return ResponseEntity.ok(authService.setSupplierPassword(id, supplierPassword));
    }
}
