package com.signalflow.algotrader.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsArticleDto {
    private String title;
    private String description;
    private String url;
    private String publishedAt;

    @Override
    public String toString() {
        return "NewsArticleDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
