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
public class ContactContent {
    private List<ContactAddress> addresses;
    private String birthday;
    private List<ContactEmail> emails;
    private ContactName name;
    private String org;
    private List<ContactPhone> phones;
    private List<ContactUrl> urls;
}