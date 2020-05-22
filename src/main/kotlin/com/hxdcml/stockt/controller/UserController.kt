package com.hxdcml.stockt.controller

import com.hxdcml.stockt.model.request.CreateUserRequest
import com.hxdcml.stockt.model.response.CreateUserResponse
import mu.KotlinLogging
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * The controller class that will be interacting as the gateway for
 * the API for all endpoints associated to `/stockt/user`.
 *
 * @author Soul
 */
@RestController
@RequestMapping("/stockt/user")
class UserController {
    private val logger = KotlinLogging.logger { }

    @PostMapping(value = ["/create"], consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun createUser(@RequestBody request: CreateUserRequest): CreateUserResponse {
        logger.info("Creating User: ${request.name}")

        return CreateUserResponse(status = "OK", id = "_placeholder_")
    }
}