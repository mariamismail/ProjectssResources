package com.example.mariam.projectssresource.models;

import java.io.Serializable;

/**
 * Created by Mariam on 17/10/2017.
 */

public class User implements Serializable {


    private String Name;
    private String phone;
    private String country;
    private String city;


    public User() {
    }

    public User(String name, String phone, String country, String city, String gender, String mail) {
        Name = name;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.gender = gender;
        this.mail = mail;
    }

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String mail;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }





    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}
