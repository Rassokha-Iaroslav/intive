package dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class OtherDto {
    public DreamWorldDto getDream_world() {
        return dream_world;
    }

    public OfficialArtworkDto getOfficialArtwork() {
        return officialArtwork;
    }

    public DreamWorldDto dream_world;
    @JsonProperty("official-artwork")
    public OfficialArtworkDto officialArtwork;
}
