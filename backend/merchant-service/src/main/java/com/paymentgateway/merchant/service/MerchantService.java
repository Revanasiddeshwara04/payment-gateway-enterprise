package com.paymentgateway.merchant.service;

import com.paymentgateway.merchant.dto.CreateMerchantRequest;
import com.paymentgateway.merchant.entity.Merchant;
import com.paymentgateway.merchant.repository.MerchantRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.paymentgateway.merchant.dto.UpdateMerchantRequest;

@Service
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantService(
            MerchantRepository merchantRepository) {

        this.merchantRepository = merchantRepository;
    }

    public String createMerchant(
            CreateMerchantRequest request) {

        if (merchantRepository.existsByEmail(
                request.getEmail())) {

            throw new RuntimeException(
                    "Merchant already exists");
        }

        Merchant merchant = new Merchant();

        merchant.setBusinessName(
                request.getBusinessName());

        merchant.setOwnerName(
                request.getOwnerName());

        merchant.setEmail(
                request.getEmail());

        merchant.setPhone(
                request.getPhone());

        merchant.setWebsite(
                request.getWebsite());

        merchant.setStatus("ACTIVE");

        merchantRepository.save(merchant);

        return "Merchant Created Successfully";
    }

    public Merchant getMerchantById(Long id) {

        return merchantRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Merchant not found"));
    }

    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

    public String deleteMerchant(Long id) {

        Merchant merchant =
                merchantRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Merchant not found"));

        merchantRepository.delete(merchant);

        return "Merchant Deleted Successfully";
    }

    public String activateMerchant(Long id) {

        Merchant merchant =
                merchantRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Merchant not found"));

        merchant.setStatus("ACTIVE");

        merchantRepository.save(merchant);

        return "Merchant Activated";
    }

    public String deactivateMerchant(Long id) {

        Merchant merchant =
                merchantRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Merchant not found"));

        merchant.setStatus("INACTIVE");

        merchantRepository.save(merchant);

        return "Merchant Deactivated";
    }

    public String updateMerchant(
            Long id,
            UpdateMerchantRequest request) {

        Merchant merchant =
                merchantRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Merchant not found"));

        merchant.setBusinessName(
                request.getBusinessName());

        merchant.setOwnerName(
                request.getOwnerName());

        merchant.setPhone(
                request.getPhone());

        merchant.setWebsite(
                request.getWebsite());

        merchantRepository.save(merchant);

        return "Merchant Updated Successfully";
    }
}