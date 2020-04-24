package theNorthApplication.app.api.searcherClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Northeast {

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;
}
