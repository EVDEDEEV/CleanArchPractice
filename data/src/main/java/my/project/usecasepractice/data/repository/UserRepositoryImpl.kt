package my.project.usecasepractice.data.repository

import my.project.usecasepractice.data.storage.models.User
import my.project.usecasepractice.data.storage.UserStorage
import my.project.usecasepractice.domain.models.SaveUserNameParam
import my.project.usecasepractice.domain.models.UserName
import my.project.usecasepractice.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}