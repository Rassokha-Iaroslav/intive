package dto;

import com.google.gson.annotations.SerializedName;

public class OtherDto {
    public DreamWorldDto getDream_world() {
        return dream_world;
    }

    public OfficialArtworkDto getOfficialArtwork() {
        return officialArtwork;
    }

    public DreamWorldDto dream_world;

    @SerializedName("official-artwork")
    public OfficialArtworkDto officialArtwork;
}
