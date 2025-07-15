package com.whatsapp.business.dto.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MediaMessageRequest {
    private String messagingProduct;
    private String to;
    private String type;
    private MediaContent image;
    private MediaContent video;
    private MediaContent audio;
    private MediaContent document;
}