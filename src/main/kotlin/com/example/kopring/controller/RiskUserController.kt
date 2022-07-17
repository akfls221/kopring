package com.example.kopring.controller

import com.example.kopring.controller.data.RiskUserData
import com.example.kopring.controller.data.RiskUserInfo
import com.example.kopring.service.riskuser.RiskUserDeleteService
import com.example.kopring.service.riskuser.RiskUserModifyService
import com.example.kopring.service.riskuser.RiskUserQueryService
import com.example.kopring.service.riskuser.implement.RiskUserAddService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class RiskUserController(
    private val riskUserAddService: RiskUserAddService,
    private val riskUserModifyService: RiskUserModifyService,
    private val riskUserQueryService: RiskUserQueryService,
    private val riskUserDeleteService: RiskUserDeleteService
) {

    /**
     * 블랙리스트 유저 ADD
     */
    @PostMapping("/api/add")
    fun addRiskUser(@RequestBody @Valid request: RiskUserInfo.RegisterRequest): ResponseEntity<RiskUserInfo.RegisterResponse> {
        return ResponseEntity.ok(riskUserAddService.register(request.toRegisterInfo()))
    }

    @PostMapping("/api/{id}")
    fun editRiskUser(
        @PathVariable id: Long,
        @RequestBody @Valid request: RiskUserInfo.ModifyRequest
    ): ResponseEntity<RiskUserInfo.ModifyResponse> {
        return ResponseEntity.ok(riskUserModifyService.modify(id, request.toModifyInfo()))

    }

    /**
     * 블랙리스트 상세정보 GET
     */
    @GetMapping("/api/{id}")
    fun detailRiskUser(@PathVariable id: Long): RiskUserData.FormData {
        return riskUserQueryService.getRiskUserById(id)
    }

    /**
     * 블랙리스트 유저 삭제
     */
    @DeleteMapping("/api/{id}")
    fun deleteRiskUser(@PathVariable id: Long) : RiskUserInfo.DeleteResponse{
        return riskUserDeleteService.deleteRiscUser(id)
    }
}

