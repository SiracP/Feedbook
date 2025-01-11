package com.sirac.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry extends BaseEntity {

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private User user;

    @Column(name = "content")
    private String content;

    @Column(name = "like_count")
    private Long likeCount;
}
