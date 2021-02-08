package dto;

import com.google.gson.annotations.SerializedName;

public class GenerationViDto {
    public OmegarubyAlphasapphireDto getOmegarubyAlphasapphire() {
        return omegarubyAlphasapphire;
    }

    public XYDto getxY() {
        return xY;
    }

    @SerializedName("omegaruby-alphasapphire")
    public OmegarubyAlphasapphireDto omegarubyAlphasapphire;
    @SerializedName("x-y")
    public XYDto xY;
}
