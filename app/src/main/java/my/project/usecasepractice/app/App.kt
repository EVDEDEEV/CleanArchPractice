package my.project.usecasepractice.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

}


//Dagger
////App класс нужен для создания "точки входа и создание Dagger'a"
//class App : Application() {
//
//    lateinit var appComponent: AppComponent
//
//    override fun onCreate() {
//        super.onCreate()
//
//        appComponent = DaggerAppComponent
//            .builder()
//            .appModule(AppModule(context = this))
//            .build()
//    }
//}


//Koin
//class App : Application() {
//
//    override fun onCreate() {
//        super.onCreate()
//
//        startKoin {
//            androidLogger(Level.DEBUG)
//            androidContext(this@App)
//            modules(listOf(appModule, domainModule, dataModule))
//        }
//    }
//}