package com.kusithm.partstudybackend.domain.tag.entity;

import com.kusithm.partstudybackend.domain.article.entity.Article;
import com.kusithm.partstudybackend.global.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "TAG")
public class Tag extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="tag_id")
    Long id;

    @Enumerated(EnumType.STRING)
    TagType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    Article article;

    public Tag(TagType type){
        this.type = type;
    }
    public void setArticle(Article article, TagType tagType){
        this.article = article;
        this.type = tagType;
    }
}
