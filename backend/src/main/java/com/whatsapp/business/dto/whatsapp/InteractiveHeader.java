package com.whatsapp.business.dto.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InteractiveHeader {
    private String type;
    private String text;
    private MediaContent video;
    private MediaContent image;
    private MediaContent document;
}