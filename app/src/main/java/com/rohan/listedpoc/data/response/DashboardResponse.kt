package com.rohan.listedpoc.data.response
import com.google.gson.annotations.SerializedName

data class DashboardResponse(
    @SerializedName("applied_campaign")
    val appliedCampaign: Int?,
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("extra_income")
    val extraIncome: Double?,
    @SerializedName("links_created_today")
    val linksCreatedToday: Int?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("startTime")
    val startTime: String?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("statusCode")
    val statusCode: Int?,
    @SerializedName("support_whatsapp_number")
    val supportWhatsappNumber: String?,
    @SerializedName("today_clicks")
    val todayClicks: Int?,
    @SerializedName("top_location")
    val topLocation: String?,
    @SerializedName("top_source")
    val topSource: String?,
    @SerializedName("total_clicks")
    val totalClicks: Int?,
    @SerializedName("total_links")
    val totalLinks: Int?
)


data class Links(
    @SerializedName("app")
    val app: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("domain_id")
    val domainId: String?,
    @SerializedName("original_image")
    val originalImage: String?,
    @SerializedName("smart_link")
    val smartLink: String?,
    @SerializedName("thumbnail")
    val thumbnail: Any?,
    @SerializedName("times_ago")
    val timesAgo: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("total_clicks")
    val totalClicks: Int?,
    @SerializedName("url_id")
    val urlId: Int?,
    @SerializedName("url_prefix")
    val urlPrefix: String?,
    @SerializedName("url_suffix")
    val urlSuffix: String?,
    @SerializedName("web_link")
    val webLink: String?
)


data class OverallUrlChart(
    @SerializedName("2023-05-27")
    val x20230527: Int?,
    @SerializedName("2023-05-28")
    val x20230528: Int?,
    @SerializedName("2023-05-29")
    val x20230529: Int?,
    @SerializedName("2023-05-30")
    val x20230530: Int?,
    @SerializedName("2023-05-31")
    val x20230531: Int?,
    @SerializedName("2023-06-01")
    val x20230601: Int?,
    @SerializedName("2023-06-02")
    val x20230602: Int?,
    @SerializedName("2023-06-03")
    val x20230603: Int?,
    @SerializedName("2023-06-04")
    val x20230604: Int?,
    @SerializedName("2023-06-05")
    val x20230605: Int?,
    @SerializedName("2023-06-06")
    val x20230606: Int?,
    @SerializedName("2023-06-07")
    val x20230607: Int?,
    @SerializedName("2023-06-08")
    val x20230608: Int?,
    @SerializedName("2023-06-09")
    val x20230609: Int?,
    @SerializedName("2023-06-10")
    val x20230610: Int?,
    @SerializedName("2023-06-11")
    val x20230611: Int?,
    @SerializedName("2023-06-12")
    val x20230612: Int?,
    @SerializedName("2023-06-13")
    val x20230613: Int?,
    @SerializedName("2023-06-14")
    val x20230614: Int?,
    @SerializedName("2023-06-15")
    val x20230615: Int?,
    @SerializedName("2023-06-16")
    val x20230616: Int?,
    @SerializedName("2023-06-17")
    val x20230617: Int?,
    @SerializedName("2023-06-18")
    val x20230618: Int?,
    @SerializedName("2023-06-19")
    val x20230619: Int?,
    @SerializedName("2023-06-20")
    val x20230620: Int?,
    @SerializedName("2023-06-21")
    val x20230621: Int?,
    @SerializedName("2023-06-22")
    val x20230622: Int?,
    @SerializedName("2023-06-23")
    val x20230623: Int?,
    @SerializedName("2023-06-24")
    val x20230624: Int?,
    @SerializedName("2023-06-25")
    val x20230625: Int?,
    @SerializedName("2023-06-26")
    val x20230626: Int?
)

data class Data(
    @SerializedName("overall_url_chart")
    val overallUrlChart: OverallUrlChart?,
    @SerializedName("recent_links")
    val recentLinks: List<Links?>?,
    @SerializedName("top_links")
    val topLinks: List<Links?>?
)
