package my.project.usecasepractice.di

import my.project.usecasepractice.data.repository.UserRepositoryImpl
import my.project.usecasepractice.data.storage.UserStorage
import my.project.usecasepractice.data.storage.sharedprefs.SharedPrefUserStorage
import my.project.usecasepractice.domain.repository.UserRepository
import org.koin.dsl.module

//from MainViewModelFactory
//private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
//    UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
//}

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }





}