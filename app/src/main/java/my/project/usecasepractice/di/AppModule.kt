package my.project.usecasepractice.di

import android.content.Context
import dagger.Module
import dagger.Provides
import my.project.usecasepractice.domain.useCases.GetUserNameUseCase
import my.project.usecasepractice.domain.useCases.SaveUserNameUseCase
import my.project.usecasepractice.presentation.MainViewModelFactory

@Module
class AppModule(val context: Context) {

    //Представляется Context
    @Provides
    fun provideContext(): Context {
        return context
    }

    //Предоставляется фабрика
//    @Provides
//    fun provideMainViewModelFactory(
//        getUserNameUseCase: GetUserNameUseCase,
//        saveUserNameUseCase: SaveUserNameUseCase,
//    ): MainViewModelFactory {
//        return MainViewModelFactory(getUserNameUseCase = getUserNameUseCase,
//            saveUserNameUseCase = saveUserNameUseCase)
//    }
}


//Koin
//val appModule = module {
//
//    viewModel<MainViewModel>() {
//        MainViewModel(
//            getUserNameUseCase = get(),
//            saveUserNameUseCase = get()
//        )
//    }
//}