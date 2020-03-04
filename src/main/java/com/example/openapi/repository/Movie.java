package com.example.openapi.repository;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Movie extends Result {
    private List<Item> items;

    @Getter
    public static class Item{
        private String title;
        private String link;
        private String image;
        private String subtitle;
        private String pubDate;
        private String director;
        private String actor;
        private String userRating;
    }
}
