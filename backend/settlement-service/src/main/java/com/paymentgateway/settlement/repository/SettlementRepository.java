package com.paymentgateway.settlement.repository;

import com.paymentgateway.settlement.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SettlementRepository
        extends JpaRepository<Settlement, Long> {

    Optional<Settlement> findBySettlementId(
            String settlementId);

    List<Settlement> findByMerchantId(
            Long merchantId);

    List<Settlement> findByStatus(
            String status);

    List<Settlement> findByMerchantIdAndStatus(
            Long merchantId,
            String status);
}