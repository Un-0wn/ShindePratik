package com.example.shindepratik.ends

data class Dto(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<UserDto>,
)

data class UserDto(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)

data class Unk(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<UnkDto>,
)
data class UnkDto(
    val id: Int,
    val name: String,
    val year: Int,
    val color: String,
    val pantone_value: String
)
