package com.whatsapp.business.dto.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateParameter {
    private String type;
    private String text;
    private MediaContent image;
    private MediaContent video;
    private MediaContent document;
}