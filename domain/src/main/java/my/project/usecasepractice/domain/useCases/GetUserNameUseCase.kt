package my.project.usecasepractice.domain.useCases

import my.project.usecasepractice.domain.models.UserName
import my.project.usecasepractice.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {



    fun execute(): UserName {


        return userRepository.getName()
    }
}