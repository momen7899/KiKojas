package com.momen.kikojast.place;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LocationDTO {
    @ApiModelProperty(required = true, hidden = false)
    private double lat;

    @ApiModelProperty(required = true, hidden = false)
    private double lng;
}
