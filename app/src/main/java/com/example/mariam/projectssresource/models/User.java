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
    private String job;

    private String experience;
    private String mail;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return phone;
    }

    public void setAge(String age) {
        phone = age;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public User(String name, String age, String country, String city, String job, String experience, String mail) {

        Name = name;
        phone = age;
        this.country = country;
        this.city = city;
        this.job = job;
        this.experience = experience;
        this.mail = mail;
    }
}
