package com.example.openapi.dto;

import com.example.openapi.repository.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
//@Setter
//setter는 없어도 되지않을까? api 결과로 우선 movie로 가져오고 그 이후 movieDTO로 매핑이기때문에..? 헷갈린다 
public class MovieDTO {
    private List<Movie.Item> items;

    @Getter
    //@Setter
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
