package com.example.openapi.service;

import com.example.openapi.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MovieSortService {
    public MovieDTO sort(MovieDTO movieDTO) {
        //movie.getItems가 list 이므로 collection의 stream생성할 때는 해당컬렉션.stream() ex) list.stream()
        Stream<MovieDTO.Item> movieStream = movieDTO.getItems().stream();
        Comparator<MovieDTO.Item> compare
                = Comparator.comparing((MovieDTO.Item i) -> i.getUserRating()).reversed();
        List sortedItems
                = movieStream.sorted(compare).filter(i -> Double.parseDouble(i.getUserRating()) > 0.0).collect(Collectors.toList());
        movieDTO.setItems(sortedItems);
        return movieDTO;
    }
}
