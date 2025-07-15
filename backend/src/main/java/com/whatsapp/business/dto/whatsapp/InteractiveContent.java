package com.whatsapp.business.dto.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InteractiveContent {
    private String type;
    private InteractiveHeader header;
    private InteractiveBody body;
    private InteractiveFooter footer;
    private InteractiveAction action;
}