package ru.trinitydigital.errorhandling.data.remote

import ru.trinitydigital.errorhandling.data.model.advice.AdviceOfDayModel
import ru.trinitydigital.errorhandling.data.model.bottomsheet.BottomSheetModel
import ru.trinitydigital.errorhandling.data.model.courses.CoursesModel
import ru.trinitydigital.errorhandling.data.model.courses.RowsItem
import ru.trinitydigital.errorhandling.data.model.cards.CardsModel
import ru.trinitydigital.errorhandling.data.model.news.NewsModel
import ru.trinitydigital.errorhandling.data.model.collections.CollectionsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.trinitydigital.errorhandling.data.model.ProfileModel

interface CoursesService {

    @GET("api/v1/educational_materials")
    suspend fun getCourses(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String
    ): CoursesModel<RowsItem>

    //https://api.sambo.beta.trinitydigital.ru/api/v1/educational_materials?limit=20&page=1&category_id=1&order={"id":"asc"}

    @GET("api/v1/categories")
    suspend fun getBottomSheet(
        @Query("limit") limit: Int,  // для пагинации лимит сколько можно загружать
        @Query("page") page: Int,
        @Query("order") order: String
    ): Response<BottomSheetModel>

    // https://api.sambo.beta.trinitydigital.ru/ api/v1/categories ? limit =20 & page=1 & order="{\"id\":\"asc\"}"

    @GET("api/v1/main_materials")
    suspend fun loadCards(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String
    ): Response<CardsModel>

//    https://api.sambo.beta.trinitydigital.ru/api/v1/main_materials?limit=20&page=1&order={"rank":"asc"}

    @GET("api/v1/selections")
    suspend fun loadCollections(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String
    ): Response<CollectionsModel>

    // https://api.sambo.beta.trinitydigital.ru/api/v1/selections?limit=20&page=1&order={"rank":"asc"}

    @GET("api/v1/educational_materials")
    suspend fun loadSelectionsData(
        @Query("limit") limit: Int,
        @Query("selection_id") selectionId: Int,
        @Query("page") page: Int
    ): Response<CollectionsModel>

    @GET("api/v1/articles")
    suspend fun loadNews(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String
    ): Response<NewsModel>

    // https://api.sambo.beta.trinitydigital.ru/api/v1/articles?limit=20&page=1&order={"created_at":"asc"}

    @GET("api/v1/advices/1")
    suspend fun adviceOfDay(
    ): AdviceOfDayModel


    // ResultWrapper<ProfileModel?>
    @GET("api/v1/users/profile")
    suspend fun loadUserProfile(): ProfileModel?
}