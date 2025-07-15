package com.whatsapp.business.repository;

import com.whatsapp.business.entity.MediaMetadata;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MediaMetadataRepository extends R2dbcRepository<MediaMetadata, Long> {
    
    Mono<MediaMetadata> findByWhatsappMediaId(String whatsappMediaId);
    
    Flux<MediaMetadata> findByMessageId(Long messageId);
    
    @Query("SELECT * FROM media_metadata WHERE user_id = :userId AND is_downloaded = false AND download_attempts < 3")
    Flux<MediaMetadata> findPendingDownloads(String userId);
    
    @Query("UPDATE media_metadata SET is_downloaded = true, local_path = :localPath WHERE whatsapp_media_id = :whatsappMediaId")
    Mono<Void> markAsDownloaded(String whatsappMediaId, String localPath);
    
    @Query("UPDATE media_metadata SET download_attempts = download_attempts + 1, last_download_attempt = NOW() WHERE whatsapp_media_id = :whatsappMediaId")
    Mono<Void> incrementDownloadAttempts(String whatsappMediaId);
}