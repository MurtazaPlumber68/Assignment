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
public class WhatsAppMessageResponse {
    private String messagingProduct;
    private List<MessageContact> contacts;
    private List<MessageInfo> messages;
}