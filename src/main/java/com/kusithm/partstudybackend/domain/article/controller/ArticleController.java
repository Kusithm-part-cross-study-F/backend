package com.kusithm.partstudybackend.domain.article.controller;

import com.kusithm.partstudybackend.domain.article.dto.request.PostArticleRequest;
import com.kusithm.partstudybackend.domain.article.dto.response.ArticleResponse;
import com.kusithm.partstudybackend.domain.article.dto.response.GetArticlesResponse;
import com.kusithm.partstudybackend.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
@RestController
public class ArticleController {
    private final ArticleService articleService;
    @PostMapping
    public ResponseEntity<ArticleResponse> createArticle(@RequestBody PostArticleRequest request) {
        log.warn(request.getTitle());

        return ResponseEntity.ok(articleService.createArticle(request));
    }
}
