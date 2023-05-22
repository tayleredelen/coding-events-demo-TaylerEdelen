package org.launchcode.codingevents.models;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
public class EventCategory {

    @Id //defines this to hibernate this is the primary key
    @GeneratedValue //increments id
    private int id;

//    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    public EventCategory(String name) {
        this.name = name;
    }

    public EventCategory() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

//    @Override
//    public String toString() {
//        return name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EventCategory that = (EventCategory) o;
//        return id == that.id;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}