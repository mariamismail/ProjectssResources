package com.example.mariam.projectssresource.models;

import java.io.Serializable;

/**
 * Created by Mariam on 24/10/2017.
 */

public class Resource implements Serializable {
   public String resourceID;
   public String country;

    public Resource() {
    }

    public Resource(String resourceID, String country) {
        this.resourceID = resourceID;
        this.country = country;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getResourceID() {
        return resourceID;
    }

    public String getCountry() {
        return country;
    }
}
