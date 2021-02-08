package dto;


import com.google.gson.annotations.SerializedName;

public class GenerationViiDto {
    public IconsDto getIcons() {
        return icons;
    }

    public UltraSunUltraMoonDto getUltraSunUltraMoon() {
        return ultraSunUltraMoon;
    }

    public IconsDto icons;
    @SerializedName("ultra-sun-ultra-moon")
    public UltraSunUltraMoonDto ultraSunUltraMoon;
}
