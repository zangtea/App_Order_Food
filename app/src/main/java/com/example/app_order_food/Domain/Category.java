package com.example.app_order_food.Domain;

public class Category {
    private int id;
    private String ImagePath;
    private  String name;

    public Category() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public Category(int id) {
        this.id = id;
    }

    public boolean getId() {

        return false;
    }
}
