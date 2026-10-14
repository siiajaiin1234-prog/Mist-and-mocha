package com.example.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.model.ReservationRequest
import com.example.ui.theme.CaramelAmber
import com.example.ui.theme.MochaPrimary

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ReservationDialog(
    onDismiss: () -> Unit,
    onSubmit: (ReservationRequest) -> Unit
) {
    var guestName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var partySize by remember { mutableIntStateOf(2) }
    var date by remember { mutableStateOf("Tomorrow, 10:30 AM") }
    var seatingArea by remember { mutableStateOf("Indoor Hearth Lounge") }
    var experienceType by remember { mutableStateOf("Barista Tasting Flight (3 Coffees)") }
    var notes by remember { mutableStateOf("") }

    val seatingOptions = listOf("Indoor Hearth Lounge", "Window Brew Bar", "Mist Garden Patio")
    val experienceOptions = listOf(
        "Regular Table Seating",
        "Barista Tasting Flight (3 Coffees)",
        "Pour-Over & Sourdough Pairing"
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = null,
                    tint = CaramelAmber,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Reserve Your Table",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Mist and Mocha Artisan Coffeehouse",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedTextField(
                    value = guestName,
                    onValueChange = { guestName = it },
                    label = { Text("Your Name") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().testTag("reservation_name_input")
                )

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        singleLine = true,
                        modifier = Modifier.weight(1f).testTag("reservation_email_input")
                    )
                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = { Text("Phone") },
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )
                }

                // Party Size Selection
                Column {
                    Text(
                        text = "Party Size: $partySize Guests",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        listOf(1, 2, 4, 6, 8).forEach { size ->
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = if (partySize == size) MochaPrimary else MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable { partySize = size }
                            ) {
                                Text(
                                    text = "$size",
                                    color = if (partySize == size) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                                )
                            }
                        }
                    }
                }

                // Seating Area
                Column {
                    Text(
                        text = "Seating Area:",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        seatingOptions.forEach { opt ->
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = if (seatingArea == opt) CaramelAmber else MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable { seatingArea = opt }
                            ) {
                                Text(
                                    text = opt,
                                    color = if (seatingArea == opt) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Medium),
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                )
                            }
                        }
                    }
                }

                // Experience Type
                Column {
                    Text(
                        text = "Tasting Experience:",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    experienceOptions.forEach { exp ->
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (experienceType == exp) MochaPrimary.copy(alpha = 0.12f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { experienceType = exp }
                                .padding(vertical = 2.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Coffee,
                                    contentDescription = null,
                                    tint = if (experienceType == exp) MochaPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = exp,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        fontWeight = if (experienceType == exp) FontWeight.Bold else FontWeight.Normal
                                    ),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }

                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Special Requests / Dietary Notes") },
                    singleLine = false,
                    maxLines = 3,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val finalName = if (guestName.isBlank()) "Guest of Mist & Mocha" else guestName
                    onSubmit(
                        ReservationRequest(
                            guestName = finalName,
                            email = email,
                            phone = phone,
                            partySize = partySize,
                            date = "Oct 15, 2026",
                            time = "10:30 AM",
                            seatingArea = seatingArea,
                            experienceType = experienceType,
                            notes = notes
                        )
                    )
                },
                colors = ButtonDefaults.buttonColors(containerColor = MochaPrimary),
                modifier = Modifier.testTag("confirm_reservation_button")
            ) {
                Text("Confirm Table Booking")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
