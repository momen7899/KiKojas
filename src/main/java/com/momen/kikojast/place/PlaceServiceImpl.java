package com.momen.kikojast.place;

import com.momen.kikojast.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository repository;

    @Override
    public Place save(Place place) {
        return repository.save(place);
    }

    @Override
    public Place update(Place place) {
        Place savedBefore = getById(place.getId());
        savedBefore.setAddress(place.getAddress());
        savedBefore.setType(place.getType());
        savedBefore.setTitle(place.getTitle());
        savedBefore.setStartService(place.getStartService());
        savedBefore.setEndService(place.getEndService());
        savedBefore.setLocation(place.getLocation());
        return repository.save(savedBefore);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Place getById(Long id) {
        Optional<Place> optionalHouse = repository.findById(id);

        if (optionalHouse.isEmpty()) {
            throw new NotFoundException("Place Not Found");
        }

        return optionalHouse.get();
    }

    @Override
    public List<Place> getAll() {
        return (List<Place>) repository.findAll();
    }

    @Override
    public List<Place> findAllInDistance(Point<G2D> refPnt, double dist) {
        return repository.findAllInDistance(refPnt, dist);
    }
}
