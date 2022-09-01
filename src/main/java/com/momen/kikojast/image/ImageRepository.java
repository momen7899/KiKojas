package com.momen.kikojast.image;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {

    List<Image> findAllByPlace_Id(long placeId);

    Image findByUser_Id(Long userId);
}
