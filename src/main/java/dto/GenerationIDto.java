package dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class GenerationIDto {
    public RedBlueDto getRedBlue() {
        return redBlue;
    }

    public YellowDto getYellow() {
        return yellow;
    }

    @JsonProperty("red-blue")
    public RedBlueDto redBlue;
    public YellowDto yellow;
}
