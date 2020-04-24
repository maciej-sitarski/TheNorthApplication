package theNorthApplication.app.domain.googleApi.searcherClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Viewport {

    @JsonProperty("northeast")
    private Northeast northeast;

    @JsonProperty("southwest")
    private Southwest southwest;
}
