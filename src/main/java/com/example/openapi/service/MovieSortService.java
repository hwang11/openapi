package com.example.openapi.service;

import com.example.openapi.repository.Movie;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovieSortService {
    public Movie sort(Movie movie) {
        //movie.getItems가 list 이므로 collection의 stream생성할 때는 해당컬렉션.stream() ex) list.stream()
        Stream<Movie.Item> movieStream = movie.getItems().stream();
        Comparator<Movie.Item> compare
                = Comparator.comparing((Movie.Item i) -> i.getUserRating()).reversed();
        List sortedItems = movieStream.sorted(compare).filter(i -> Double.parseDouble(i.getUserRating()) > 0.0).collect(Collectors.toList());
        movie.setItems(sortedItems);
        return movie;
    }
}
