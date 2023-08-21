package com.example.weatherapp.utils

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.weatherapp.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun LoadFromUrl(url: Any, width: Dp, height: Dp) = AsyncImage(
    model = ImageRequest.Builder(LocalContext.current)
        .data(url)
        .crossfade(true)
        .build(),
    contentDescription = "@null",
    placeholder = painterResource(id = R.drawable.frog_placeholder),
    contentScale = ContentScale.FillBounds,
    filterQuality = FilterQuality.None,
    modifier = Modifier
        .width(width = width)
        .height(height = height)
)


fun formatDate(dateSt: String): String = DateTimeFormatter.ofPattern("MMMM dd, hh:mma")
    .format(
        LocalDateTime.parse(
            dateSt,
            DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm"
            )
        )
    )

fun formatDateHH(dateSt: String): String = DateTimeFormatter.ofPattern("hh")
    .format(
        LocalDateTime.parse(
            dateSt,
            DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm"
            )
        )
    )

fun checkDirection(direction: String): Int {
    return when (direction) {
        "NWN", "WNW", "NW" -> R.drawable.arrow_up_left
        "NNE", "ENE", "NE" -> R.drawable.arrow_up_right
        "WSW", "SW", "SSW" -> R.drawable.arrow_down_left
        "SSE", "SE", "ESE" -> R.drawable.arrow_down_right
        "W" -> R.drawable.arrow_sm_left
        "N" -> R.drawable.arrow_sm_up
        "S" -> R.drawable.arrow_sm_down
        "E"-> R.drawable.arrow_sm_right
        else -> {R.drawable.frog_placeholder}
    }
}

