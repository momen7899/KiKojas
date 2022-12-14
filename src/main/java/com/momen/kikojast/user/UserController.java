package com.momen.kikojast.user;


import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@AllArgsConstructor
@RequestMapping("/user/v1")
public class UserController {

    private final UserService service;
    private UserMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.toString());
        User user = mapper.toUser(userDTO);
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        val dto = mapper.toUserDTO(service.update(user));
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        User user = service.getById(id);
        UserDTO userDTO = mapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }


    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> users = service.getAll();
        List<UserDTO> usersDto = mapper.toUserDTOs(users);

        return ResponseEntity.ok(usersDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
