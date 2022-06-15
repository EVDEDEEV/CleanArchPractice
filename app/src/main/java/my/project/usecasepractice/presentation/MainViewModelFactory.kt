package my.project.usecasepractice.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import my.project.usecasepractice.domain.useCases.GetUserNameUseCase
import my.project.usecasepractice.domain.useCases.SaveUserNameUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase,
) : ViewModelProvider.Factory {

    //Для Hilt не нужна фабрика вью модели т.к он предоставляет её сам!!


    //without Di
//    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
//        GetUserNameUseCase(userRepository = userRepository)
//    }
//
//    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
//        SaveUserNameUseCase(userRepository = userRepo)
//    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}