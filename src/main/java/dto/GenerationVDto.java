package dto;


import com.google.gson.annotations.SerializedName;

public class GenerationVDto {
    public BlackWhiteDto getBlackWhite() {
        return blackWhite;
    }

    @SerializedName("black-white")
    public BlackWhiteDto blackWhite;
}
