package com.whatsapp.business.dto.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactName {
    private String formattedName;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private String prefix;
}