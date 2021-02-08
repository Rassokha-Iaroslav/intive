package dto;

import java.util.List;

public class MoveDto {
    public Move2Dto getMove() {
        return move;
    }

    public List<VersionGroupDetailDto> getVersion_group_details() {
        return version_group_details;
    }

    public Move2Dto move;
    public List<VersionGroupDetailDto> version_group_details;
}
