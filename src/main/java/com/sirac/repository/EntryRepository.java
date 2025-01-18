package com.sirac.repository;

import com.sirac.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry,Long> {

    public List<Entry> findAllByTopicId(Long topicId);
}
