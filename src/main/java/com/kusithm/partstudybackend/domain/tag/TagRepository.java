package com.kusithm.partstudybackend.domain.tag;

import com.kusithm.partstudybackend.domain.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
