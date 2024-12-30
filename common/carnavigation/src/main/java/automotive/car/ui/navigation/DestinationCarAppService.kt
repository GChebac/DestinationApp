package automotive.car.ui.navigation

import android.content.Intent
import androidx.car.app.CarAppService
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator
import automotive.car.ui.navigation.screen.template.examples.DestinationPaneTemplate
import automotive.car.ui.navigation.screen.template.exampls.DestinationPlaceListMapTemplate
import automotive.car.ui.navigation.screen.template.exampls.DestinationSignInTemplate

class DestinationCarAppService : CarAppService() {
    override fun createHostValidator(): HostValidator {
        return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
    }

    override fun onCreateSession(): Session {
        return DestinationSession()
    }
}

class DestinationSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return DestinationPlaceListMapTemplate(carContext)
    }
}