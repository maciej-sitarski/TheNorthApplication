package theNorthApplication.app.mapper;

import org.springframework.stereotype.Component;
import theNorthApplication.app.dto.ShopNameDto;
import theNorthApplication.app.entity.ShopsNames;

import java.util.Optional;

@Component
public class ShopsNamesMapper {

    public ShopNameDto mapShopToDto(ShopsNames shopsNames) {

        String name = Optional.ofNullable(shopsNames)
                .map(ShopsNames::getName)
                .orElse(null);

        String type = Optional.ofNullable(shopsNames)
                .map(ShopsNames::getType)
                .orElse(null);

        ShopNameDto shopNameDto = new ShopNameDto();

        shopNameDto.setName(name);
        shopNameDto.setType(type);

        return shopNameDto;
    }
}
