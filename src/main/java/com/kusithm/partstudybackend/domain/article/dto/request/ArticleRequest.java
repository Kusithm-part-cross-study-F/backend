package com.kusithm.partstudybackend.domain.article.dto.request;

import com.kusithm.partstudybackend.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleRequest {
    String title;
    String description;
    String body;
    List<String> tagList;

    public static ArticleRequest of(String title, String description, String body, List<String> tagList) {
        return new ArticleRequest(title, description, body, tagList);
    }

    @Builder
    public Article toEntity(String title, String description, String body) {
        return Article.builder()
                .title(title)
                .description(description)
                .body(body).build();
    }
}
