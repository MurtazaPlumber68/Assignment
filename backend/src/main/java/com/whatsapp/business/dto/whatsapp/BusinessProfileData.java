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
public class BusinessProfileData {
    private String about;
    private String address;
    private String description;
    private String email;
    private String profilePictureUrl;
    private List<String> websites;
    private String vertical;
}