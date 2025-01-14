package com.sirac.repository;

import com.sirac.model.SavedEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedEntriesRepository extends JpaRepository<SavedEntries,Long> {
}
