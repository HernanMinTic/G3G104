package com.example.shopg3g104.Entities;

import java.util.Date;
import java.util.UUID;

public class Product {

    private String id;
    private String name;
    private String description;
    private int price;
    private String image;
    private boolean deleted;
    private Date createdAt;
    private Date updatedAt;
    private Double latitud;
    private Double longitud;

    public Product(String id, String name, String description, int price, String image, Double latitud, Double longitud) {
        this. latitud = latitud;
        this.longitud = longitud;
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Product(String id, String name, String description, int price, String image, boolean deleted, Date createdAt, Date updatedAt, Double latitud, Double longitud) {
        this. latitud = latitud;
        this.longitud = longitud;
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(String name, String description, int price, String image, Double latitud, Double longitud) {
        this. latitud = latitud;
        this.longitud = longitud;
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.deleted = false;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Product(String name, String description, int price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.deleted = false;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public String getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
