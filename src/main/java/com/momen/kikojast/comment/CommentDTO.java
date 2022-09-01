package com.momen.kikojast.comment;

import com.momen.kikojast.common.BaseEntity;
import com.momen.kikojast.like.LikeDTO;
import com.momen.kikojast.place.PlaceDTO;
import com.momen.kikojast.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CommentDTO extends BaseEntity {
    @ApiModelProperty(required = true, hidden = false)
    private String text;

    @ApiModelProperty(required = true, hidden = false)
    private UserDTO user;

    @ApiModelProperty(required = true, hidden = false)
    private PlaceDTO place;

    @ApiModelProperty(required = false, hidden = true)
    private List<LikeDTO> likes;
}
