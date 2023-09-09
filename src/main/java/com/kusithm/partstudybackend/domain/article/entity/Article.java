package com.kusithm.partstudybackend.domain.article.entity;

import com.kusithm.partstudybackend.domain.article.dto.request.ArticleRequest;
import com.kusithm.partstudybackend.domain.tag.entity.Tag;
import com.kusithm.partstudybackend.domain.tag.entity.TagType;
import com.kusithm.partstudybackend.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "ARTICLE")
public class Article extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "body")
    String body;

    @OneToMany(mappedBy = "article")
    List<Tag> tags = new ArrayList<>();

    @Builder
    public Article(String title, String description, String body) {
        this.title = title;
        this.description = description;
        this.body = body;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void update(ArticleRequest request) {
        List<String> tagStrigns = request.getTagList();
        List<Tag> tags = new ArrayList<>();
        for (String tagString : tagStrigns) {
            TagType type = TagType.valueOf(tagString);
            tags.add(new Tag(type));
        }
        this.tags = tags;
        this.body = request.getBody();
        this.title = request.getTitle();
        this.description = request.getDescription();
    }
}
