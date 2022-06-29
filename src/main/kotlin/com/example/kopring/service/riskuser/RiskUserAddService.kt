package com.example.kopring.service.riskuser.implement

import com.example.kopring.controller.data.RiskUserData
import com.example.kopring.controller.data.RiskUserInfo
import com.example.kopring.service.riskuser.vo.RegisterInfo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface RiskUserAddService{
    /**
     * 블랙리스트 유저 등록
     */
    fun register(registerInfo : RegisterInfo) : RiskUserInfo.RegisterResponse
}

@Service
@Transactional
class RiskUserAddServiceImpl(
    private val entityMapper: EntityMapper,
    private val riskUserAppend: RiskUserAppend
) : RiskUserAddService {
    
    override fun register(registerInfo : RegisterInfo) : RiskUserInfo.RegisterResponse {
        val riskUser = riskUserAppend.add(registerInfo)
        return entityMapper.convertToRiskUserInfoRegisterResponse(riskUser)
    }

}