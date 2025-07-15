package com.whatsapp.business.repository;

import com.whatsapp.business.entity.Message;
import com.whatsapp.business.enums.MessageStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public interface MessageRepository extends R2dbcRepository<Message, Long> {
    
    Flux<Message> findByChatIdOrderByTimestampDesc(Long chatId, Pageable pageable);
    
    @Query("SELECT * FROM messages WHERE chat_id = :chatId AND timestamp < :before ORDER BY timestamp DESC")
    Flux<Message> findByChatIdAndTimestampBeforeOrderByTimestampDesc(Long chatId, LocalDateTime before, Pageable pageable);
    
    Mono<Message> findByWhatsappMessageId(String whatsappMessageId);
    
    @Query("SELECT * FROM messages WHERE user_id = :userId AND content ILIKE %:searchTerm% ORDER BY timestamp DESC")
    Flux<Message> searchMessages(String userId, String searchTerm, Pageable pageable);
    
    @Query("UPDATE messages SET status = :status, delivered_at = :deliveredAt WHERE whatsapp_message_id = :whatsappMessageId")
    Mono<Void> updateMessageStatus(String whatsappMessageId, MessageStatus status, LocalDateTime deliveredAt);
    
    @Query("UPDATE messages SET read_at = :readAt WHERE whatsapp_message_id = :whatsappMessageId")
    Mono<Void> markMessageAsRead(String whatsappMessageId, LocalDateTime readAt);
    
    @Query("SELECT COUNT(*) FROM messages WHERE chat_id = :chatId AND is_from_business = false AND read_at IS NULL")
    Mono<Long> countUnreadMessages(Long chatId);
    
    Flux<Message> findByChatIdAndIsFromBusinessFalseAndReadAtIsNull(Long chatId);
}