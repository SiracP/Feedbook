package com.sirac.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_entries", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "entry_id"}, name = "uq_user_entries")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntries extends BaseEntity{

    @ManyToOne
    private User user;

    @ManyToOne
    private Entry entry;
}
