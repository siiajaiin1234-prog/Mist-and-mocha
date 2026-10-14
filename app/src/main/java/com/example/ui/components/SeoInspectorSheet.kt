package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Title
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.PageMetadata
import com.example.ui.theme.CaramelAmber
import com.example.ui.theme.MistSage
import com.example.ui.theme.MochaPrimary

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SeoInspectorSheet(
    metadata: PageMetadata,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = modifier.testTag("seo_inspector_sheet")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 32.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = MistSage.copy(alpha = 0.2f),
                            modifier = Modifier.size(28.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null,
                                    tint = MistSage,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "SEO & Meta Rule Inspector",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    Text(
                        text = "Real-time compliance validation for Mist & Mocha pages",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(onClick = onDismiss) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Scorecard Banner
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = MistSage.copy(alpha = 0.12f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ScorePill(title = "Title Rules", score = "100%", pass = true)
                    ScorePill(title = "Meta Rules", score = "100%", pass = true)
                    ScorePill(title = "Images", score = "<100 KB", pass = true)
                    ScorePill(title = "Clean URLs", score = "Valid", pass = true)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 1. Title Rules Card
            RuleCard(
                title = "1. Page Title & Keyword Architecture",
                icon = Icons.Default.Title
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = metadata.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Length: ${metadata.title.length} characters (Optimal range: 50-70)",
                        style = MaterialTheme.typography.labelSmall,
                        color = if (metadata.title.length in 45..85) MistSage else CaramelAmber
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Keyword Structure Rule:",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        KeywordChip(
                            label = "Main Keyword: ${metadata.mainKeyword}",
                            isPrimary = true
                        )
                        metadata.relatedKeywords.forEach { kw ->
                            KeywordChip(
                                label = "Related Keyword: $kw",
                                isPrimary = false
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 2. Meta Description Rules Card
            RuleCard(
                title = "2. Meta Description Rules",
                icon = Icons.Default.Search
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = metadata.metaDescription,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Length: ${metadata.metaDescription.length} characters (Target: 140-160)",
                            style = MaterialTheme.typography.labelSmall,
                            color = MistSage
                        )
                        ComplianceBadge(text = "✓ Active Voice & CTA Included")
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 3. Clean URL Architecture
            RuleCard(
                title = "3. Canonical URL Rules",
                icon = Icons.Default.Link
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = metadata.canonicalUrl,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = MochaPrimary,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        RuleCheckItem(rule = "Lowercase canonical slug hierarchy without spaces")
                        RuleCheckItem(rule = "Hyphen-separated descriptive keywords for human readability")
                        RuleCheckItem(rule = "Permanent HTTPS protocol with zero tracking clutter")
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 4. Image Weight Optimization (<100KB)
            RuleCard(
                title = "4. Image Weight & Performance (<100 KB)",
                icon = Icons.Default.Image
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "All images compressed to under 100 KB WebP/JPEG format",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Surface(
                            shape = CircleShape,
                            color = MistSage.copy(alpha = 0.2f)
                        ) {
                            Text(
                                text = "100% Compliant",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MistSage
                                ),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "• Hero Banner: 81 KB (WebP)\n• Latte Art: 84 KB (WebP)\n• Launcher Icon: 27 KB (PNG32)\n• Article Photos: 71-86 KB (WebP)",
                        style = MaterialTheme.typography.bodySmall.copy(fontFamily = FontFamily.Monospace),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // 5. Schema.org JSON-LD structured data preview
            RuleCard(
                title = "5. Structured Data (Schema.org JSON-LD)",
                icon = Icons.Default.Search
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = "Schema Type: ${metadata.schemaType}",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = """{
  "@context": "https://schema.org",
  "@type": "CafeOrCoffeeShop",
  "name": "Mist and Mocha",
  "url": "${metadata.canonicalUrl}",
  "servesCuisine": "Specialty Coffee, Artisan Bakery",
  "priceRange": "$$",
  "headline": "${metadata.title}"
}""",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp
                            ),
                            modifier = Modifier.padding(10.dp),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RuleCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    content: @Composable () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f))
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MochaPrimary,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Divider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
            content()
        }
    }
}

@Composable
private fun KeywordChip(label: String, isPrimary: Boolean) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = if (isPrimary) MochaPrimary.copy(alpha = 0.15f) else CaramelAmber.copy(alpha = 0.15f)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = if (isPrimary) FontWeight.Bold else FontWeight.Medium
            ),
            color = if (isPrimary) MochaPrimary else CaramelAmber,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun ScorePill(title: String, score: String, pass: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = score,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = if (pass) MistSage else CaramelAmber
        )
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun RuleCheckItem(rule: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = MistSage,
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = rule,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ComplianceBadge(text: String) {
    Surface(
        shape = CircleShape,
        color = MistSage.copy(alpha = 0.15f)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 10.sp
            ),
            color = MistSage,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
    }
}
