package com.andersen.onlinestore.dto.response;

import lombok.Builder;

@Builder
public record ClientResponseDto(String name, String surname, String phoneNumber, String email, Boolean discount) {
}
