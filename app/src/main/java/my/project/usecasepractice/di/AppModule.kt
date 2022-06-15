package my.project.usecasepractice.di

import android.content.Context
import dagger.Module
import dagger.Provides
import my.project.usecasepractice.domain.useCases.GetUserNameUseCase
import my.project.usecasepractice.domain.useCases.SaveUserNameUseCase
import my.project.usecasepractice.presentation.MainViewModelFactory


//Hilt
/*Для хилт не нужен AppModule т.к контекст для модулей в которых он нам нужен
  предоставляется хилтом через аннотацию @ApplicationContext.
  Также хилт сам предоставляет вью модель  */


//@Module
//class AppModule(val context: Context) {
//
//    //Представляется Context
//    @Provides
//    fun provideContext(): Context {
//        return context
//    }

    //Dagger
/* - эти провайдеры используются если не прописывать в Use Case'ах из domain модуля и
в фабрике вьюмодели аннотацию @Inject constructor*/

    //Предоставляется фабрика
//    @Provides
//    fun provideMainViewModelFactory(
//        getUserNameUseCase: GetUserNameUseCase,
//        saveUserNameUseCase: SaveUserNameUseCase,
//    ): MainViewModelFactory {
//        return MainViewModelFactory(getUserNameUseCase = getUserNameUseCase,
//            saveUserNameUseCase = saveUserNameUseCase)
//    }
//}


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