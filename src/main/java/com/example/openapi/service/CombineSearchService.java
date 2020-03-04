package com.example.openapi.service;

import com.example.openapi.dto.BlogDTO;
import com.example.openapi.dto.MovieDTO;
import com.example.openapi.dto.ResultDTO;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CombineSearchService {
    private static final int LIMIT_ITEM_COUNT = 5;

    public List<ResultDTO> combine(BlogDTO blogDTO, MovieDTO movieDTO){
        List<ResultDTO> results = new LinkedList<ResultDTO>();
        blogDTO.setItems(blogDTO.getItems().stream().limit(LIMIT_ITEM_COUNT).collect(Collectors.toList()));
        movieDTO.setItems(movieDTO.getItems().stream().limit(LIMIT_ITEM_COUNT).collect(Collectors.toList()));
        results.add(blogDTO);
        results.add(movieDTO);
        return results;
    }
}
