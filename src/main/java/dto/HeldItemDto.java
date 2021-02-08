package dto;

import java.util.List;

public class HeldItemDto {
    public ItemDto getItem() {
        return item;
    }

    public List<VersionDetailDto> getVersion_details() {
        return version_details;
    }

    public ItemDto item;
    public List<VersionDetailDto> version_details;

}
