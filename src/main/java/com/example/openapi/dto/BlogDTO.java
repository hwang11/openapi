package com.example.openapi.dto;

import com.example.openapi.repository.Blog;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BlogDTO extends ResultDTO {
    private int total;
    private int start;
    private int display;
    private List<Blog.Item> items;

    @Getter
    @Setter
    public static class Item {
        private String title;
        private String link;
        private String description;
        private String bloggername;
        private String bloggerlink;
    }
}
