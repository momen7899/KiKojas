package com.momen.kikojast.comment;


import com.momen.kikojast.place.PlaceMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlaceMapper.class})
public interface CommentMapper {

    Comment toComment(CommentDTO commentDTO);

    List<Comment> toComments(List<CommentDTO> commentDTOS);

    CommentDTO toCommentDTO(Comment comment);

    List<CommentDTO> toCommentDTOs(List<Comment> comments);
}
