package com.momen.kikojast.place;

import com.momen.kikojast.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlaceDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String title;

    @ApiModelProperty(required = true, hidden = false)
    private Integer startService;

    @ApiModelProperty(required = true, hidden = false)
    private Integer endService;

    @ApiModelProperty(required = true, hidden = false)
    private String address;

    @ApiModelProperty(required = true, hidden = false)
    private PlaceType type;

    @ApiModelProperty(required = true, hidden = false)
    private LocationDTO location;
}
