package theNorthApplication.app.dto;

import lombok.Data;

@Data
public class StoreDto {

    String id;
    String name;
    String street;
    String town;
    String country;
    String lat;
    String lng;
    StoreEntityDto storeEntityDto;
}
