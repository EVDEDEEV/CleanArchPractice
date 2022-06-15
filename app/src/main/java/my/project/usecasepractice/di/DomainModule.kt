package my.project.usecasepractice.di

import my.project.usecasepractice.domain.useCases.GetUserNameUseCase
import my.project.usecasepractice.domain.useCases.SaveUserNameUseCase
import org.koin.dsl.module

//from MainViewModelFactory
//private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
//    GetUserNameUseCase(userRepository = userRepository)
//}
//private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
//    SaveUserNameUseCase(userRepository = userRepository)
//}

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}