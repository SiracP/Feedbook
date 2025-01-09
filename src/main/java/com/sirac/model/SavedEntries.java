package com.sirac.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "saved_entries", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "entry_id"}, name = "uq_saved_entries")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavedEntries extends BaseEntity{

    @ManyToOne
    private User user;

    @ManyToOne
    private Entry entry;

}
