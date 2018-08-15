package com.example.hateoas.controller;

import com.example.hateoas.db.DB;
import com.example.hateoas.model.Dependent;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hsenid on 8/15/18.
 */
@RestController
@RequestMapping("/dependents")
public class DependentController {

    @GetMapping("/{name}")
    public Dependent getDependentByName(@PathVariable String name) {
        return DB.getDependentsFromDB().stream()
                .filter(d -> d.getName().equals(name))
                .map(d -> {
                    Link selfLink = ControllerLinkBuilder.linkTo(DependentController.class)
                            .slash(d.getName()).withSelfRel();
                    d.add(selfLink);
                    Link parentLink = ControllerLinkBuilder.linkTo(UserController.class)
                            .slash(d.getParent()).withRel("parent");
                    d.add(parentLink);
                    return d;
                })
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/byParent/{parentName}")
    public List<Dependent> getDependents(@PathVariable String parentName) {
        return DB.getDependentsFromDB().stream()
                .filter(d -> d.getParent().equals(parentName))
                .map(d -> {
                    Link selfLink = ControllerLinkBuilder.linkTo(DependentController.class)
                            .slash(d.getName()).withSelfRel();
                    d.add(selfLink);
                    Link parentLink = ControllerLinkBuilder.linkTo(UserController.class)
                            .slash(d.getParent()).withRel("parent");
                    d.add(parentLink);
                    return d;
                })
                .collect(Collectors.toList());
    }

}
