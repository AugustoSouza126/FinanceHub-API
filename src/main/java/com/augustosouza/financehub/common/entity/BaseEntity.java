package com.augustosouza.financehub.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAT;

    @UpdateTimestamp
    @Column(nullable = false, updatable = false)
    private Instant updatedAT;
}
