package com.dw.study.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SequenceGenerator(name = "SEQ_MEMBER_ID", sequenceName = "SEQ_MEMBER_ID", initialValue = 1, allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {
    @JsonIgnore
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER_ID")
    private Long id;

    @Column(length = 45, unique = true)
    private String memberName;

    @Column(length = 45, unique = true)
    private String email;

    @Column(length = 45)
    private String nickname;


    @Column(length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;



}