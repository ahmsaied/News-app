package com.bottlesecret.news.newsapp;

public class NewsList {
    private String image, title, publishedAt, author, description;

    public NewsList(String image, String title, String publishedAt, String author, String description) {
        this.image = image;
        this.title = title;
        this.publishedAt = publishedAt;
        this.author = author;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
