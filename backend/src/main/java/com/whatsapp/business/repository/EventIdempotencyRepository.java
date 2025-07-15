package com.whatsapp.business.repository;

import com.whatsapp.business.entity.EventIdempotency;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EventIdempotencyRepository extends R2dbcRepository<EventIdempotency, Long> {
    
    Mono<EventIdempotency> findByEventId(String eventId);
    
    Mono<Boolean> existsByEventId(String eventId);
}