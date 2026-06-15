package com.paymentgateway.merchant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMerchantRequest {

    @NotBlank
    private String businessName;

    @NotBlank
    private String ownerName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    private String website;
}