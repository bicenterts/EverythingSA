package com.example.everythingsa;

public class Event {
    private String id;
    private String title;
    private String description;
    private String fee;
    private String photo;

    public Event() {}

    public Event(String title, String description, String fee, String photo) {
        this.setId(id);
        this.setTitle(title);
        this.setDescription(description);
        this.setFee(fee);
        this.setPhoto(photo);
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
