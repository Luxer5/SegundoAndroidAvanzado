import com.example.segundoandroidavanzado.data.dto.HeroDTO
import com.example.segundoandroidavanzado.domain.model.HeroModel

fun HeroDTO.toHeroModel() = HeroModel(
    name = name?: "",
    photoUrl = photo?: ""
)