package dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class GenerationVDto {
    public BlackWhiteDto getBlackWhite() {
        return blackWhite;
    }

    @JsonProperty("black-white")
    public BlackWhiteDto blackWhite;
}
