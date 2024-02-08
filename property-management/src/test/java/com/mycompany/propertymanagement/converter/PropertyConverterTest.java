package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyConverterTest {

    @InjectMocks
    private PropertyConverter propertyConverter;

    @Test
    void testConvertDTOtoEntity_Success(){
        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("Mr");
        dto.setPrice(67.99);
        PropertyEntity pe = propertyConverter.convertDTOtoEntity(dto);
        Assertions.assertEquals(dto.getPrice(),pe.getPrice());
        Assertions.assertEquals(dto.getTitle(),pe.getTitle());
    }
    @Test
    void testConvertEntityToDTO_Success(){
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle("Mr");
        pe.setPrice(67.99);
        PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
        Assertions.assertEquals(pe.getPrice(),dto.getPrice());
        Assertions.assertEquals(pe.getTitle(),dto.getTitle());
    }
}
