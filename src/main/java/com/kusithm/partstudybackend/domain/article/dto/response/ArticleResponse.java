package com.kusithm.partstudybackend.domain.article.dto.response;

import com.kusithm.partstudybackend.domain.article.entity.Article;
import com.kusithm.partstudybackend.domain.tag.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@Getter
public class ArticleResponse {
    Long articleId;
    String title;
    String description;
    String body;
    List<TagDto> tagList;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public static ArticleResponse of(Article article) {
        return new ArticleResponse(
                article.getId(),
                article.getTitle(),
                article.getDescription(),
                article.getBody(),
                article.getTags().stream()
                        .map(TagDto::new)
                        .collect(Collectors.toList()),
                article.getCreatedDate(),
                article.getModifiedDate());
    }

}
