package dto;

import java.util.List;

public class PokemonDto {
    public List<AbilityDto> abilities;
    public int base_experience;
    public List<FormDto> forms;
    public List<GameIndiceDto> game_indices;
    public int height;
    public List<HeldItemDto> held_items;
    public int id;
    public boolean is_default;
    public String location_area_encounters;
    public List<MoveDto> moves;
    public String name;

    public List<AbilityDto> getAbilities() {
        return abilities;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public List<FormDto> getForms() {
        return forms;
    }

    public List<GameIndiceDto> getGame_indices() {
        return game_indices;
    }

    public int getHeight() {
        return height;
    }

    public List<HeldItemDto> getHeld_items() {
        return held_items;
    }

    public int getId() {
        return id;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    public List<MoveDto> getMoves() {
        return moves;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public SpeciesDto getSpecies() {
        return species;
    }

    public SpritesDto getSprites() {
        return sprites;
    }

    public List<StatDto> getStats() {
        return stats;
    }

    public List<TypeDto> getTypes() {
        return types;
    }

    public int getWeight() {
        return weight;
    }

    public int order;
    public SpeciesDto species;
    public SpritesDto sprites;
    public List<StatDto> stats;
    public List<TypeDto> types;
    public int weight;
}

