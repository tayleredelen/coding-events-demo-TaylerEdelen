package org.launchcode.codingevents.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {


    //    The id field
    @Id
    @GeneratedValue
    private int id;

    //    The getId method
    public int getId() {
        return id;
    }

    //    The equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity entity = (AbstractEntity) o;
        return id == entity.id;
    }

    //    The hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
