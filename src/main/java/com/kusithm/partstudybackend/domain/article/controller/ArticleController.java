package com.kusithm.partstudybackend.domain.article.controller;

import com.kusithm.partstudybackend.domain.article.dto.request.ArticleRequest;
import com.kusithm.partstudybackend.domain.article.dto.response.ArticleResponse;
import com.kusithm.partstudybackend.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
@RestController
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleResponse> createArticle(@RequestBody ArticleRequest request) {
        return ResponseEntity.ok(articleService.createArticle(request));
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable("articleId") Long articleId, @RequestBody ArticleRequest request) {
        return ResponseEntity.ok(articleService.updateArticle(articleId, request));
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> getArticles() {
        return ResponseEntity.ok(articleService.findArticles());
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleResponse> getOne(@PathVariable("articleId") Long articleId) {
        return ResponseEntity.ok(articleService.getOne(articleId));
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<ArticleResponse> deleteOne(@PathVariable("articleId") Long articleId) {
        return ResponseEntity.ok(articleService.deleteOne(articleId));
    }

}
