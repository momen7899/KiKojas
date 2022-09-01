package com.momen.kikojast.place;


import lombok.AllArgsConstructor;
import lombok.val;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/place/v1")
public class PlaceController {
    private final PlaceService service;
    private PlaceMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PlaceDTO placeDTO) {
        Place place = mapper.toPlace(placeDTO);
        service.save(place);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<PlaceDTO> update(@RequestBody PlaceDTO placeDTO) {
        Place place = mapper.toPlace(placeDTO);
        val placeResponseDTO = mapper.toPlaceDTO(service.update(place));
        return ResponseEntity.ok(placeResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceDTO> getById(@PathVariable Long id) {
        Place place = service.getById(id);
        PlaceDTO placeDTO = mapper.toPlaceDTO(place);
        return ResponseEntity.ok(placeDTO);
    }

    @GetMapping()
    public ResponseEntity<List<PlaceDTO>> getAll() {
        List<Place> cities = service.getAll();
        List<PlaceDTO> placeDTOS = mapper.toPlaceDTOS(cities);

        return ResponseEntity.ok(placeDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{lat}/{lng}/{dist}")
    public ResponseEntity<List<PlaceDTO>> findAllInDistance(@PathVariable double lat, @PathVariable double lng, @PathVariable double dist) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setLat(lat);
        locationDTO.setLng(lng);
        Point<G2D> g2DPoint = mapper.convertLocationDtoToLocation(locationDTO);
        val placeDTOS = mapper.toPlaceDTOS(service.findAllInDistance(g2DPoint, dist));

        return ResponseEntity.ok(placeDTOS);
    }
}
