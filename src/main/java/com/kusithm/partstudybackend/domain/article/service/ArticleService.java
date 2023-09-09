package com.kusithm.partstudybackend.domain.article.service;

import com.kusithm.partstudybackend.domain.article.dao.ArticleRepository;
import com.kusithm.partstudybackend.domain.article.dto.request.PostArticleRequest;
import com.kusithm.partstudybackend.domain.article.dto.response.ArticleResponse;
import com.kusithm.partstudybackend.domain.article.entity.Article;
import com.kusithm.partstudybackend.domain.tag.dto.TagDto;
import com.kusithm.partstudybackend.domain.tag.entity.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional(readOnly = false)
    public ArticleResponse createArticle(PostArticleRequest request) {
        Article newArticle = request.toEntity(
                request.getTitle(),
                request.getDescription(),
                request.getBody()
        );
        List<TagDto> tagDtos = request.getTagList();
        List<Tag> tags = new ArrayList<>();
        for (TagDto tagDto : tagDtos) {
            tags.add(tagDto.toEntity(tagDto.getTagType()));
        }
        newArticle.setTags(tags);
        articleRepository.save(newArticle);
        return ArticleResponse.of(newArticle);
    }
}
