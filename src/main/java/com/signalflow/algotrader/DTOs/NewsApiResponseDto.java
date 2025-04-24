package com.signalflow.algotrader.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NewsApiResponseDto {
    List<NewsArticleDto> articles;
}
