package my.project.usecasepractice.domain.useCases

import my.project.usecasepractice.domain.models.UserName
import my.project.usecasepractice.domain.repository.UserRepository
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor(val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}

//No Di Version
//class GetUserNameUseCase(private val userRepository: UserRepository) {
//
//
//
//    fun execute(): UserName {
//
//
//        return userRepository.getName()
//    }
//}