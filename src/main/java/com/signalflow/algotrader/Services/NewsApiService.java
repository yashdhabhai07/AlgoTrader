package com.signalflow.algotrader.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.signalflow.algotrader.DTOs.NewsApiResponseDto;
import com.signalflow.algotrader.DTOs.NewsArticleDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service("NewsApiService")
public class NewsApiService {

    private static final String API_KEY = "a8f276a0612c47f7b5321b2f2467ece0";  // Replace with your actual NewsAPI key
    private static final String BASE_URL = "https://newsapi.org/v2/everything";

    private RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public NewsApiService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public List<NewsArticleDto> getTopNewsBySymbol(String symbol, int limit) {
        List<NewsArticleDto> articles = getNewsBySymbol(symbol);
        return articles.subList(0, Math.min(limit, articles.size()));
    }

    public List<NewsArticleDto> getNewsBySymbol(String symbol) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("q", symbol)
                .queryParam("sortBy", "publishedAt")
                .queryParam("language", "en")
                .queryParam("apiKey", API_KEY)
                .toUriString();
        try {
            String response = restTemplate.getForObject(url, String.class);
            NewsApiResponseDto newsResponse = objectMapper.readValue(response, NewsApiResponseDto.class);
            return newsResponse.getArticles();

        } catch (Exception e) {
            throw new RuntimeException("Error fetching or parsing news data", e);
        }
    }
}
