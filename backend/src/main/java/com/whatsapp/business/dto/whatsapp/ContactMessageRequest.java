package com.whatsapp.business.dto.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessageRequest {
    private String messagingProduct;
    private String to;
    private String type;
    private List<ContactContent> contacts;
}