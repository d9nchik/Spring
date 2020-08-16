package com.d9nich.demo.jpaRelationship;

import javax.persistence.*;

@Entity
public class Tweet {

    @Id
    @Column(name = "TweetID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
