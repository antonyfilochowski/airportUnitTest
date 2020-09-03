import hftest.Totaller
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotallerTest {
    @Test
    fun shouldBeAbleToAdd3and4(){
        val totaller = Totaller()
        assertEquals(3, totaller.add(3))
        assertEquals(7, totaller.add(4))
        assertEquals(7, totaller.total)
    }
}
