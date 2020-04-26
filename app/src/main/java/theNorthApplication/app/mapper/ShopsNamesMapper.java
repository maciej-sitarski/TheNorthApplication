package theNorthApplication.app.mapper;

import org.springframework.stereotype.Component;
import theNorthApplication.app.dto.ShopNameDto;
import theNorthApplication.app.entity.ShopsNames;

@Component
public class ShopsNamesMapper {

    public ShopNameDto mapShopToDto(ShopsNames shopsNames){
        ShopNameDto shopNameDto = new ShopNameDto();
        shopNameDto.setName(shopsNames.getName());
        shopNameDto.setType(shopsNames.getType());
        return shopNameDto;
    }
}
