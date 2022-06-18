package my.project.usecasepractice.presentation

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import my.project.usecasepractice.domain.models.SaveUserNameParam
import my.project.usecasepractice.domain.models.UserName
import my.project.usecasepractice.domain.useCases.GetUserNameUseCase
import my.project.usecasepractice.domain.useCases.SaveUserNameUseCase
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.rules.TestRule
import org.mockito.Mockito
import org.mockito.kotlin.mock

class MainViewModelTest {

    val getUserNameUseCase = mock<GetUserNameUseCase>()
    val saveUserNameUserCase = mock<SaveUserNameUseCase>()

//    @get:Rule
//    val instantExecutorRule = InstantTaskExecutorRule()
@get:Rule
var rule: TestRule = InstantTaskExecutorRule()

    @AfterEach
    fun afterEach() {
        Mockito.reset(getUserNameUseCase)
        Mockito.reset(saveUserNameUserCase)
//        ArchTaskExecutor.getInstance().setDelegate(null)
    }

    @BeforeEach
    fun beforeEach() {
//        ArchTaskExecutor.getInstance()
//            .setDelegate(object : TaskExecutor() {
//                override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
//
//                override fun postToMainThread(runnable: Runnable) = runnable.run()
//
//                override fun isMainThread(): Boolean = true
//            })
    }


    @Test
    fun `should save username and return true`() {

        val saveResult = true
        val testSaveText = "Test user name"
        val testParams = SaveUserNameParam(name = testSaveText)

        Mockito.`when`(saveUserNameUserCase.execute(param = testParams))
            .thenReturn(saveResult)


        val viewModel = MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUserCase
        )

        viewModel.save(text = testSaveText)

        val expected = "Save result = true"
        val actual = viewModel.resultLive.value


        Mockito.verify(saveUserNameUserCase, Mockito.times(1))
            .execute(param = testParams)
        Assertions.assertEquals(expected, actual)

    }

    @Test
    fun `should save username and return false`() {


    }

    @Test
    fun `should load username`() {
        val testUserName = UserName(
            firstName = "Test first name",
            lastName = "Test last name"
        )



        Mockito.`when`(getUserNameUseCase.execute()).thenReturn(testUserName)

        val viewModel = MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUserCase
        )

        viewModel.load()

        val expected = "${testUserName.firstName} ${testUserName.lastName}"
        val actual = viewModel.resultLive.value

        Mockito.verify(getUserNameUseCase, Mockito.times(1))
            .execute()

        Assertions.assertEquals(expected, actual)

    }
}