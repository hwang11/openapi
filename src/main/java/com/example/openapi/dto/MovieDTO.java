package com.example.openapi.dto;

import com.example.openapi.repository.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDTO {
    private List<Movie.Item> items;

    @Getter
    @Setter
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
