package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @InjectMocks
    private PropertyController propertyController;

    @Mock
    private PropertyService propertyService;

    @Test
    @DisplayName("Testing Save Property")
    public void testSaveProperty(){
        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("ooga");
        PropertyDTO savedProperty = new PropertyDTO();
        savedProperty.setId(1L);
        savedProperty.setTitle("ooga");
        Mockito.when(propertyService.saveProperty(dto)).thenReturn(savedProperty);
        ResponseEntity<PropertyDTO> responseEntity = propertyController.saveProperty(dto);
        Assertions.assertEquals(1L, Objects.requireNonNull(responseEntity.getBody()).getId());
        Assertions.assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Testing Get All")
    void testGetAllProperties(){
        List<PropertyDTO> propertyList = new ArrayList<>();
        PropertyDTO dto = new PropertyDTO();
        dto.setId(1L);
        dto.setTitle("First Property");
        propertyList.add(dto);
        PropertyDTO dto_2 = new PropertyDTO();
        dto_2.setId(2L);
        dto_2.setTitle("Second Property");
        propertyList.add(dto_2);
        Mockito.when(propertyService.getAllProperties()).thenReturn(propertyList);
        ResponseEntity<List<PropertyDTO>> responseEntity = propertyController.getAllProperties();
        Assertions.assertEquals(2, Objects.requireNonNull(responseEntity.getBody()).size());
        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }
}
