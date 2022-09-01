package com.momen.kikojast.like;

import com.momen.kikojast.comment.CommentDTO;
import com.momen.kikojast.common.BaseDTO;
import com.momen.kikojast.place.PlaceDTO;
import com.momen.kikojast.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LikeDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private UserDTO user;

    @ApiModelProperty(required = false, hidden = false)
    private PlaceDTO place;

    @ApiModelProperty(required = false, hidden = false)
    private CommentDTO comment;
}
