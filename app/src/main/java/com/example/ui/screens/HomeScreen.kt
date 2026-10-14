package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.CafeDataRepository
import com.example.model.Article
import com.example.model.NavigationTab
import com.example.ui.theme.CaramelAmber
import com.example.ui.theme.DarkTextPrimary
import com.example.ui.theme.GoldCrema
import com.example.ui.theme.MistSage
import com.example.ui.theme.MochaDark
import com.example.ui.theme.MochaPrimary
import com.example.ui.theme.PlayfairFontFamily

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    onNavigateTab: (NavigationTab) -> Unit,
    onOpenArticle: (String) -> Unit,
    onOpenReservation: () -> Unit,
    bookmarkedSlugs: Set<String>,
    onToggleBookmark: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val featuredArticles = CafeDataRepository.articles.take(4)

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("home_screen_lazy_column"),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        // 1. HERO SECTION ABOVE THE FOLD WITH CALL TO ACTION BUTTONS
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("hero_section_above_the_fold")
            ) {
                // Background Hero Image (<100KB WebP)
                Image(
                    painter = painterResource(id = R.drawable.img_cafe_hero),
                    contentDescription = "Atmospheric interior of Mist and Mocha Cafe with slow coffee bar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp)
                )

                // Dark Gradient Scrim for crisp legibility
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.35f),
                                    Color.Black.copy(alpha = 0.75f),
                                    MochaDark.copy(alpha = 0.95f)
                                )
                            )
                        )
                )

                // Content Layer Above The Fold
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 24.dp)
                ) {
                    // Open Status & Speed Pill
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = MistSage.copy(alpha = 0.85f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    shape = CircleShape,
                                    color = Color(0xFF69F0AE),
                                    modifier = Modifier.size(7.dp)
                                ) {}
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "OPEN NOW • TILL 8:00 PM",
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 1.sp
                                    ),
                                    color = Color.White
                                )
                            }
                        }

                        // Image weight badge
                        Surface(
                            shape = CircleShape,
                            color = Color.Black.copy(alpha = 0.5f)
                        ) {
                            Text(
                                text = "81 KB • WebP",
                                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                                color = Color.White.copy(alpha = 0.8f),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(36.dp))

                    // Cafe Brand Name
                    Text(
                        text = "Mist and Mocha",
                        style = MaterialTheme.typography.displayLarge.copy(
                            fontFamily = PlayfairFontFamily,
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Artisan Specialty Coffeehouse, Handcrafted Espresso & Slow Roast Roastery",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Medium,
                            lineHeight = 22.sp
                        ),
                        color = Color(0xFFF3E7DC)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Single-origin coffees sourced from mist-covered mountain peaks, roasted in small cast-iron batches, and served with warmth.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.85f),
                        maxLines = 2
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // CLEAR CALL-TO-ACTION (CTA) BUTTONS ABOVE THE FOLD
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // PRIMARY CTA BUTTON: Reserve a Table
                        Button(
                            onClick = onOpenReservation,
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = CaramelAmber,
                                contentColor = MochaDark
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .testTag("hero_cta_reserve_table_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.CalendarMonth,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Reserve Table",
                                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                            )
                        }

                        // SECONDARY CTA: Explore Articles
                        FilledTonalButton(
                            onClick = { onNavigateTab(NavigationTab.BLOG) },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = Color.White.copy(alpha = 0.18f),
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .testTag("hero_cta_explore_journal_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.MenuBook,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Coffee Journal",
                                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                }
            }
        }

        // 2. QUICK HIGHLIGHTS / VALUE PROPOSITIONS
        item {
            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ValuePropItem(
                        icon = Icons.Default.Coffee,
                        title = "Cast-Iron Roast",
                        subtitle = "Micro-batch roasted"
                    )
                    ValuePropItem(
                        icon = Icons.Default.LocalCafe,
                        title = "94°C Slow Pour",
                        subtitle = "TDS calibrated water"
                    )
                    ValuePropItem(
                        icon = Icons.Default.Place,
                        title = "Mist Grown",
                        subtitle = "2,000m+ Terroir"
                    )
                }
            }
        }

        // 3. EDITORIAL SECTION: FEATURED ARTICLES FROM THE COFFEE JOURNAL
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "From Our Coffee Journal",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontFamily = PlayfairFontFamily,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "11+ in-depth brewing masterclasses & origin stories",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    OutlinedButton(
                        onClick = { onNavigateTab(NavigationTab.BLOG) },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.testTag("view_all_articles_button")
                    ) {
                        Text("View All")
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }
        }

        // Featured Articles List
        items(featuredArticles, key = { it.id }) { article ->
            ArticleFeaturedCard(
                article = article,
                isBookmarked = bookmarkedSlugs.contains(article.slug),
                onToggleBookmark = { onToggleBookmark(article.slug) },
                onClick = { onOpenArticle(article.slug) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            )
        }

        // 4. SIGNATURE BEVERAGE BANNER (LATTE ART WITH PHOTO <100KB)
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Column {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.img_latte_art),
                            contentDescription = "Handcrafted swan latte art mocha in ceramic mug",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(190.dp)
                        )
                        Surface(
                            shape = CircleShape,
                            color = Color.Black.copy(alpha = 0.6f),
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(12.dp)
                        ) {
                            Text(
                                text = "84 KB • WebP",
                                style = MaterialTheme.typography.labelSmall.copy(fontSize = 9.sp),
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }

                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Mist Signature Cardamom Mocha",
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = "$6.75",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = CaramelAmber
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Single-origin espresso paired with 70% dark Valrhona cocoa ganache, crushed green cardamom mist, and micro-steamed velvet oat milk.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(14.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(
                                onClick = { onNavigateTab(NavigationTab.MENU) },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = MochaPrimary)
                            ) {
                                Icon(Icons.Default.RestaurantMenu, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Explore Cafe Menu")
                            }
                        }
                    }
                }
            }
        }

        // 5. CAFE LOCATION, HOURS & VISIT INFO
        item {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Visit Mist & Mocha",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "42 Highland Mist Boulevard, Pinecrest Valley\nMon - Sun: 7:00 AM – 8:00 PM\nComplimentary Wi-Fi • Sourdough Bakery • Roastery Cupping Bar",
                        style = MaterialTheme.typography.bodyMedium,
                        lineHeight = 22.sp
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Button(
                        onClick = onOpenReservation,
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MochaPrimary)
                    ) {
                        Text("Book Your Visit")
                    }
                }
            }
        }
    }
}

@Composable
fun ArticleFeaturedCard(
    article: Article,
    isBookmarked: Boolean,
    onToggleBookmark: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .testTag("article_card_${article.slug}")
    ) {
        Column {
            // Header Image with Image size badge
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                Image(
                    painter = painterResource(id = article.localDrawableRes ?: R.drawable.img_latte_art),
                    contentDescription = article.imageAlt,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Image Weight Badge (< 100 KB guaranteed)
                Surface(
                    shape = CircleShape,
                    color = Color.Black.copy(alpha = 0.65f),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                ) {
                    Text(
                        text = "${article.imageSizeKb} KB • WebP",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 9.sp),
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

                // Category pill
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MochaPrimary.copy(alpha = 0.85f),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(10.dp)
                ) {
                    Text(
                        text = article.category,
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            Column(modifier = Modifier.padding(14.dp)) {
                // Title
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontFamily = PlayfairFontFamily,
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Keyword chips: 1 main keyword + 2 related keywords
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = CaramelAmber.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = "Key: ${article.mainKeyword}",
                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                            color = CaramelAmber,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }

                    article.relatedKeywords.take(2).forEach { kw ->
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = MistSage.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = kw,
                                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                                color = MistSage,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Excerpt
                Text(
                    text = article.excerpt,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Footer metadata & Q&A Indicator
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.AccessTime,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(13.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${article.readingTimeMinutes} min read",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        // Q&A badge indicator
                        Surface(
                            shape = CircleShape,
                            color = MistSage.copy(alpha = 0.12f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.QuestionAnswer,
                                    contentDescription = null,
                                    tint = MistSage,
                                    modifier = Modifier.size(11.dp)
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = "Q&A Format",
                                    style = MaterialTheme.typography.labelSmall.copy(fontSize = 9.sp),
                                    color = MistSage
                                )
                            }
                        }
                    }

                    IconButton(
                        onClick = onToggleBookmark,
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = "Bookmark",
                            tint = if (isBookmarked) CaramelAmber else MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ValuePropItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            shape = CircleShape,
            color = MochaPrimary.copy(alpha = 0.1f),
            modifier = Modifier.size(38.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MochaPrimary,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
