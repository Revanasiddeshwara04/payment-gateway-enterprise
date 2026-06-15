package com.paymentgateway.merchant.controller;

import com.paymentgateway.merchant.dto.CreateMerchantRequest;
import com.paymentgateway.merchant.service.MerchantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.paymentgateway.merchant.entity.Merchant;
import java.util.List;
import com.paymentgateway.merchant.dto.UpdateMerchantRequest;

@RestController
@RequestMapping("/api/v1/merchants")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(
            MerchantService merchantService) {

        this.merchantService = merchantService;
    }

    @PostMapping
    public String createMerchant(
            @Valid @RequestBody CreateMerchantRequest request) {

        return merchantService.createMerchant(request);
    }
    @GetMapping("/{id}")
    public Merchant getMerchantById(@PathVariable  Long id){
        return  merchantService.getMerchantById(id);

    }

    @GetMapping
    public List<Merchant>getAllMerchants(){
        return merchantService.getAllMerchants();
    }

    @PutMapping("/{id}")
    public String updateMerchant(@PathVariable Long id,
                                 @RequestBody UpdateMerchantRequest request){
        return merchantService.updateMerchant(id,request);
    }

    @DeleteMapping("/{id}")
    public String deleteMerchant(@PathVariable Long id){
        return merchantService.deleteMerchant(id);
    }

    @PutMapping("/{id}/activate")
    public String activateMerchant(@PathVariable Long id){
        return merchantService.activateMerchant(id);
    }
    @PutMapping("/{id}/deactivate")
    public String deactivateMerchant(@PathVariable Long id){
        return merchantService.deactivateMerchant(id);
    }
}