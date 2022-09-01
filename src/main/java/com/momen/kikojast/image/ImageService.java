package com.momen.kikojast.image;

import java.util.List;

public interface ImageService {
    Image saveImageForUser(Image image, long userId);

    Image saveImageForPlace(Image image, long placeId);

    void delete(Long id);

    Image getById(Long id);

    List<Image> getAll();

    Image getByUserID(Long userId);

    List<Image> getAllByPlaceId(Long placeId);
}
