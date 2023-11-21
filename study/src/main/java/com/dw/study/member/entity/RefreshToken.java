package com.dw.study.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RefreshToken {
    // key 에는 Member ID 값이 들어간다.
    @Id
    @Column(name = "rt_key")
    private String key;

    // value 에는 Refresh Token String 이 들어간다.
    @Column(name = "rt_value")
    private String value;

    @Builder
    public RefreshToken(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public RefreshToken updateValue(String token) {
        this.value = token;
        return this;
    }
}
