package com.example.kopring.service.riskuser.implement


import com.example.kopring.domain.RiskUser
import com.example.kopring.exception.TkException
import com.example.kopring.exception.enum.Status
import com.example.kopring.repository.RiskUserRepository
import com.example.kopring.service.riskuser.vo.ModifyInfo
import com.example.kopring.service.riskuser.vo.RegisterInfo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class RiskUserAppend (
    private val riskUserRepository: RiskUserRepository,
    private val entityMapper: EntityMapper
){

    fun add(registerInfo: RegisterInfo) : RiskUser {
        return riskUserRepository.save(entityMapper.convertToEntity(registerInfo))
    }

    fun update(id: Long, modifyInfo: ModifyInfo): RiskUser {
        val riskUser = riskUserRepository.findByIdOrNull(id) ?: throw TkException(
            HttpStatus.BAD_REQUEST,
            Status.NoExistEx.code,
            Status.NoExistEx.dec
        )
        riskUser.modify(modifyInfo)
        return riskUserRepository.save(riskUser)
    }
}