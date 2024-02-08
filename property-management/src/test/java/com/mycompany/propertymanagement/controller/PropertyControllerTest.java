package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @InjectMocks
    private PropertyController propertyController;

    @Test
    @DisplayName("Testing Save Property")
    public void testSaveProperty(){
        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("ooga");
        dto.setAddress("addures");
        dto.setPrice(40.33);
        dto.setDescription("hahahha");
        dto.setOwnerName("chungus");
        dto.setOwnerEmail("amoongus@gg.co");
        ResponseEntity<PropertyDTO> responseEntity = propertyController.saveProperty(dto);
        Assertions.assertNotNull(responseEntity.getBody().getId());
    }
}
