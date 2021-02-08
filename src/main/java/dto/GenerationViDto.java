package dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class GenerationViDto {
    public OmegarubyAlphasapphireDto getOmegarubyAlphasapphire() {
        return omegarubyAlphasapphire;
    }

    public XYDto getxY() {
        return xY;
    }

    @JsonProperty("omegaruby-alphasapphire")
    public OmegarubyAlphasapphireDto omegarubyAlphasapphire;
    @JsonProperty("x-y")
    public XYDto xY;
}
