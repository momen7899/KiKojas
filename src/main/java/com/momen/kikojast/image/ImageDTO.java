package com.momen.kikojast.image;


import com.momen.kikojast.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ImageDTO extends BaseDTO{

    @ApiModelProperty(required = true, hidden = false)
    private String image;

    @ApiModelProperty(required = true, hidden = false)
    private Long attach_id;
}
