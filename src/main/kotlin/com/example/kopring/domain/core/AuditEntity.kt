package com.example.kopring.domain.core

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class AuditEntity {

    @CreatedDate
    var regDate: LocalDateTime? = null

    @LastModifiedDate
    var uptDate: LocalDateTime? = null

}