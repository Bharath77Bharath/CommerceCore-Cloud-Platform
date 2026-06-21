package com.bharath.Ecommerce.Controller;


import com.bharath.Ecommerce.Dto.Auth.LoginResponseDto;
import com.bharath.Ecommerce.Dto.Auth.LoginRequestDto;
import com.bharath.Ecommerce.Dto.Auth.RegisterRequestDto;
import com.bharath.Ecommerce.Dto.Auth.RegisterResponseDto;
import com.bharath.Ecommerce.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> registerUser(@RequestBody RegisterRequestDto registerRequestDto) {
        RegisterResponseDto registerResponseDto =  authService.registerUserService(registerRequestDto);

        return new ResponseEntity<>(registerResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = authService.verifyLogin(loginRequestDto);

        return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
    }

}
