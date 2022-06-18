package my.project.usecasepractice.domain.useCases

import my.project.usecasepractice.domain.models.SaveUserNameParam
import my.project.usecasepractice.domain.models.UserName
import my.project.usecasepractice.domain.repository.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SaveUserNameUseCaseTest {

    val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown() {
        Mockito.reset(userRepository)

    }

    @Test
    fun `should not save data if name was already saved`() {

        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val testParams = SaveUserNameParam(name = "test first name")
        val actual = useCase.execute(testParams)
        val expected = true

        Assertions.assertEquals(actual, expected)

        Mockito.verify(userRepository, Mockito.never()).saveName(saveParam = any())
    }

    @Test
    fun `should return true if save was successful`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val expected = false
        val testParams = SaveUserNameParam(name = "new first name")
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute(testParams)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }

    @Test
    fun `should return false if save was successful`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val expected = false
        val testParams = SaveUserNameParam(name = "new first name")
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute(testParams)

        Assertions.assertEquals(expected, actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }



//    @Test
//    fun `should not have write new data if it equals with old`(): Boolean {
//
//        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
//        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)
//
//        val useCase = SaveUserNameUseCase(userRepository = userRepository)
//
//        val testParams = SaveUserNameParam(name = "test first name")
//
//        if (useCase.equals(testParams)) {
//            return true
//        }
//
//        return false
//
//    }
}

