package com.kusithm.partstudybackend.domain.article.dto.request;

import com.kusithm.partstudybackend.domain.article.dto.response.ArticleResponse;
import com.kusithm.partstudybackend.domain.article.entity.Article;
import com.kusithm.partstudybackend.domain.tag.dto.TagDto;
import com.kusithm.partstudybackend.domain.tag.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostArticleRequest {
    String title;
    String description;
    String body;
    List<TagDto> tagList;

    public static PostArticleRequest of(String title, String description, String body, List<TagDto> tagList) {
        return new PostArticleRequest(title, description, body, tagList);
    }

    @Builder
    public Article toEntity(String title, String description, String body) {
        return Article.builder()
                .title(title)
                .description(description)
                .body(body).build();
    }
}
