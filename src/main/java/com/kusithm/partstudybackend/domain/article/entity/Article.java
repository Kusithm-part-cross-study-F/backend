package com.kusithm.partstudybackend.domain.article.entity;

import com.kusithm.partstudybackend.domain.tag.entity.Tag;
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

    public void setTags(List<Tag> tags){
        this.tags = tags;
    }
}
