package automotive.car.ui.carmedia

import android.annotation.SuppressLint
import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import androidx.media3.session.legacy.MediaSessionCompat

@SuppressLint("RestrictedApi")
@OptIn(UnstableApi::class)
class DestinationMediaSessionCallback : MediaSessionCompat.Callback() {

    init {
        Log.d("GregoryCallback", "DestinationMediaSessionCallback")
    }

}