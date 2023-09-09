package com.kusithm.partstudybackend.domain.article.service;

import com.kusithm.partstudybackend.domain.article.dao.ArticleRepository;
import com.kusithm.partstudybackend.domain.article.dto.request.ArticleRequest;
import com.kusithm.partstudybackend.domain.article.dto.response.ArticleResponse;
import com.kusithm.partstudybackend.domain.article.entity.Article;
import com.kusithm.partstudybackend.domain.tag.entity.Tag;
import com.kusithm.partstudybackend.domain.tag.entity.TagType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional(readOnly = false)
    public ArticleResponse createArticle(ArticleRequest request) {
        Article newArticle = request.toEntity(
                request.getTitle(),
                request.getDescription(),
                request.getBody()
        );
        List<String> tagStrigns = request.getTagList();
        List<Tag> tags = new ArrayList<>();
        for (String tagString : tagStrigns) {
            TagType type = TagType.valueOf(tagString);
            tags.add(new Tag(type));
        }
        newArticle.setTags(tags);
        articleRepository.save(newArticle);
        return ArticleResponse.of(newArticle);
    }

    @Transactional(readOnly = false)
    public ArticleResponse updateArticle(Long id, ArticleRequest request) {
        Article article = articleRepository.findById(id).get();
        article.update(request);
        return ArticleResponse.of(article);
    }
}
