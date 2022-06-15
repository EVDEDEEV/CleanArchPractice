package my.project.usecasepractice.data.storage

import my.project.usecasepractice.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}