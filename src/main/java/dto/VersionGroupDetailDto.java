package dto;

public class VersionGroupDetailDto {
    public int getLevel_learned_at() {
        return level_learned_at;
    }

    public MoveLearnMethodDto getMove_learn_method() {
        return move_learn_method;
    }

    public VersionGroupDto getVersion_group() {
        return version_group;
    }

    public int level_learned_at;
    public MoveLearnMethodDto move_learn_method;
    public VersionGroupDto version_group;
}
