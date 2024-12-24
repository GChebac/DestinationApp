package automotive.car.ui.navigation.screen.template.examples

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*
import androidx.core.graphics.drawable.IconCompat
import automotive.car.ui.car.navigation.R
import automotive.car.ui.data.data.Destinations
import automotive.car.ui.data.data.model.Destination
import automotive.car.ui.data.data.model.toIntent

class DestinationPaneTemplate(
    carContext: CarContext,
    private val destinationId: Int,
    private val destinations: Destinations = Destinations()
) : Screen(carContext) {

    override fun onGetTemplate(): Template {
        val destination = destinations.getDestination(destinationId)
            ?: return createPlaceNotFoundMessageTemplate()

        val navigationAction = createNavigationAction(destination)

        val actionStrip = createActionStrip()

        return PaneTemplate.Builder(
            Pane.Builder()
                .addAction(navigationAction)
                .addRow(createCoordinatesRow(destination))
                .addRow(createDescriptionRow(destination))
                .build()
        )
            .setTitle(destination.name)
            .setHeaderAction(Action.BACK)
            .setActionStrip(actionStrip)
            .build()
    }

    private fun createPlaceNotFoundMessageTemplate(): Template {
        return MessageTemplate.Builder("Place not found")
            .setHeaderAction(Action.BACK)
            .build()
    }

    private fun createNavigationAction(destination: Destination): Action {
        return Action.Builder()
            .setTitle("Navigate")
            .setIcon(createNavigationIcon())
            .setOnClickListener { carContext.startCarApp(destination.toIntent(CarContext.ACTION_NAVIGATE)) }
            .build()
    }

    private fun createNavigationIcon(): CarIcon {
        return CarIcon.Builder(
            IconCompat.createWithResource(carContext, R.drawable.baseline_navigation_24)
        ).build()
    }

    private fun createActionStrip(): ActionStrip {
        return ActionStrip.Builder()
            .addAction(Action.Builder().setTitle("Action").build())
            .build()
    }

    private fun createCoordinatesRow(destination: Destination): Row {
        return Row.Builder()
            .setTitle("Coordinates")
            .addText("${destination.latitude}, ${destination.longitude}")
            .build()
    }

    private fun createDescriptionRow(destination: Destination): Row {
        return Row.Builder()
            .setTitle("Description")
            .addText(destination.description)
            .build()
    }
}
