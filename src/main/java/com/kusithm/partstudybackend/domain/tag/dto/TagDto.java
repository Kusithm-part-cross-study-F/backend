package com.kusithm.partstudybackend.domain.tag.dto;

import com.kusithm.partstudybackend.domain.tag.entity.Tag;
import com.kusithm.partstudybackend.domain.tag.entity.TagType;
import lombok.Getter;

@Getter
public class TagDto {
    TagType tagType;

    public Tag toEntity(TagType type){
        return new Tag(type);
    }
    public TagDto (Tag tag){
        this.tagType = tag.getType();
    }
}
