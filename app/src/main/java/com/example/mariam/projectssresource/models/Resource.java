package com.example.mariam.projectssresource.models;

import java.io.Serializable;

/**
 * Created by Mariam on 24/10/2017.
 */

public class Resource implements Serializable {
    public String resourceID;
    public String country;
    public String lastDgree;
    public String expierenceYears;
    public String cVLink;

    public String expierenceConclusion;
    public String jobTitle;
    public String beginningData;


    public Resource() {
    }

    public Resource(String resourceID, String country, String lastDgree, String expierenceYears, String cVLink, String expierenceConclusion, String jobTitle, String beginningData) {
        this.resourceID = resourceID;
        this.country = country;
        this.lastDgree = lastDgree;
        this.expierenceYears = expierenceYears;
        this.cVLink = cVLink;
        this.expierenceConclusion = expierenceConclusion;
        this.jobTitle = jobTitle;
        this.beginningData = beginningData;
    }

    public String getcVLink() {
        return cVLink;
    }

    public void setcVLink(String cVLink) {
        this.cVLink = cVLink;
    }

    public String getResourceID() {
        return resourceID;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastDgree() {
        return lastDgree;
    }

    public void setLastDgree(String lastDgree) {
        this.lastDgree = lastDgree;
    }

    public String getExpierenceYears() {
        return expierenceYears;
    }

    public void setExpierenceYears(String expierenceYears) {
        this.expierenceYears = expierenceYears;
    }

    public String getExpierenceConclusion() {
        return expierenceConclusion;
    }

    public void setExpierenceConclusion(String expierenceConclusion) {
        this.expierenceConclusion = expierenceConclusion;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getBeginningData() {
        return beginningData;
    }


    public void setBeginningData(String beginningData) {
        this.beginningData = beginningData;
    }
}
