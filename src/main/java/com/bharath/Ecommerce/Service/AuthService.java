package com.bharath.Ecommerce.Service;


import com.bharath.Ecommerce.Dto.Auth.LoginResponseDto;
import com.bharath.Ecommerce.Dto.Auth.LoginRequestDto;
import com.bharath.Ecommerce.Dto.Auth.RegisterRequestDto;
import com.bharath.Ecommerce.Dto.Auth.RegisterResponseDto;
import com.bharath.Ecommerce.Repository.UserRepository;
import com.bharath.Ecommerce.Security.JwtService;
import com.bharath.Ecommerce.Entity.Users;
import com.bharath.Ecommerce.Security.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public RegisterResponseDto registerUserService(RegisterRequestDto registerRequestDto) {

        if(userRepository.findByEmail(registerRequestDto.getEmail()).isPresent()) {
            throw  new RuntimeException("Email already exists");
        }

        Users user = new Users();

        user.setName(registerRequestDto.getName());
        user.setEmail(registerRequestDto.getEmail());
        user.setPassword(
                passwordEncoder.encode(registerRequestDto.getPassword())
        );
        user.setRole(Role.USER);

        Users savedUser = userRepository.save(user);

        return new RegisterResponseDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                "Registration Successful"
        );
    }

    public LoginResponseDto verifyLogin(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),loginRequestDto.getPassword()));

        if(authentication.isAuthenticated()) {

            String token = jwtService.generateToken(loginRequestDto.getEmail());
            return new LoginResponseDto(
                    token,
                    "Login Successful"
            );
        }

        throw new RuntimeException("Login failed");
    }
}
