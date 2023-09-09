package com.kusithm.partstudybackend.domain.article.service;

import com.kusithm.partstudybackend.domain.article.dao.ArticleRepository;
import com.kusithm.partstudybackend.domain.article.dto.request.ArticleRequest;
import com.kusithm.partstudybackend.domain.article.dto.response.ArticleResponse;
import com.kusithm.partstudybackend.domain.article.entity.Article;
import com.kusithm.partstudybackend.domain.tag.TagRepository;
import com.kusithm.partstudybackend.domain.tag.entity.Tag;
import com.kusithm.partstudybackend.domain.tag.entity.TagType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final TagRepository tagRepository;

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
            Tag tag = new Tag(type);
            tag.setArticle(newArticle, type);
            tagRepository.save(tag);
            tags.add(tag);
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

    public List<ArticleResponse> findArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(ArticleResponse::of)
                .collect(Collectors.toList());
    }

    public ArticleResponse getOne(Long id) {
        Article article = articleRepository.findById(id).get();

        List<Tag> tags = article.getTags();

        for (Tag tag : tags) {
            System.out.println("tag.getType() = " + tag.getType());
        }

        return ArticleResponse.of(article);
    }

    @Transactional(readOnly = false)
    public ArticleResponse deleteOne(Long id) {
        Article article = articleRepository.findById(id).get();
        articleRepository.delete(article);
        return ArticleResponse.of(article);
    }
}
