package com.hxdcml.stockt.model.request

/**
 * Create user request data class for endpoint input.
 *
 * @author Soul
 */
data class CreateUserRequest(
    val name: String?,
    val age: Int?
)