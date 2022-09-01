package com.momen.kikojast.comment;


import java.util.List;

public interface CommentService {
    Comment save(Comment comment);

    void delete(Long id);

    Comment getById(Long id);

    List<Comment> getAll();

    List<Comment> getAllByUserId(Long userId);

    List<Comment> getAllByPlaceId(Long placeId);

}
