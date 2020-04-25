package theNorthApplication.app.service;

import org.springframework.stereotype.Service;
import theNorthApplication.app.dto.ShopNameDto;
import theNorthApplication.app.dto.TownsDto;
import theNorthApplication.app.mapper.ShopsNamesMapper;
import theNorthApplication.app.repositories.ShopsNamesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopsNamesService {

    private final ShopsNamesRepository shopsNamesRepository;
    private final ShopsNamesMapper shopsNamesMapper;


    public ShopsNamesService(ShopsNamesRepository shopsNamesRepository, ShopsNamesMapper shopsNamesMapper) {
        this.shopsNamesRepository = shopsNamesRepository;
        this.shopsNamesMapper = shopsNamesMapper;
    }

    public List<ShopNameDto> getShopsNames(){
        List<ShopNameDto> shopNames = new ArrayList<>();
        shopsNamesRepository.findAll().forEach(shopsNames -> shopNames.add(shopsNamesMapper.mapShopToDto(shopsNames)));
        return shopNames;
    }

    public List<String> getAutocompleteShopList(String shop){
        return  getShopsNames().stream().filter(shopNameDto->shopNameDto.getName().toLowerCase().startsWith(shop.toLowerCase())).map(ShopNameDto::getName).collect(Collectors.toList());
    }
 }
