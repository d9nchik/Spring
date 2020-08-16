package com.d9nich.demo.jpaRelationship;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    private long id;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private final List<Tweet> tweets = new ArrayList<>();
}

