package theNorthApplication.app.domain.googleApi.searcherClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Southwest {

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;
}
