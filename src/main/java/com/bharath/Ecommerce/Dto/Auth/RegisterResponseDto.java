package com.bharath.Ecommerce.Dto.Auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDto {

    private Integer id;
    private String name;
    private String email;
    private String message;

}
