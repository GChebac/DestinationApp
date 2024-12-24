package automotive.car.ui.data.data

import automotive.car.ui.data.data.model.Destination

class Destinations {

    fun getDestinations(): List<Destination> {
        return DESTINATIONS
    }

    fun getDestination(destinationId: Int): Destination? {
        return DESTINATIONS.find { it.id == destinationId }
    }

}

private val DESTINATIONS = listOf(
    Destination(
        1,
        "Statue of Liberty",
        "The Statue of Liberty is a colossal neoclassical sculpture on Liberty Island in New York Harbor. It was a gift from the people of France and has become a global symbol of freedom and democracy.",
        40.6892,
        -74.0445
    ),
    Destination(
        2,
        "Eiffel Tower",
        "The Eiffel Tower is a wrought-iron lattice tower on the Champ de Mars in Paris, France. It is one of the most recognizable structures in the world and a global cultural icon of France.",
        48.8584,
        2.2945
    ),
    Destination(
        3,
        "Great Wall of China",
        "The Great Wall of China is a series of fortifications made of stone, brick, tamped earth, wood, and other materials, built along the historical northern borders of China to protect against various nomadic groups.",
        40.4319,
        116.5704
    ),
    Destination(
        4,
        "Machu Picchu",
        "Machu Picchu is a 15th-century Inca citadel located in the Eastern Cordillera of southern Peru. It is one of the most iconic archaeological sites in the world and a symbol of the Inca civilization.",
        -13.1631,
        -72.5450
    ),
    Destination(
        5,
        "Sydney Opera House",
        "The Sydney Opera House is a multi-venue performing arts centre in Sydney, Australia. It is one of the 20th century's most famous and distinctive buildings, and a UNESCO World Heritage Site.",
        -33.8568,
        151.2153
    ),
    Destination(
        6,
        "Taj Mahal",
        "The Taj Mahal is an ivory-white marble mausoleum on the south bank of the Yamuna river in the Indian city of Agra. It was commissioned in 1632 by the Mughal emperor Shah Jahan to house the tomb of his favorite wife, Mumtaz Mahal.",
        27.1751,
        78.0421
    ),
    Destination(
        7,
        "Mount Everest",
        "Mount Everest is Earth's highest mountain above sea level, located in the Mahalangur Himal sub-range of the Himalayas. The China–Nepal border runs across its summit point.",
        27.9881,
        86.9250
    )
)
