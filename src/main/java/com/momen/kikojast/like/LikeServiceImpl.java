package com.momen.kikojast.like;

import com.momen.kikojast.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository repository;

    @Override
    public Like save(Like like) {
        like.setType(LikeType.PLACE);
        if (like.getPlace() == null) {
            like.setType(LikeType.COMMENT);
        }
        return repository.save(like);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Like getById(Long id) {
        Optional<Like> optionalLike = repository.findById(id);
        if (optionalLike.isEmpty())
            throw new NotFoundException("like Not Found");
        return optionalLike.get();
    }

    @Override
    public List<Like> getAll() {
        return (List<Like>) repository.findAll();
    }

    @Override
    public List<Like> getAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public List<Like> getAllByPlaceId(Long placeId) {
        return repository.findAllByPlaceId(placeId);
    }

    @Override
    public List<Like> getAllByTypeLike(LikeType likeType) {
        return repository.findAllByTypeLike(likeType);
    }
}
