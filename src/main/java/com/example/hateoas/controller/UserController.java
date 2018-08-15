package com.example.hateoas.controller;

import com.example.hateoas.db.DB;
import com.example.hateoas.model.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hsenid on 8/15/18.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{name}")
    public User getUserByName(@PathVariable String name) {
        return DB.getUsersFromDB().stream()
                .filter(u -> u.getName().equals(name))
                .map(u -> {
                    Link link = ControllerLinkBuilder.linkTo(UserController.class)
                            .slash(u.getName()).withSelfRel();
                    u.add(link);
                    Link dependentsLink = ControllerLinkBuilder.linkTo(DependentController.class)
                            .slash("byParent")
                            .slash(u.getName()).withRel("children");
                    u.add(dependentsLink);
                    return u;
                })
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        List<User> users = DB.getUsersFromDB();

        users.forEach(u -> {
            Link link = ControllerLinkBuilder.linkTo(UserController.class)
                    .slash(u.getName()).withSelfRel();
            u.add(link);
            Link dependentsLink = ControllerLinkBuilder.linkTo(DependentController.class)
                    .slash("byParent")
                    .slash(u.getName()).withRel("children");
            u.add(dependentsLink);
        });

        return users;
    }

}
