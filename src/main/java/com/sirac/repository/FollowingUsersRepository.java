package com.sirac.repository;

import com.sirac.model.FollowingUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowingUsersRepository extends JpaRepository<FollowingUsers,Long> {

    Optional<FollowingUsers> findDistinctByFollowerIdAndFollowingId(Long followerId, Long followingId);

    List<FollowingUsers> findByFollowingId(Long followingId);

    List<FollowingUsers> findByFollowerId(Long followerId);
}
