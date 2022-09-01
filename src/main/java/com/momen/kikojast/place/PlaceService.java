package com.momen.kikojast.place;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.util.List;

public interface PlaceService {
    Place save(Place place);

    Place update(Place place);

    void delete(Long id);

    Place getById(Long id);

    List<Place> getAll();

    List<Place> findAllInDistance(Point<G2D> refPnt, double dist);
}