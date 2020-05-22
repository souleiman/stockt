package com.hxdcml.stockt.model.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class CreateUserResponse(
    val status: String,
    val id: String?
)