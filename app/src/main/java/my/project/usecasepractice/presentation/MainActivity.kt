package my.project.usecasepractice.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import my.project.usecasepractice.app.App
import my.project.usecasepractice.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //Инжектим фабрику для вью модели, напрямую почему то нельзя пробрасывать view model
    //lateinit var for Dagger
    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var mainViewModel: MainViewModel

    //mainViewModel for Di Koin
//    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "Activity crated")

        //Пробрасываем в активити view model
        mainViewModel = ViewModelProvider(this, vmFactory)
            .get(MainViewModel::class.java)


        mainViewModel.resultLive.observe(this) { text ->
            binding.dataTextView.text = text
        }

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            mainViewModel.save(text)
        }

        binding.receiveButton.setOnClickListener {
            mainViewModel.load()
        }


    }
}