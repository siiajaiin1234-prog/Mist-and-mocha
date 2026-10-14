package com.example.model

data class ArticleSection(
    val heading: String, // Can be Q&A format e.g. "Why does water temperature matter for pour-over coffee?"
    val isQuestionAnswer: Boolean = false,
    val paragraphs: List<String>,
    val anchorLinkText: String? = null,
    val anchorLinkUrl: String? = null,
    val baristaTip: String? = null
)

data class Article(
    val id: String,
    val slug: String,
    val canonicalUrl: String, // e.g. https://mistandmocha.com/blog/art-of-slow-pour-over-brewing
    val title: String, // Contains 1 main keyword and 2 related keywords
    val mainKeyword: String,
    val relatedKeywords: List<String>,
    val metaDescription: String, // 140-160 characters rule-compliant
    val category: String,
    val author: String,
    val authorRole: String,
    val datePublished: String,
    val readingTimeMinutes: Int,
    val localDrawableRes: Int? = null,
    val imageUrl: String,
    val imageAlt: String,
    val imageSizeKb: Int, // Under 100 KB
    val excerpt: String,
    val sections: List<ArticleSection>,
    val tags: List<String>,
    val likesCount: Int = 42,
    val isBookmarked: Boolean = false
)

data class MenuItem(
    val id: String,
    val name: String,
    val category: String, // Espresso, Slow Pour, Cold Brew, Pastries
    val price: String,
    val description: String,
    val tastingNotes: List<String>,
    val isSignature: Boolean = false,
    val imageSizeKb: Int = 68
)

data class ReservationRequest(
    val guestName: String,
    val email: String,
    val phone: String,
    val partySize: Int,
    val date: String,
    val time: String,
    val seatingArea: String, // Indoor Hearth, Window Bar, Mist Garden Patio
    val experienceType: String, // Regular Seating, Roastery Tasting Flight, Cupping Workshop
    val notes: String = ""
)

data class PageMetadata(
    val path: String,
    val canonicalUrl: String,
    val title: String,
    val mainKeyword: String,
    val relatedKeywords: List<String>,
    val metaDescription: String,
    val schemaType: String = "Article",
    val ogTitle: String,
    val ogDescription: String,
    val loadSpeedMs: Int = 185,
    val performanceScore: Int = 99
)

enum class NavigationTab(val route: String, val label: String, val url: String) {
    HOME("home", "Cafe & Roastery", "https://mistandmocha.com/"),
    BLOG("blog", "Coffee Journal", "https://mistandmocha.com/blog"),
    MENU("menu", "Artisan Menu", "https://mistandmocha.com/menu"),
    RESERVE("reserve", "Table Booking", "https://mistandmocha.com/reserve"),
    ABOUT("about", "Our Story", "https://mistandmocha.com/about")
}
