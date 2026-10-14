package com.example.ui.viewmodel

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.CafeDataRepository
import com.example.model.Article
import com.example.model.MenuItem
import com.example.model.NavigationTab
import com.example.model.PageMetadata
import com.example.model.ReservationRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CafeUiState(
    val currentTab: NavigationTab = NavigationTab.HOME,
    val activeArticle: Article? = null,
    val currentUrl: String = "https://mistandmocha.com/",
    val currentMetadata: PageMetadata = PageMetadata(
        path = "/",
        canonicalUrl = "https://mistandmocha.com/",
        title = "Mist and Mocha | Artisan Specialty Coffee, Handcrafted Espresso & Slow Pour Roastery",
        mainKeyword = "Artisan Specialty Coffee",
        relatedKeywords = listOf("Handcrafted Espresso", "Slow Pour Roastery"),
        metaDescription = "Welcome to Mist and Mocha cafe. Discover handcrafted espresso, slow pour roastery single-origins, fresh sourdough bakery, and table reservations.",
        ogTitle = "Mist and Mocha Cafe & Roastery",
        ogDescription = "Experience elevated coffee rituals, single-origin flights, and artisan bakery at Mist and Mocha.",
        loadSpeedMs = 148,
        performanceScore = 99
    ),
    val searchQuery: String = "",
    val selectedCategory: String = "All",
    val bookmarkedSlugs: Set<String> = emptySet(),
    val showReservationDialog: Boolean = false,
    val showSeoInspector: Boolean = false,
    val showQuickOrderDialog: Boolean = false,
    val toastMessage: String? = null,
    val isPageLoading: Boolean = false,
    val reservations: List<ReservationRequest> = emptyList(),
    val orderCartCount: Int = 0
)

class CafeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CafeUiState())
    val uiState: StateFlow<CafeUiState> = _uiState.asStateFlow()

    fun selectTab(tab: NavigationTab) {
        val meta = when (tab) {
            NavigationTab.HOME -> PageMetadata(
                path = "/",
                canonicalUrl = "https://mistandmocha.com/",
                title = "Mist and Mocha | Artisan Specialty Coffee, Handcrafted Espresso & Slow Pour Roastery",
                mainKeyword = "Artisan Specialty Coffee",
                relatedKeywords = listOf("Handcrafted Espresso", "Slow Pour Roastery"),
                metaDescription = "Welcome to Mist and Mocha cafe. Discover handcrafted espresso, slow pour roastery single-origins, fresh sourdough bakery, and table reservations.",
                ogTitle = "Mist and Mocha Cafe & Roastery",
                ogDescription = "Experience elevated coffee rituals, single-origin flights, and artisan bakery at Mist and Mocha."
            )
            NavigationTab.BLOG -> PageMetadata(
                path = "/blog",
                canonicalUrl = "https://mistandmocha.com/blog",
                title = "Coffee Journal: Brewing Guides, Roasting Kinetics & Barista Science | Mist and Mocha",
                mainKeyword = "Coffee Journal",
                relatedKeywords = listOf("Brewing Guides", "Roasting Kinetics"),
                metaDescription = "Explore the Mist & Mocha coffee journal featuring 11+ in-depth brewing guides, roasting kinetics, bean origins, and Q&A barista masterclasses.",
                ogTitle = "Mist and Mocha Coffee Journal",
                ogDescription = "In-depth guides on espresso extraction, pour-over chemistry, and bean roasting kinetics."
            )
            NavigationTab.MENU -> PageMetadata(
                path = "/menu",
                canonicalUrl = "https://mistandmocha.com/menu",
                title = "Artisan Menu: Specialty Coffee Drinks, Sourdough Pastries & Pour-Over Flights",
                mainKeyword = "Specialty Coffee Drinks",
                relatedKeywords = listOf("Sourdough Pastries", "Pour-Over Flights"),
                metaDescription = "Indulge in specialty coffee drinks, flaky sourdough pastries, and single-origin pour-over flights prepared fresh daily at Mist & Mocha.",
                ogTitle = "Mist and Mocha Artisan Menu",
                ogDescription = "Handcrafted espresso drinks, signature cardamom mochas, and freshly baked artisan sourdough pastries."
            )
            NavigationTab.RESERVE -> PageMetadata(
                path = "/reserve",
                canonicalUrl = "https://mistandmocha.com/reserve",
                title = "Table Reservation: Barista Tasting Flights, Cafe Seating & Cupping Workshops",
                mainKeyword = "Table Reservation",
                relatedKeywords = listOf("Barista Tasting Flights", "Cupping Workshops"),
                metaDescription = "Book your table reservation at Mist and Mocha. Experience exclusive barista tasting flights, hearth seating, and weekend cupping workshops.",
                ogTitle = "Reserve a Table at Mist and Mocha",
                ogDescription = "Book your cozy hearth table or sensory coffee tasting experience."
            )
            NavigationTab.ABOUT -> PageMetadata(
                path = "/about",
                canonicalUrl = "https://mistandmocha.com/about",
                title = "Our Story: Sustainable Sourcing, Micro-Batch Roasting & Cafe Philosophy",
                mainKeyword = "Sustainable Sourcing",
                relatedKeywords = listOf("Micro-Batch Roasting", "Cafe Philosophy"),
                metaDescription = "Learn the Mist and Mocha story: sustainable sourcing from mist-altitude farms, cast-iron micro-batch roasting, and community cafe craft.",
                ogTitle = "Our Story & Philosophy | Mist and Mocha",
                ogDescription = "Rooted in intentional coffee craft, highland mist sourcing, and slow roasting."
            )
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isPageLoading = true) }
            delay(120) // Simulated ultra-fast load (<200ms)
            _uiState.update {
                it.copy(
                    currentTab = tab,
                    activeArticle = null,
                    currentUrl = tab.url,
                    currentMetadata = meta,
                    isPageLoading = false
                )
            }
        }
    }

    fun openArticle(slug: String) {
        val article = CafeDataRepository.getArticleBySlug(slug) ?: return
        val meta = PageMetadata(
            path = "/blog/$slug",
            canonicalUrl = article.canonicalUrl,
            title = "${article.title} | Mist & Mocha",
            mainKeyword = article.mainKeyword,
            relatedKeywords = article.relatedKeywords,
            metaDescription = article.metaDescription,
            ogTitle = article.title,
            ogDescription = article.metaDescription,
            loadSpeedMs = 135,
            performanceScore = 99
        )

        viewModelScope.launch {
            _uiState.update { it.copy(isPageLoading = true) }
            delay(100)
            _uiState.update {
                it.copy(
                    currentTab = NavigationTab.BLOG,
                    activeArticle = article,
                    currentUrl = article.canonicalUrl,
                    currentMetadata = meta,
                    isPageLoading = false
                )
            }
        }
    }

    fun closeArticle() {
        selectTab(NavigationTab.BLOG)
    }

    fun navigateByUrl(inputUrl: String) {
        val clean = inputUrl.trim().lowercase()
        when {
            clean.endsWith("/blog") || clean == "mistandmocha.com/blog" -> selectTab(NavigationTab.BLOG)
            clean.contains("/blog/") -> {
                val slug = clean.substringAfter("/blog/").substringBefore("?").substringBefore("#")
                openArticle(slug)
            }
            clean.endsWith("/menu") || clean == "mistandmocha.com/menu" -> selectTab(NavigationTab.MENU)
            clean.endsWith("/reserve") || clean == "mistandmocha.com/reserve" -> selectTab(NavigationTab.RESERVE)
            clean.endsWith("/about") || clean == "mistandmocha.com/about" -> selectTab(NavigationTab.ABOUT)
            else -> selectTab(NavigationTab.HOME)
        }
    }

    fun setSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun setSelectedCategory(category: String) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun toggleBookmark(slug: String) {
        _uiState.update { current ->
            val set = current.bookmarkedSlugs.toMutableSet()
            if (set.contains(slug)) {
                set.remove(slug)
            } else {
                set.add(slug)
            }
            current.copy(
                bookmarkedSlugs = set,
                toastMessage = if (set.contains(slug)) "Article saved to bookmarks" else "Removed from bookmarks"
            )
        }
    }

    fun setReservationDialogOpen(open: Boolean) {
        _uiState.update { it.copy(showReservationDialog = open) }
    }

    fun setSeoInspectorOpen(open: Boolean) {
        _uiState.update { it.copy(showSeoInspector = open) }
    }

    fun setQuickOrderDialogOpen(open: Boolean) {
        _uiState.update { it.copy(showQuickOrderDialog = open) }
    }

    fun submitReservation(request: ReservationRequest) {
        _uiState.update {
            it.copy(
                reservations = it.reservations + request,
                showReservationDialog = false,
                toastMessage = "Table reserved for ${request.guestName} on ${request.date} at ${request.time}!"
            )
        }
    }

    fun addCartItem() {
        _uiState.update {
            val count = it.orderCartCount + 1
            it.copy(
                orderCartCount = count,
                toastMessage = "Added to order basket ($count items)"
            )
        }
    }

    fun copyCurrentUrl(context: Context) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Mist and Mocha URL", _uiState.value.currentUrl)
        clipboard.setPrimaryClip(clip)
        _uiState.update { it.copy(toastMessage = "Copied URL: ${_uiState.value.currentUrl}") }
    }

    fun dismissToast() {
        _uiState.update { it.copy(toastMessage = null) }
    }
}
