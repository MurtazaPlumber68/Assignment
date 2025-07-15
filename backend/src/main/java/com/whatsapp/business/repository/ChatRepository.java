package com.whatsapp.business.repository;

import com.whatsapp.business.entity.Chat;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ChatRepository extends R2dbcRepository<Chat, Long> {
    
    Flux<Chat> findByUserIdOrderByUpdatedAtDesc(String userId, Pageable pageable);
    
    Flux<Chat> findByUserIdAndIsArchivedOrderByUpdatedAtDesc(String userId, Boolean isArchived, Pageable pageable);
    
    Mono<Chat> findByPhoneNumberAndUserId(String phoneNumber, String userId);
    
    @Query("SELECT * FROM chats WHERE user_id = :userId AND (contact_name ILIKE %:searchTerm% OR phone_number ILIKE %:searchTerm%) ORDER BY updated_at DESC")
    Flux<Chat> findByUserIdAndSearchTerm(String userId, String searchTerm, Pageable pageable);
    
    @Query("SELECT COUNT(*) FROM chats WHERE user_id = :userId AND unread_count > 0")
    Mono<Long> countUnreadChats(String userId);
    
    @Query("UPDATE chats SET unread_count = 0 WHERE id = :chatId AND user_id = :userId")
    Mono<Void> markChatAsRead(Long chatId, String userId);
}