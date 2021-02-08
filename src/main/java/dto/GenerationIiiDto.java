package dto;


import com.google.gson.annotations.SerializedName;

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
    @SerializedName("firered-leafgreen")
    public FireredLeafgreenDto fireredLeafgreen;
    @SerializedName("ruby-sapphire")
    public RubySapphireDto rubySapphire;
}
