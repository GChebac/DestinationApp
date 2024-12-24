package automotive.car.ui.data.data.model

import android.content.Intent
import androidx.core.net.toUri

data class Destination(
    val id: Int,
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double
)

fun Destination.toIntent(action: String): Intent {
    return Intent(action).apply {
        data = "geo:$latitude,$longitude".toUri()
    }
}
