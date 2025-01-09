package com.sirac.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "following_users", uniqueConstraints = {@UniqueConstraint(columnNames = {"follower_id", "following_id"}, name = "uq_following_users")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowingUsers extends BaseEntity{

    @ManyToOne
    private User follower;

    @ManyToOne
    private User following;
}
