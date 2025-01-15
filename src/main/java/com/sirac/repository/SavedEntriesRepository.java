package com.sirac.repository;

import com.sirac.model.SavedEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SavedEntriesRepository extends JpaRepository<SavedEntries,Long> {

    Optional<SavedEntries> findDistinctByUserIdAndEntryId(Long userId, Long entryId);
}
