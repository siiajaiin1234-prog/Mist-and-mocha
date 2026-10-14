package com.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.RestaurantMenu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.NavigationTab
import com.example.ui.components.BrowserAddressBar
import com.example.ui.components.ReservationDialog
import com.example.ui.components.SeoInspectorSheet
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.ArticleDetailScreen
import com.example.ui.screens.BlogListScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.MenuScreen
import com.example.ui.theme.CaramelAmber
import com.example.ui.theme.MistAndMochaTheme
import com.example.ui.theme.MistSage
import com.example.ui.theme.MochaPrimary
import com.example.ui.viewmodel.CafeViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: CafeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MistAndMochaTheme {
                MistAndMochaApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MistAndMochaApp(viewModel: CafeViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    // Toast & Snackbar feedback
    LaunchedEffect(uiState.toastMessage) {
        uiState.toastMessage?.let { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            viewModel.dismissToast()
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isWideScreen = maxWidth > 600.dp

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars),
            topBar = {
                BrowserAddressBar(
                    currentUrl = uiState.currentUrl,
                    metadata = uiState.currentMetadata,
                    isLoading = uiState.isPageLoading,
                    onNavigateUrl = { viewModel.navigateByUrl(it) },
                    onCopyUrl = { viewModel.copyCurrentUrl(context) },
                    onOpenSeoInspector = { viewModel.setSeoInspectorOpen(true) }
                )
            },
            bottomBar = {
                if (!isWideScreen) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface,
                        tonalElevation = 3.dp,
                        modifier = Modifier
                            .windowInsetsPadding(WindowInsets.navigationBars)
                            .testTag("mobile_bottom_navigation")
                    ) {
                        NavigationTab.entries.forEach { tab ->
                            val isSelected = uiState.currentTab == tab && uiState.activeArticle == null
                            val icon = when (tab) {
                                NavigationTab.HOME -> if (isSelected) Icons.Filled.Coffee else Icons.Outlined.Coffee
                                NavigationTab.BLOG -> if (isSelected) Icons.Filled.MenuBook else Icons.Outlined.MenuBook
                                NavigationTab.MENU -> if (isSelected) Icons.Filled.RestaurantMenu else Icons.Outlined.RestaurantMenu
                                NavigationTab.RESERVE -> if (isSelected) Icons.Filled.CalendarMonth else Icons.Outlined.CalendarMonth
                                NavigationTab.ABOUT -> if (isSelected) Icons.Filled.Info else Icons.Outlined.Info
                            }

                            NavigationBarItem(
                                selected = isSelected,
                                onClick = {
                                    if (tab == NavigationTab.RESERVE) {
                                        viewModel.setReservationDialogOpen(true)
                                    } else {
                                        viewModel.selectTab(tab)
                                    }
                                },
                                icon = {
                                    if (tab == NavigationTab.BLOG) {
                                        BadgedBox(badge = {
                                            Badge(containerColor = CaramelAmber) {
                                                Text("11", fontSize = 9.sp, color = Color.White)
                                            }
                                        }) {
                                            Icon(imageVector = icon, contentDescription = tab.label)
                                        }
                                    } else {
                                        Icon(imageVector = icon, contentDescription = tab.label)
                                    }
                                },
                                label = {
                                    Text(
                                        text = tab.label,
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                        )
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MochaPrimary,
                                    selectedTextColor = MochaPrimary,
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                ),
                                modifier = Modifier.testTag("nav_item_${tab.route}")
                            )
                        }
                    }
                }
            },
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Tablet Navigation Rail for wide displays
                if (isWideScreen) {
                    NavigationRail(
                        containerColor = MaterialTheme.colorScheme.surface,
                        modifier = Modifier
                            .fillMaxHeight()
                            .windowInsetsPadding(WindowInsets.navigationBars)
                            .testTag("tablet_navigation_rail")
                    ) {
                        Spacer(modifier = Modifier.height(12.dp))
                        NavigationTab.entries.forEach { tab ->
                            val isSelected = uiState.currentTab == tab && uiState.activeArticle == null
                            val icon = when (tab) {
                                NavigationTab.HOME -> if (isSelected) Icons.Filled.Coffee else Icons.Outlined.Coffee
                                NavigationTab.BLOG -> if (isSelected) Icons.Filled.MenuBook else Icons.Outlined.MenuBook
                                NavigationTab.MENU -> if (isSelected) Icons.Filled.RestaurantMenu else Icons.Outlined.RestaurantMenu
                                NavigationTab.RESERVE -> if (isSelected) Icons.Filled.CalendarMonth else Icons.Outlined.CalendarMonth
                                NavigationTab.ABOUT -> if (isSelected) Icons.Filled.Info else Icons.Outlined.Info
                            }

                            NavigationRailItem(
                                selected = isSelected,
                                onClick = {
                                    if (tab == NavigationTab.RESERVE) {
                                        viewModel.setReservationDialogOpen(true)
                                    } else {
                                        viewModel.selectTab(tab)
                                    }
                                },
                                icon = {
                                    if (tab == NavigationTab.BLOG) {
                                        BadgedBox(badge = {
                                            Badge(containerColor = CaramelAmber) {
                                                Text("11", fontSize = 9.sp)
                                            }
                                        }) {
                                            Icon(imageVector = icon, contentDescription = tab.label)
                                        }
                                    } else {
                                        Icon(imageVector = icon, contentDescription = tab.label)
                                    }
                                },
                                label = { Text(tab.label) },
                                colors = NavigationRailItemDefaults.colors(
                                    selectedIconColor = MochaPrimary,
                                    selectedTextColor = MochaPrimary,
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            )
                        }
                    }
                }

                // Main Content Area with Animated Page Transition
                Box(modifier = Modifier.fillMaxSize()) {
                    AnimatedContent(
                        targetState = Pair(uiState.currentTab, uiState.activeArticle),
                        transitionSpec = { fadeIn() togetherWith fadeOut() },
                        label = "page_transition"
                    ) { (tab, article) ->
                        when {
                            article != null -> {
                                ArticleDetailScreen(
                                    article = article,
                                    isBookmarked = uiState.bookmarkedSlugs.contains(article.slug),
                                    onToggleBookmark = { viewModel.toggleBookmark(article.slug) },
                                    onBack = { viewModel.closeArticle() },
                                    onNavigateUrl = { viewModel.navigateByUrl(it) },
                                    onOpenReservation = { viewModel.setReservationDialogOpen(true) }
                                )
                            }
                            tab == NavigationTab.HOME -> {
                                HomeScreen(
                                    onNavigateTab = { viewModel.selectTab(it) },
                                    onOpenArticle = { viewModel.openArticle(it) },
                                    onOpenReservation = { viewModel.setReservationDialogOpen(true) },
                                    bookmarkedSlugs = uiState.bookmarkedSlugs,
                                    onToggleBookmark = { viewModel.toggleBookmark(it) }
                                )
                            }
                            tab == NavigationTab.BLOG -> {
                                BlogListScreen(
                                    searchQuery = uiState.searchQuery,
                                    onSearchChange = { viewModel.setSearchQuery(it) },
                                    selectedCategory = uiState.selectedCategory,
                                    onSelectCategory = { viewModel.setSelectedCategory(it) },
                                    bookmarkedSlugs = uiState.bookmarkedSlugs,
                                    onToggleBookmark = { viewModel.toggleBookmark(it) },
                                    onOpenArticle = { viewModel.openArticle(it) }
                                )
                            }
                            tab == NavigationTab.MENU -> {
                                MenuScreen(
                                    onAddItem = { viewModel.addCartItem() },
                                    onOpenReservation = { viewModel.setReservationDialogOpen(true) }
                                )
                            }
                            tab == NavigationTab.RESERVE -> {
                                HomeScreen(
                                    onNavigateTab = { viewModel.selectTab(it) },
                                    onOpenArticle = { viewModel.openArticle(it) },
                                    onOpenReservation = { viewModel.setReservationDialogOpen(true) },
                                    bookmarkedSlugs = uiState.bookmarkedSlugs,
                                    onToggleBookmark = { viewModel.toggleBookmark(it) }
                                )
                            }
                            tab == NavigationTab.ABOUT -> {
                                AboutScreen(
                                    onOpenReservation = { viewModel.setReservationDialogOpen(true) }
                                )
                            }
                        }
                    }
                }
            }
        }

        // SEO & Meta Rule Inspector Sheet
        if (uiState.showSeoInspector) {
            SeoInspectorSheet(
                metadata = uiState.currentMetadata,
                onDismiss = { viewModel.setSeoInspectorOpen(false) }
            )
        }

        // Table Reservation Dialog
        if (uiState.showReservationDialog) {
            ReservationDialog(
                onDismiss = { viewModel.setReservationDialogOpen(false) },
                onSubmit = { viewModel.submitReservation(it) }
            )
        }
    }
}
