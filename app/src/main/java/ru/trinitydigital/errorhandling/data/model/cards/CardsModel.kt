package ru.trinitydigital.errorhandling.data.model.cards

data class CardsModel(
    val rows: List<RowsItem>,
    val total_count: Int
)