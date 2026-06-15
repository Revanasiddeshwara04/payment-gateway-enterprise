package com.paymentgateway.merchant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMerchantRequest {

    private String businessName;
    private String ownerName;
    private String phone;
    private String website;
}