package com.example.openapi.controller;

import com.example.openapi.SearchProperties;
import com.example.openapi.dto.BlogDTO;
import com.example.openapi.dto.MovieDTO;
import com.example.openapi.dto.ResultDTO;
import com.example.openapi.repository.Blog;
import com.example.openapi.repository.Movie;
import com.example.openapi.service.CombineSearchService;
import com.example.openapi.service.MovieSortService;
import com.example.openapi.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/api")
public class SearchController {
    private final SearchService searchService;
    private final CombineSearchService combineSearchService;
    private final MovieSortService movieSortService;
    private final SearchProperties searchProperties;

    public SearchController(SearchService searchService, SearchProperties searchProperties,
                            CombineSearchService combineSearchService, MovieSortService movieSortService){ //@Autowired말고 생성자로 주입하기
        this.searchProperties = searchProperties;
        this.searchService = searchService;
        this.combineSearchService = combineSearchService;
        this.movieSortService = movieSortService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/search")
    public List<ResultDTO> search(@RequestParam(name = "query") String query){
        Blog blog = (Blog) searchService.search(searchProperties.getBlogUrl(), query, Blog.class);
        BlogDTO blogDTO = new BlogDTO(blog);
        Movie movie = (Movie) searchService.search(searchProperties.getMovieUrl(), query, Movie.class);
        MovieDTO movieDTO = new MovieDTO(movie);
        return combineSearchService.combine(blogDTO,movieSortService.sort(movieDTO));
    }

    @GetMapping("/blog")
    public String  blogSearch(Model model, @RequestParam(name = "query") String query){
        Blog blog = (Blog) searchService.search(searchProperties.getBlogUrl(), query, Blog.class);
        BlogDTO blogDTO = new BlogDTO(blog);
        model.addAttribute("blogItems",blogDTO.getItems());
        return "index";
    }

    @GetMapping("/movie")
    public MovieDTO movieSearch(@RequestParam(name = "query") String query){
        Movie movie = (Movie) searchService.search(searchProperties.getMovieUrl(), query, Movie.class);
        MovieDTO movieDTO = new MovieDTO(movie);
        return movieSortService.sort(movieDTO);
    }
}