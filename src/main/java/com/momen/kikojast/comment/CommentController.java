package com.momen.kikojast.comment;

import com.momen.kikojast.like.*;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/comment/v1")
public class CommentController {

    private final CommentService service;
    private CommentMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CommentDTO likeDTO) {
        Comment comment = mapper.toComment(likeDTO);
        service.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getById(@PathVariable Long id) {
        Comment comment = service.getById(id);
        CommentDTO commentDTO = mapper.toCommentDTO(comment);
        return ResponseEntity.ok(commentDTO);
    }


    @GetMapping()
    public ResponseEntity<List<CommentDTO>> getAll() {
        List<Comment> likes = service.getAll();
        List<CommentDTO> commentDTOS = mapper.toCommentDTOs(likes);

        return ResponseEntity.ok(commentDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CommentDTO>> getAllByUserId(@PathVariable Long userId) {
        val allByUserId = service.getAllByUserId(userId);
        val commentDTOS = mapper.toCommentDTOs(allByUserId);
        return ResponseEntity.ok(commentDTOS);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<CommentDTO>> getAllByPlaceId(@PathVariable Long placeId) {
        val allByPlaceId = service.getAllByPlaceId(placeId);
        val commentDTOS = mapper.toCommentDTOs(allByPlaceId);
        return ResponseEntity.ok(commentDTOS);
    }
}
