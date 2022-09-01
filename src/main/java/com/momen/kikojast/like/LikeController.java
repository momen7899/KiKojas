package com.momen.kikojast.like;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like/v1")
@AllArgsConstructor
public class LikeController {

    private final LikeService service;
    private LikeMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody LikeDTO likeDTO) {
        Like like = mapper.toLike(likeDTO);
        service.save(like);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<LikeDTO> getById(@PathVariable Long id) {
        Like like = service.getById(id);
        LikeDTO likeDTO = mapper.toLikeDTO(like);
        return ResponseEntity.ok(likeDTO);
    }


    @GetMapping()
    public ResponseEntity<List<LikeDTO>> getAll() {
        List<Like> likes = service.getAll();
        List<LikeDTO> usersDto = mapper.toLikesDTO(likes);

        return ResponseEntity.ok(usersDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LikeDTO>> getAllByUserId(@PathVariable Long userId) {
        val allByUserId = service.getAllByUserId(userId);
        val likesDTO = mapper.toLikesDTO(allByUserId);
        return ResponseEntity.ok(likesDTO);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<LikeDTO>> getAllByPlaceId(@PathVariable Long placeId) {
        val allByPlaceId = service.getAllByPlaceId(placeId);
        val likesDTO = mapper.toLikesDTO(allByPlaceId);
        return ResponseEntity.ok(likesDTO);
    }

    @GetMapping("/type/{likeType}")
    public ResponseEntity<List<LikeDTO>> getAllByPlaceId(@PathVariable LikeType likeType) {
        val allByPlaceId = service.getAllByTypeLike(likeType);
        val likesDTO = mapper.toLikesDTO(allByPlaceId);
        return ResponseEntity.ok(likesDTO);
    }
}
