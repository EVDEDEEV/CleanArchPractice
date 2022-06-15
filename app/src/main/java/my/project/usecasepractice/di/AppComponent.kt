package my.project.usecasepractice.di

import dagger.Component
import my.project.usecasepractice.presentation.MainActivity

//Инжектим модули в нужные активити/фрагменты
@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}