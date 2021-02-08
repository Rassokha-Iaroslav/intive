package dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class GenerationIvDto {
    public DiamondPearlDto getDiamondPearl() {
        return diamondPearl;
    }

    public HeartgoldSoulsilverDto getHeartgoldSoulsilver() {
        return heartgoldSoulsilver;
    }

    public PlatinumDto getPlatinum() {
        return platinum;
    }

    @JsonProperty("diamond-pearl")
    public DiamondPearlDto diamondPearl;
    @JsonProperty("heartgold-soulsilver")
    public HeartgoldSoulsilverDto heartgoldSoulsilver;
    public PlatinumDto platinum;
}
