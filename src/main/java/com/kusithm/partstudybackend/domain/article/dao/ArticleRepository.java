package com.kusithm.partstudybackend.domain.article.dao;

import com.kusithm.partstudybackend.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
