package my.project.usecasepractice.domain.repository

import my.project.usecasepractice.domain.models.SaveUserNameParam
import my.project.usecasepractice.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam) : Boolean

    fun getName(): UserName

}