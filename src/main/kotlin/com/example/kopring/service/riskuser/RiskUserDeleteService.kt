package com.example.kopring.service.riskuser

import com.example.kopring.controller.data.RiskUserInfo
import com.example.kopring.service.riskuser.implement.EntityMapper
import com.example.kopring.service.riskuser.implement.RiskUserAppend
import com.example.kopring.service.riskuser.implement.RiskUserDelete
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface RiskUserDeleteService {
    fun deleteRiscUser(id : Long) : RiskUserInfo.DeleteResponse
}

@Service
@Transactional
class RiskUserDeleteServiceImpl(
    private val riskUserDelete : RiskUserDelete,
    private val entityMapper: EntityMapper
): RiskUserDeleteService{
    override fun deleteRiscUser(id: Long): RiskUserInfo.DeleteResponse {
        return riskUserDelete.deleteUser(id)
    }
}


