package com.whatsapp.business.dto.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MediaDownloadResponse {
    private String url;
    private String mimeType;
    private String sha256;
    private Long fileSize;
    private String id;
}