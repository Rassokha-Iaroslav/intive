package dto;

import com.google.gson.annotations.SerializedName;

public class VersionsDto {
    public GenerationIDto getGenerationI() {
        return generationI;
    }

    public GenerationIiDto getGenerationIi() {
        return generationIi;
    }

    public GenerationIiiDto getGenerationIii() {
        return generationIii;
    }

    public GenerationIvDto getGenerationIv() {
        return generationIv;
    }

    public GenerationVDto getGenerationV() {
        return generationV;
    }

    public GenerationViDto getGenerationVi() {
        return generationVi;
    }

    public GenerationViiDto getGenerationVii() {
        return generationVii;
    }

    public GenerationViiiDto getGenerationViii() {
        return generationViii;
    }

    @SerializedName("generation-i")
    public GenerationIDto generationI;
    @SerializedName("generation-ii")
    public GenerationIiDto generationIi;
    @SerializedName("generation-iii")
    public GenerationIiiDto generationIii;
    @SerializedName("generation-iv")
    public GenerationIvDto generationIv;
    @SerializedName("generation-v")
    public GenerationVDto generationV;
    @SerializedName("generation-vi")
    public GenerationViDto generationVi;
    @SerializedName("generation-vii")
    public GenerationViiDto generationVii;
    @SerializedName("generation-viii")
    public GenerationViiiDto generationViii;
}
