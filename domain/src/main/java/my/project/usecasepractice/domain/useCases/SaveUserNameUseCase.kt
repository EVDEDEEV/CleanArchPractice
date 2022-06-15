package my.project.usecasepractice.domain.useCases

import my.project.usecasepractice.domain.models.SaveUserNameParam
import my.project.usecasepractice.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true
        }

        return userRepository.saveName(saveParam = param)
    }
}