package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    //fields

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;


//    Add a field to collect information about where the event will take place.
//    This field should not be null or blank.

    @NotNull(message="Location is required")
    @NotBlank(message="Location is required")
    private String location;


//    Add a field to collect information about whether an attendee must register for the event or not.
//    For the purposes of validation practice, make this field only able to be marked as true.

    @AssertTrue(message="This event requires registration.") //meaning it can only be set to true, message is for if they select false
    private boolean shouldRegister = true;

//    Add a field to collect information about the number of attendees for the event.
//    Valid values for this field should be any number over zero.

    @NotNull(message="At least 1 attendee required.")
    @Min(value=1, message="At lease 1 attendee required.") //size is only for strings, min is for numeric values
    private Integer numOfAttendees;
    //only classes can be null


//    Browse the validation annotations to find one to use on another new field of your choosing.

    @NotBlank(message="Do you want event swag? Yes or No?")
    private String swag;


    //constructors

    public Event(String name, String description, String contactEmail, String location, Boolean shouldRegister, Integer numOfAttendees, String swag) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.shouldRegister = shouldRegister;
        this.numOfAttendees = numOfAttendees;
        this.swag = swag;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }


    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isShouldRegister() {
        return shouldRegister;
    }

    public void setShouldRegister(boolean shouldRegister) {
        this.shouldRegister = shouldRegister;
    }

    public Integer getNumOfAttendees() {
        return numOfAttendees;
    }

    public void setNumOfAttendees(Integer numOfAttendees) {
        this.numOfAttendees = numOfAttendees;
    }

    public String getSwag() {
        return swag;
    }

    public void setSwag(String swag) {
        this.swag = swag;
    }

    //methods
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
