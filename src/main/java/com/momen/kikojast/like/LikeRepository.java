package com.momen.kikojast.like;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LikeRepository extends PagingAndSortingRepository<Like, Long> {
    List<Like> findAllByUserId(long userId);

    List<Like> findAllByPlaceId(long placeId);

    List<Like> findAllByTypeLike(LikeType type);
}
