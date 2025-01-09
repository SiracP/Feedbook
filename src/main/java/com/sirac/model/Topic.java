package com.sirac.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "topic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic extends BaseEntity{

    @Column(name = "title")
    private String title;

    @ManyToOne
    private User user;

    @Column(name = "entry_count")
    private long entryCount;
}
