package com.momen.kikojast.comment;

import com.momen.kikojast.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    @Override
    public Comment save(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Comment getById(Long id) {
        Optional<Comment> optionalComment = repository.findById(id);
        if (optionalComment.isEmpty())
            throw new NotFoundException("like Not Found");
        return optionalComment.get();
    }

    @Override
    public List<Comment> getAll() {
        return (List<Comment>) repository.findAll();
    }

    @Override
    public List<Comment> getAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public List<Comment> getAllByPlaceId(Long placeId) {
        return repository.findAllByPlaceId(placeId);
    }

}
