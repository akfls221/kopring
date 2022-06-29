package com.example.kopring.controller.data

import com.example.kopring.service.riskuser.vo.RegisterInfo
import java.time.LocalDateTime

class RiskUserData {
}

class RiskUserInfo{
    data class RegisterRequest(
        val accNo: String? = null,
        val email: String? = null,
        val firstName: String? = null,
        val lastName: String? = null,
        val localName: String? = null,
        val bsb: String? = null,
        val bank: String? = null,
        val mobile: String? = null,
        val reason: String? = null,
    ){
        /**
         * Dto > Vo conver
         */
        fun toRegisterInfo() = RegisterInfo (
            accNo = accNo,
            email = email,
            firstName = firstName,
            lastName = lastName,
            localName = localName,
            bsb = bsb,
            bank = bank,
            mobile = mobile,
            reason = reason
        )
    }

    data class RegisterResponse(
        val registId : Long?,
        val dateTime: LocalDateTime? = null
    )
}
