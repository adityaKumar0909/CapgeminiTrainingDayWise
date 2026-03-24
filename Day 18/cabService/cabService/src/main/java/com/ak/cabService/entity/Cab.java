package com.ak.cabService.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
public class Cab {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String name;
    String owner;
    Boolean isActive;



    public long getId() {
        return id;
    }



    public Cab() {}

    public Cab( long id,String name, String owner, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.isActive = isActive;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    @Override
    public String toString() {
        return "Cab{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
