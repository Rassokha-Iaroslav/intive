package dto;

import com.google.gson.annotations.SerializedName;

public class GenerationIDto {
    public RedBlueDto getRedBlue() {
        return redBlue;
    }

    public YellowDto getYellow() {
        return yellow;
    }

    @SerializedName("red-blue")
    public RedBlueDto redBlue;
    public YellowDto yellow;
}
