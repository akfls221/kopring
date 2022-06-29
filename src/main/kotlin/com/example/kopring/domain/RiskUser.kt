package com.example.kopring.domain

import com.example.kopring.domain.core.AbstractEntity
import com.example.kopring.domain.core.AuditEntity
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class RiskUser (

    @Id
    @GeneratedValue
    @Column(name = "riskuser_id")
    val id: Long? = null,

    val accNo: String? = null,

    val email: String? = null,

    val firstName: String? = null,

    val lastName: String? = null,

    val localName: String? = null,

    val bsb: String? = null,

    val bank: String? = null,

    val mobile: String? = null,

    val reason: String? = null,

) : AuditEntity() {

}