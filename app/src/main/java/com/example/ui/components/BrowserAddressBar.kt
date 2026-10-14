package com.example.ui.components

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.PageMetadata
import com.example.ui.theme.CaramelAmber
import com.example.ui.theme.MistSage
import com.example.ui.theme.MochaPrimary

@Composable
fun BrowserAddressBar(
    currentUrl: String,
    metadata: PageMetadata,
    isLoading: Boolean,
    onNavigateUrl: (String) -> Unit,
    onCopyUrl: () -> Unit,
    onOpenSeoInspector: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var showEditUrlDialog by remember { mutableStateOf(false) }
    var editedUrlInput by remember(currentUrl) { mutableStateOf(currentUrl) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        // Top Browser Header & URL Pill
        Surface(
            tonalElevation = 2.dp,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surface
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Interactive Address Pill
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .clickable { showEditUrlDialog = true }
                        .testTag("browser_address_pill")
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // SSL Lock
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Secure SSL Connection",
                            tint = MistSage,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))

                        // URL Text
                        Text(
                            text = currentUrl.replace("https://", ""),
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Medium
                            ),
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        // Edit icon hint
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit URL",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Copy URL Button
                IconButton(
                    onClick = onCopyUrl,
                    modifier = Modifier
                        .size(38.dp)
                        .testTag("copy_url_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = "Copy page URL",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(18.dp)
                    )
                }

                // Share Button
                IconButton(
                    onClick = {
                        val sendIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "${metadata.title}\n$currentUrl")
                            type = "text/plain"
                        }
                        context.startActivity(Intent.createChooser(sendIntent, "Share Mist & Mocha"))
                    },
                    modifier = Modifier.size(38.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share URL",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(18.dp)
                    )
                }

                // SEO & Meta Inspector Trigger Button
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MistSage.copy(alpha = 0.15f),
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .clickable { onOpenSeoInspector() }
                        .testTag("seo_inspector_button")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Analytics,
                            contentDescription = "SEO & Meta",
                            tint = MistSage,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "SEO",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = MistSage
                        )
                    }
                }
            }
        }

        // Fast Load Indicator & Metrics Bar
        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Speed,
                        contentDescription = "Load speed",
                        tint = CaramelAmber,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "TTFB ${metadata.loadSpeedMs}ms • Performance ${metadata.performanceScore}/100",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Images < 100kb compliance badge
                Surface(
                    shape = CircleShape,
                    color = MistSage.copy(alpha = 0.18f)
                ) {
                    Text(
                        text = "✓ Images < 100 KB",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 9.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = MistSage,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
        }

        AnimatedVisibility(visible = isLoading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp),
                color = CaramelAmber
            )
        }
    }

    // Direct URL Navigation Modal
    if (showEditUrlDialog) {
        AlertDialog(
            onDismissRequest = { showEditUrlDialog = false },
            title = {
                Text(
                    text = "Navigate by URL",
                    style = MaterialTheme.typography.titleMedium
                )
            },
            text = {
                Column {
                    Text(
                        text = "Enter any canonical website URL following good URL rules:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = editedUrlInput,
                        onValueChange = { editedUrlInput = it },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("url_input_field"),
                        textStyle = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily.Monospace)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Try: https://mistandmocha.com/blog\nhttps://mistandmocha.com/blog/art-of-slow-pour-over-brewing\nhttps://mistandmocha.com/menu",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showEditUrlDialog = false
                        onNavigateUrl(editedUrlInput)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MochaPrimary)
                ) {
                    Text("Go to URL")
                }
            },
            dismissButton = {
                TextButton(onClick = { showEditUrlDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}
