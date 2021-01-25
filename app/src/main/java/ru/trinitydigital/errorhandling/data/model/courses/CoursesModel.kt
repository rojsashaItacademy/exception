package ru.trinitydigital.errorhandling.data.model.courses

data class CoursesModel<T>(
    val rows: List<T>,
    val total_count: Int
)