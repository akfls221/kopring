package com.example.kopring.domain

import com.example.kopring.domain.core.AbstractEntity
import javax.persistence.Entity

@Entity
class RiskUser (

    val accNo: String? = null,

    val email: String? = null,

    val firstName: String? = null,

    val lastName: String? = null,

    val localName: String? = null,

    val bsb: String? = null,

    val bank: String? = null,

    val mobile: String? = null,

    val reason: String? = null,

) : AbstractEntity() {

}