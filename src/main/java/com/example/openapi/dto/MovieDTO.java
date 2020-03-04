package com.example.openapi.dto;

import com.example.openapi.repository.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class MovieDTO extends ResultDTO{
    private List<Item> items;

    public MovieDTO(Movie movie){
        List<Movie.Item> li = movie.getItems();
        this.items = new LinkedList<Item>();
        li.forEach(i -> this.items.add(new Item(i)));
    }

    @Getter
    @Setter
    public static class Item{
        public Item(Movie.Item item){
            this.image = item.getImage();
            this.title = item.getTitle();
            this.link = item.getLink();
            this.subtitle = item.getSubtitle();
            this.pubDate = item.getPubDate();
            this.director = item.getDirector();
            this.actor = item.getActor();
            this.userRating = item.getUserRating();
        }
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
