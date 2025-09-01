package com.hexa;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{

    private final UserService userService;


    public UserController(UserService userService)
    {
        this.userService = userService;
    }


    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) throws Exception
    {

        return ResponseEntity.ok(userService.addUser(user));

    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUsers()
    {

        return ResponseEntity.ok(userService.getAllUsers());

    }

    @GetMapping("/get-{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)
    {

        User user = userService.getUserById(id);

        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }


    @PutMapping("/update-{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id , @RequestBody User user) throws Exception
    {

        User updated = userService.updateUser(id , user);

        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();


    }


    @DeleteMapping("/delete-{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception
    {
        return userService.deleteUser(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }


}
