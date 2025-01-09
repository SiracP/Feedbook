package com.sirac.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "likes", uniqueConstraints = {@UniqueConstraint(columnNames = {"entry_id", "user_id"}, name = "uq_likes")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Likes extends BaseEntity{

    @ManyToOne
    private Entry entry;

    @ManyToOne
    private User user;
}
