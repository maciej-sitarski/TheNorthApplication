package theNorthApplication.app.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import theNorthApplication.app.api.searcherClasses.Results;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResults {

    @JsonProperty("next_page_token")
    private String nextPageToken;

    @JsonProperty("results")
    private List<Results> resultsList;

}
