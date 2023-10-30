package model;

import java.util.Date;

public class User {
    private String name;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private Long telNumber;
    private Character gender;

    public User(String name, String firstName, String lastName, Date birthdate, Long telNumber, Character gender) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.telNumber = telNumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Long telNumber) {
        this.telNumber = telNumber;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", telNumber=" + telNumber +
                ", gender=" + gender +
                '}';
    }
}
