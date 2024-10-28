package org.example.base;

public class Base {
    private final String contentType = "Content-Type";
    private final String contentValue = "application/json";
    private final String accept = "Accept";
    private final String acceptValue = "application/json";

    public Base() {
    }

    public String getContentType() {
        return contentType;
    }

    public String getContentValue() {
        return contentValue;
    }

    public String getAccept() {
        return accept;
    }

    public String getAcceptValue() {
        return acceptValue;
    }
}
