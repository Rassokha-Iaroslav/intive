package dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class GenerationIiiDto {
    public EmeraldDto getEmerald() {
        return emerald;
    }

    public FireredLeafgreenDto getFireredLeafgreen() {
        return fireredLeafgreen;
    }

    public RubySapphireDto getRubySapphire() {
        return rubySapphire;
    }

    public EmeraldDto emerald;
    @JsonProperty("firered-leafgreen")
    public FireredLeafgreenDto fireredLeafgreen;
    @JsonProperty("ruby-sapphire")
    public RubySapphireDto rubySapphire;
}
