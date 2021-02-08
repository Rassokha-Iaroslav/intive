package dto;


import com.google.gson.annotations.SerializedName;

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

    @SerializedName("diamond-pearl")
    public DiamondPearlDto diamondPearl;
    @SerializedName("heartgold-soulsilver")
    public HeartgoldSoulsilverDto heartgoldSoulsilver;
    public PlatinumDto platinum;
}
