package com.momen.kikojast.image;

import com.momen.kikojast.common.exception.NotFoundException;
import com.momen.kikojast.place.PlaceService;
import com.momen.kikojast.user.UserService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;
    private final UserService userService;
    private final PlaceService placeService;


    @Override
    public Image saveImageForUser(Image image, long userId) {
        val user = userService.getById(userId);
        image.setUser(user);
        return repository.save(image);
    }

    @Override
    public Image saveImageForPlace(Image image, long placeId) {
        val place = placeService.getById(placeId);
        image.setPlace(place);
        return repository.save(image);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Image getById(Long id) {
        Optional<Image> optionalFileAttachment = repository.findById(id);
        if (optionalFileAttachment.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
        return optionalFileAttachment.get();
    }

    @Override
    public List<Image> getAll() {
        return (List<Image>) repository.findAll();
    }

    @Override
    public Image getByUserID(Long userId) {
        Optional<Image> optionalFileAttachment = Optional.ofNullable(repository.findByUser_Id(userId));
        if (optionalFileAttachment.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
        return optionalFileAttachment.get();
    }

    @Override
    public List<Image> getAllByPlaceId(Long placeId) {
        return repository.findAllByPlace_Id(placeId);
    }

}
