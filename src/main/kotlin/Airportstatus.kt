import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

suspend fun getAirportStatus(airportCodes: List<String>): List<Airport> =
    withContext(Dispatchers.IO) {
        Airport.sort(
            airportCodes.map { code -> async { Airport.getAirportData(code) } }
                .map { response -> response.await() })
    }
