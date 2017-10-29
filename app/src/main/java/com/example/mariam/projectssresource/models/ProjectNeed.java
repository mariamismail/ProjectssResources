package com.example.mariam.projectssresource.models;

import java.io.Serializable;



/**
 * Created by Mariam on 17/10/2017.
 */

public class ProjectNeed implements Serializable {
     public  String projectId;
     public String country;

    public ProjectNeed(String projectId, String country) {
        this.projectId = projectId;
        this.country = country;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
