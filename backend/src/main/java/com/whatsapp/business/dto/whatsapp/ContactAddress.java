package com.whatsapp.business.dto.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactAddress {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String countryCode;
    private String type;
}