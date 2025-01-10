package com.sirac.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "refresh_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken extends BaseEntity{

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "expire_date")
    private Date expireDate;

    @ManyToOne
    private LoginUser LoginUser;
}
