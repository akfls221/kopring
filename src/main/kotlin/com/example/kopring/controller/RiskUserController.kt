package com.example.kopring.controller

import com.example.kopring.data.RiskUserData
import com.example.kopring.domain.RiskUser
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RiskUserController {

    @PostMapping("/api/add")
    fun addRiskUser(@RequestBody request: RiskUserData.RegisterRequest) : RiskUserData.RegisterResponse {
        print(request)
        return RiskUserData.RegisterResponse(1, null)
    }
}

