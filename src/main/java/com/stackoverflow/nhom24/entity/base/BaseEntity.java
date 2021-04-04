package com.stackoverflow.nhom24.entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
}
