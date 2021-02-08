package dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class GenerationViiDto {
    public IconsDto getIcons() {
        return icons;
    }

    public UltraSunUltraMoonDto getUltraSunUltraMoon() {
        return ultraSunUltraMoon;
    }

    public IconsDto icons;
    @JsonProperty("ultra-sun-ultra-moon")
    public UltraSunUltraMoonDto ultraSunUltraMoon;
}
