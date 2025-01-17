import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage
import com.hopcape.onboarding.data.local.OnBoardingPreferencesImpl
import dev.mokkery.answering.returns
import dev.mokkery.mock
import dev.mokkery.every
import dev.mokkery.matcher.any
import dev.mokkery.verify
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class OnBoardingPreferencesTest {

    private lateinit var storage: BooleanKeyValueStorage
    private lateinit var onBoardingPreferences: OnBoardingPreferencesImpl

    @BeforeTest
    fun setUp() {
        // Mock the storage dependency
        storage = mock()
        every { storage.set(any(), any()) } returns Unit
        // Initialize the OnBoardingPreferencesImpl with the mocked storage
        onBoardingPreferences = OnBoardingPreferencesImpl(storage)
    }

    @Test
    fun `test isOnBoardingCompleted returns true when completed`() {
        // Arrange: Mock storage to return true for the ONBOARDING_COMPLETED_KEY
        every { storage.get("onboardingCompleted") } returns true

        // Act: Call isOnBoardingCompleted()
        val result = onBoardingPreferences.isOnBoardingCompleted()

        // Assert: Verify that the result is true
        assertTrue(result)

        // Verify that the correct method was called on the storage
        verify { storage.get("onboardingCompleted") }
    }

    @Test
    fun `test isOnBoardingCompleted returns false when not completed`() {
        // Arrange: Mock storage to return false for the ONBOARDING_COMPLETED_KEY
        every { storage.get("onboardingCompleted") } returns false

        // Act: Call isOnBoardingCompleted()
        val result = onBoardingPreferences.isOnBoardingCompleted()

        // Assert: Verify that the result is false
        assertFalse(result)

        // Verify that the correct method was called on the storage
        verify { storage.get("onboardingCompleted") }
    }

    @Test
    fun `test setOnBoardingCompleted updates the storage with true`() = runTest {
        // Arrange: We do not need to mock storage for this test, as the behavior is tested by interaction with the storage.
        // Act: Set onboarding as completed
        onBoardingPreferences.setOnBoardingCompleted(true)

        // Assert: Verify that the storage's set method was called with the correct key and value
        verify { storage.set("onboardingCompleted", true) }
    }

    @Test
    fun `test setOnBoardingCompleted updates the storage with false`() = runTest {
        // Arrange: We do not need to mock storage for this test, as the behavior is tested by interaction with the storage.
        // Act: Set onboarding as not completed
        onBoardingPreferences.setOnBoardingCompleted(false)

        // Assert: Verify that the storage's set method was called with the correct key and value
        verify { storage.set("onboardingCompleted", false) }
    }
}
