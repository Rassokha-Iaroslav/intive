package dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty("generation-i")
    public GenerationIDto generationI;
    @JsonProperty("generation-ii")
    public GenerationIiDto generationIi;
    @JsonProperty("generation-iii")
    public GenerationIiiDto generationIii;
    @JsonProperty("generation-iv")
    public GenerationIvDto generationIv;
    @JsonProperty("generation-v")
    public GenerationVDto generationV;
    @JsonProperty("generation-vi")
    public GenerationViDto generationVi;
    @JsonProperty("generation-vii")
    public GenerationViiDto generationVii;
    @JsonProperty("generation-viii")
    public GenerationViiiDto generationViii;
}
