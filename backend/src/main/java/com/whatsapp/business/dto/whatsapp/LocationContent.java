package com.whatsapp.business.dto.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationContent {
    private double latitude;
    private double longitude;
    private String name;
    private String address;
}