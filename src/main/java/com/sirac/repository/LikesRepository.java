package com.sirac.repository;

import com.sirac.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Long> {

    Optional<Likes> findDistinctByUserIdAndEntryId(Long userId, Long entryId);
}
