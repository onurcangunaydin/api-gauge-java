package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PutUpdateUserModel {

    @JsonProperty("userId")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setuserId(String userId) {
        if (!userId.isEmpty()){
            this.userId = userId;
        }
        else {
            throw new NullPointerException();
        }
    }

    public PutUpdateUserModel() {
    }

    public PutUpdateUserModel(String userId) {
        setuserId(userId);
    }
}
