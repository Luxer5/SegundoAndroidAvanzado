import com.example.segundoandroidavanzado.data.dto.HeroDTO
import com.example.segundoandroidavanzado.data.local.model.HeroLocal
import com.example.segundoandroidavanzado.domain.model.HeroModel

fun HeroDTO.toHeroModel() = HeroModel(
    name = name?: "",
    photoUrl = photo?: "",
    id = id?:"",
    description = description?:""
)

fun HeroDTO.toHeroLocal() = HeroLocal(
    id = id?: "",
    name = name?: "",
    photoUrl = photo?: "",
    favorite = favorite?: false,
    description = description?: ""
)

fun HeroLocal.toHeroModel() = HeroModel(
    name = name,
    photoUrl = photoUrl,
    id = id,
    description = description
)