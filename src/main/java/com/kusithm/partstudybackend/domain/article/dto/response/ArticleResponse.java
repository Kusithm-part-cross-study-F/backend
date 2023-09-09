package com.kusithm.partstudybackend.domain.article.dto.response;

import com.kusithm.partstudybackend.domain.article.entity.Article;
import com.kusithm.partstudybackend.domain.tag.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class ArticleResponse {
    Long articleId;
    String title;
    String description;
    String body;
    List<String> tagList;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public static ArticleResponse of(Article article) {
        List<String> tags = new ArrayList<>();
        for (Tag tag : article.getTags()) {
            tags.add(tag.getType().toString());
        }

        return new ArticleResponse(
                article.getId(),
                article.getTitle(),
                article.getDescription(),
                article.getBody(),
                tags,
                article.getCreatedDate(),
                article.getModifiedDate());
    }

}
