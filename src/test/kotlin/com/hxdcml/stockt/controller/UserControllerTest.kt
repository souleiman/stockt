package com.hxdcml.stockt.controller

import com.hxdcml.stockt.model.request.CreateUserRequest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
@DisplayName("User Controller")
internal class UserControllerTest {

    @InjectMocks
    private lateinit var controller: UserController

    @Test
    @DisplayName("Create will accept valid payload and return valid response")
    fun testCreateOnValidPayload() {
        val request = CreateUserRequest(name = "John", age = 21)
        val response = controller.createUser(request)

        assertNotNull(response)
        assertEquals("OK", response.status)
        assertEquals("_placeholder_", response.id)
    }
}