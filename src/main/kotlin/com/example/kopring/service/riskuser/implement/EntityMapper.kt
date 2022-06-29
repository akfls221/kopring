package com.example.kopring.service.riskuser.implement

import com.example.kopring.controller.data.RiskUserInfo
import com.example.kopring.domain.RiskUser
import com.example.kopring.service.riskuser.vo.RegisterInfo
import org.springframework.stereotype.Component

@Component
class EntityMapper {
    fun convertToEntity(registerInfo: RegisterInfo) = RiskUser(
        accNo = registerInfo.accNo,
        email = registerInfo.email,
        firstName = registerInfo.firstName,
        lastName = registerInfo.lastName,
        localName = registerInfo.localName,
        bsb = registerInfo.bsb,
        bank = registerInfo.bank,
        mobile = registerInfo.mobile,
        reason = registerInfo.reason
    )

    fun convertToRiskUserInfoRegisterResponse(riskUser: RiskUser) =  RiskUserInfo.RegisterResponse(
        registId = riskUser.id,
        dateTime = riskUser.regDate
    )

}