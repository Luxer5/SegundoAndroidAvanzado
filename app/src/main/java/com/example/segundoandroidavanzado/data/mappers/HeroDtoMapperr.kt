import com.example.segundoandroidavanzado.data.dto.HeroDTO
import com.example.segundoandroidavanzado.data.local.model.HeroLocal
import com.example.segundoandroidavanzado.domain.model.HeroModel

fun HeroDTO.toHeroModel() = HeroModel(
    name = name?: "",
    photoUrl = photo?: "",
    id = id?:""
)

fun HeroDTO.toHeroLocal() = HeroLocal(
    id = id?: "",
    name = name?: "",
    photoUrl = photo?: "",
    favorite = favorite?: false
)

fun HeroLocal.toHeroModel() = HeroModel(
    name = name,
    photoUrl = photoUrl,
    id = id
)