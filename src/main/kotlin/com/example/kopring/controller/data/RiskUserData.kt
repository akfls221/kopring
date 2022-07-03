package com.example.kopring.controller.data

import com.example.kopring.service.riskuser.vo.RegisterInfo
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class RiskUserData {
}

class RiskUserInfo{
    data class RegisterRequest(
        @field:NotBlank(message = "비어 있는 값일 수 없습니다.")
        val accNo: String?,
        @field:Email(message = "올바른 이메일 형식이 아닙니다.")
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
