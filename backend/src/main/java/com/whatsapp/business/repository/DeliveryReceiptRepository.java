package com.whatsapp.business.repository;

import com.whatsapp.business.entity.DeliveryReceipt;
import com.whatsapp.business.enums.MessageStatus;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface DeliveryReceiptRepository extends R2dbcRepository<DeliveryReceipt, Long> {
    
    Flux<DeliveryReceipt> findByWhatsappMessageId(String whatsappMessageId);
    
    Flux<DeliveryReceipt> findByMessageId(Long messageId);
    
    Flux<DeliveryReceipt> findByRecipientPhoneAndStatus(String recipientPhone, MessageStatus status);
    
    Mono<DeliveryReceipt> findByWhatsappMessageIdAndRecipientPhone(String whatsappMessageId, String recipientPhone);
}