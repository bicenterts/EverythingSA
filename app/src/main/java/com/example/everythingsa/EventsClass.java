package com.example.everythingsa;

import java.io.Serializable;

public class EventsClass implements Serializable {
    private String id;
    private String title;
    private String description;
    private String fee;
    private String imageUrl;

    public EventsClass() {};

    public EventsClass(String title, String description, String fee, String imageUrl) {
        this.setId(id);
        this.setTitle(title);
        this.setDescription(description);
        this.setFee(fee);
        this.setImageUrl(imageUrl);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
