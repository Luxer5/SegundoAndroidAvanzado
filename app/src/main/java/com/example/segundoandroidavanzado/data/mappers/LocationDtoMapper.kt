import android.os.Build
import androidx.annotation.RequiresApi
import com.example.segundoandroidavanzado.domain.model.LocationModel
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
fun LocationDto.toLocationModel() = LocationModel(
    date = dateShow?: "" ,
    latitud = latitud!!.toDouble(),
    longitud = longitud!!.toDouble()
)