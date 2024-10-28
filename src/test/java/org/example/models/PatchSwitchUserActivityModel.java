package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatchSwitchUserActivityModel {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("isActive")
    private Boolean isActive;

    public String getUserId() {
        return userId;
    }

    public void setuserId(String userId) {
        if (!userId.isEmpty()) {
            this.userId = userId;
        } else {
            throw new NullPointerException();
        }
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    //default constructor for Jackson
    public PatchSwitchUserActivityModel() {
    }

    public PatchSwitchUserActivityModel(String userId, Boolean isActive) {
        setuserId(userId);
        setActive(isActive);
    }
}
