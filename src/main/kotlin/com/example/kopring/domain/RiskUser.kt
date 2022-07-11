package com.example.kopring.domain

import com.example.kopring.domain.core.AbstractEntity
import com.example.kopring.domain.core.AuditEntity
import com.example.kopring.service.riskuser.vo.ModifyInfo
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
    var id: Long? = null,

    var accNo: String? = null,

    var email: String? = null,

    var firstName: String? = null,

    var lastName: String? = null,

    var localName: String? = null,

    var bsb: String? = null,

    var bank: String? = null,

    var mobile: String? = null,

    var reason: String? = null,

) : AuditEntity() {

    fun modify(modifyInfo: ModifyInfo) {
        modifyInfo.accNo?.let { accNo = modifyInfo.accNo }
        modifyInfo.email?.let { email = modifyInfo.email }
        modifyInfo.firstName?.let { firstName = modifyInfo.firstName }
        modifyInfo.localName?.let { localName = modifyInfo.localName }
        modifyInfo.bsb?.let { bsb = modifyInfo.bsb }
        modifyInfo.bank?.let { bank = modifyInfo.bank }
        modifyInfo.mobile?.let { mobile = modifyInfo.mobile }
        modifyInfo.reason?.let { reason = modifyInfo.reason }

    }

}