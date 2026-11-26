package com.example.parcial.views.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.data.models.TripModel
import com.example.parcial.viewmodels.TripViewModel

@Composable
fun HomeScreen(
    trips: List<TripModel?>,
    onClickAdd: () -> Unit,
    onClickAbout: (id: String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F172A))
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(R.string.title_home),
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = stringResource(R.string.subtitle_home),
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 15.sp
                )
            }
            Column(

            ) {
                for (trip in trips) {
                    if (trip != null) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White.copy(alpha = 0.08f)
                            ),
                            shape = RoundedCornerShape(24.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(24.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = trip.nameTrip,
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = trip.destination,
                                        color = Color.White.copy(alpha = 0.6f),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                Spacer(modifier = Modifier.height(12.dp))

                                Button(
                                    onClick = {onClickAbout(trip.id)},
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF00AEFF),
                                        disabledContainerColor = Color(0xFF00AEFF).copy(alpha = 0.3f)
                                    )
                                ) {
                                    Text(
                                        text = stringResource(R.string.detail_button_home),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }


                        }

                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = onClickAdd,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .shadow(8.dp, RoundedCornerShape(18.dp)),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF00AEFF)
                    )
                ) {
                    Text(
                        text = stringResource(R.string.add_button_home),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Text(
                text = "Components 301 • 2026 • Parcial 2",
                color = Color.White.copy(alpha = 0.5f),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val tripsEjemplo = listOf(
        TripModel(
            id = "1",
            nameTrip = "Loquenderos de Corazon",
            destination = "Loquendo City",
            startDate = "Hoy",
            endDate = "Ayer",
            createdAt = "Mañana"
        ),
        TripModel(
            id = "2",
            nameTrip = "La tierra de los papus",
            destination = "Papulandia",
            startDate = "Yo no se Mañana",
            endDate = "Si estaremos juntos",
            createdAt = "Si se acaba el mundo"
        )
    )
    HomeScreen(trips = tripsEjemplo, onClickAdd = {}, onClickAbout = {id->"123"})
}