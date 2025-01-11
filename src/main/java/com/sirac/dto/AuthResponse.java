package com.sirac.dto;

import com.sirac.model.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    @NotEmpty
    private String accessToken;

    @NotEmpty
    private String refreshToken;

    private User user;
}
