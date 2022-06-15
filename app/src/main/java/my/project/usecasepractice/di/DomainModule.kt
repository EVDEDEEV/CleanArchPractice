package my.project.usecasepractice.di

import dagger.Module
import dagger.Provides
import my.project.usecasepractice.domain.repository.UserRepository
import my.project.usecasepractice.domain.useCases.GetUserNameUseCase
import my.project.usecasepractice.domain.useCases.SaveUserNameUseCase

//from MainViewModelFactory
//private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
//    GetUserNameUseCase(userRepository = userRepository)
//}
//private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
//    SaveUserNameUseCase(userRepository = userRepository)
//}

//Dagger
@Module
class DomainModule {

    ////Предоставляется Use Case'ы из Domain модуля
//    @Provides
//    fun provideGetNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
//        //То есть возвращается нужная нам реализация этого интерфейса
//        return GetUserNameUseCase(userRepository = userRepository)
//    }
//
//    @Provides
//    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
//        //То есть возвращается нужная нам реализация этого интерфейса
//        return SaveUserNameUseCase(userRepository = userRepository)
//    }

}


//Koin
//val domainModule = module {
//
//    factory<GetUserNameUseCase> {
//        GetUserNameUseCase(userRepository = get())
//    }
//
//    factory<SaveUserNameUseCase> {
//        SaveUserNameUseCase(userRepository = get())
//    }
//}