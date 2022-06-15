package my.project.usecasepractice.di

import android.content.Context
import dagger.Module
import dagger.Provides
import my.project.usecasepractice.data.repository.UserRepositoryImpl
import my.project.usecasepractice.data.storage.UserStorage
import my.project.usecasepractice.data.storage.sharedprefs.SharedPrefUserStorage
import my.project.usecasepractice.domain.repository.UserRepository

//from MainViewModelFactory
//private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
//    UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
//}

//Dagger
@Module
class DataModule {

    //Предоставляется Storage и User Repository из Data модуля

    @Provides
    //Предоставляется userStorage интерфейс из app модуля
    fun provideUserStorage(context: Context): UserStorage {
        //Возвращается реализация методов, которые есть в UserStorage.
        //То есть возвращается нужная нам реализация этого интерфейса
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    //Предоставляется UserRepository интерфейс из Data модуля
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        //То есть возвращается нужная нам реализация этого интерфейса
        //возвращается реализация методов, которые есть в UserRepository
        return UserRepositoryImpl(userStorage = userStorage)
    }
}

//Koin
//val dataModule = module {
//
//    single<UserStorage> {
//        SharedPrefUserStorage(context = get())
//    }
//
//    single<UserRepository> {
//        UserRepositoryImpl(userStorage = get())
//    }
//}