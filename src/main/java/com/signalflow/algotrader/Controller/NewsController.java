package com.signalflow.algotrader.Controller;

import com.signalflow.algotrader.DTOs.NewsArticleDto;
import com.signalflow.algotrader.Services.NewsApiService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private NewsApiService newsApiService;
    public NewsController(NewsApiService newsApiService) {
        this.newsApiService = newsApiService;
    }
    @RequestMapping("/{symbol}")
    public List<NewsArticleDto> getNews(@PathVariable String symbol) {
        return newsApiService.getTopNewsBySymbol(symbol, 50);
    }
}
