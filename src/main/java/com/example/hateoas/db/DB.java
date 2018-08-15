package com.example.hateoas.db;

import com.example.hateoas.model.Dependent;
import com.example.hateoas.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hsenid on 8/15/18.
 */
public class DB {

    public static List<User> getUsersFromDB() {
        return Arrays.asList(
                new User("Amal", 34),
                new User("Kamal", 25),
                new User("Nimal", 50)
        );
    }

    public static List<Dependent> getDependentsFromDB() {
        return Arrays.asList(
                new Dependent("Amal", "Sunil", 10),
                new Dependent("Amal", "Menuka", 3),
                new Dependent("Kamal", "Senani", 2),
                new Dependent("Nimal", "Dineesha", 1 )
        );
    }

}
