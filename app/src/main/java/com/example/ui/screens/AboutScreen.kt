package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Nature
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.theme.CaramelAmber
import com.example.ui.theme.MistSage
import com.example.ui.theme.MochaPrimary
import com.example.ui.theme.PlayfairFontFamily

@Composable
fun AboutScreen(
    onOpenReservation: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("about_screen"),
        contentPadding = PaddingValues(bottom = 90.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_cafe_hero),
                    contentDescription = "Mist & Mocha roastery drum and hearth",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Surface(
                    shape = CircleShape,
                    color = Color.Black.copy(alpha = 0.6f),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(10.dp)
                ) {
                    Text(
                        text = "81 KB • WebP",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 9.sp),
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
            ) {
                Text(
                    text = "The Mist and Mocha Story",
                    style = MaterialTheme.typography.displaySmall.copy(
                        fontFamily = PlayfairFontFamily
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Born in the mountain mist where Arabica coffee trees thrive, our roastery honors the slow, intentional alchemy of green seed to aromatic cup.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 26.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                AboutPillarCard(
                    icon = Icons.Default.Nature,
                    title = "Highland Mist Terroir",
                    description = "We source direct-trade coffee exclusively from high-altitude farms (1,800m to 2,200m) where morning fog cools cherry maturation, condensing natural fruit sugars and florals."
                )

                Spacer(modifier = Modifier.height(12.dp))

                AboutPillarCard(
                    icon = Icons.Default.Coffee,
                    title = "Cast-Iron Drum Roasting",
                    description = "Our small-batch vintage cast-iron roaster allows thermal conductivity that develops deep caramelized sweetness while preserving delicate origin acids."
                )

                Spacer(modifier = Modifier.height(12.dp))

                AboutPillarCard(
                    icon = Icons.Default.WaterDrop,
                    title = "Precision Water Alchemy",
                    description = "Every brew at Mist & Mocha is extracted with remineralized Reverse Osmosis water calibrated to 130 ppm TDS, balanced with food-grade magnesium and bicarbonate ions."
                )

                Spacer(modifier = Modifier.height(24.dp))

                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text(
                            text = "Meet Our Coffee Team",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "• Elena Vance — Head Roaster & Certified Q-Grader\n• Marcus Thorne — Green Coffee Sourcing & Farm Relations\n• Chloe Lin — Lead Barista & Champion Latte Artist\n• Julian Ramos — Artisan Sourdough Baker",
                            style = MaterialTheme.typography.bodyMedium,
                            lineHeight = 24.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = onOpenReservation,
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = MochaPrimary)
                        ) {
                            Icon(Icons.Default.CalendarMonth, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Book a Roastery Tasting Table")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AboutPillarCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Surface(
                shape = CircleShape,
                color = MochaPrimary.copy(alpha = 0.12f),
                modifier = Modifier.size(40.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(imageVector = icon, contentDescription = null, tint = MochaPrimary, modifier = Modifier.size(20.dp))
                }
            }
            Spacer(modifier = Modifier.width(14.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 20.sp
                )
            }
        }
    }
}
