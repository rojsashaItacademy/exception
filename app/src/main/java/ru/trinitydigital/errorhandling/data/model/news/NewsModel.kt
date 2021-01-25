package ru.trinitydigital.errorhandling.data.model.news

import ru.trinitydigital.errorhandling.data.model.cards.RowsItem

data class NewsModel(
    val rows: List<RowsItem>,
    val total_count: Int
)