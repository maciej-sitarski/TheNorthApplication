package theNorthApplication.app.dto;

import lombok.Data;
import theNorthApplication.app.api.SearchResults;
import theNorthApplication.app.api.searcherClasses.Results;

import java.util.List;

@Data
public class StoreDto {

    String name;

    String street;

    String town;

    String country;

    String id;




}