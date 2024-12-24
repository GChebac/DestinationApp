package automotive.car.ui.navigation.screen.template.exampls


import android.text.Spannable
import android.text.SpannableString
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.CarLocation
import androidx.car.app.model.Distance
import androidx.car.app.model.DistanceSpan
import androidx.car.app.model.ItemList
import androidx.car.app.model.Metadata
import androidx.car.app.model.Place
import androidx.car.app.model.PlaceListMapTemplate
import androidx.car.app.model.PlaceMarker
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import automotive.car.ui.data.data.Destinations
import automotive.car.ui.data.data.model.Destination
import automotive.car.ui.navigation.screen.template.examples.DestinationPaneTemplate

class DestinationPlaceListMapTemplate(carContext: CarContext) : Screen(carContext) {

    private val destinations = Destinations()

    override fun onGetTemplate(): Template {
        val itemList = createItemList(destinations)

        return PlaceListMapTemplate.Builder().setTitle("Destinations").setItemList(itemList).build()
    }

    private fun createItemList(destinations: Destinations): ItemList {
        val itemListBuilder = ItemList.Builder().setNoItemsMessage("No destinations to show")

        destinations.getDestinations().forEach { destination ->
            itemListBuilder.addItem(createRowForDestination(destination))
        }

        return itemListBuilder.build()
    }

    private fun createRowForDestination(destination: Destination): Row {
        return Row.Builder().setTitle(destination.name).addText(createDistanceSpanText())
            .setOnClickListener {
                screenManager.push(DestinationPaneTemplate(carContext, destination.id))
            }.setMetadata(createMetadataForDestination(destination)).build()
    }

    private fun createDistanceSpanText(): SpannableString {
        return SpannableString(" ").apply {
            setSpan(
                DistanceSpan.create(
                    Distance.create((Math.random() * 100.0), Distance.UNIT_KILOMETERS)
                ), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
        }
    }

    private fun createMetadataForDestination(destination: Destination): Metadata {
        return Metadata.Builder().setPlace(
                Place.Builder(CarLocation.create(destination.latitude, destination.longitude))
                    .setMarker(PlaceMarker.Builder().build()) //A destination marker representing the exact location of the place on the map
                    .build()
            ).build()
    }

}
