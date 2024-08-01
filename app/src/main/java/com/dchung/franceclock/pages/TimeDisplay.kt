package com.dchung.franceclock.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dchung.franceclock.viewmodels.TimeViewModel
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun TimeDisplay (timeViewModel: TimeViewModel, paddingValues: PaddingValues) {

    val localTime: String by timeViewModel.localTime.observeAsState("Loading...")
    val easternTime: String by timeViewModel.easternTime.observeAsState("Loading...")
    val centralTime: String by timeViewModel.centralTime.observeAsState("Loading...")
    val pacificTime: String by timeViewModel.pacificTime.observeAsState("Loading...")

    LaunchedEffect(Unit) {
        while (true) {
            // Call the function you want to run every minute
            timeViewModel.updateTimes()

            // Delay for 1 minute (60,000 milliseconds)
            kotlinx.coroutines.delay(60000)
        }
    }

    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        Time(location = "Local", time = localTime)
        Time(location = "US Eastern", time = easternTime)
        Time(location = "US Central", time = centralTime)
        Time(location = "US Pacific", time = pacificTime)
    }
}

@Composable
fun Time( location :String, time :String ) {
    Row(
        modifier = Modifier.padding(PaddingValues(16.dp))
    ){
        Text(
            modifier = Modifier.width(140.dp),
            text = location,
            fontSize = 24.sp)
        Text(text = time,
            fontSize = 24.sp)

    }
}