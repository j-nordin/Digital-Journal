
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.EENX15_22_17.digital_journal.android.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainActivityKtInstrumentalTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testHelloWorld() {
        composeTestRule.onNodeWithText("Hello World!")
            .assertDoesNotExist()
    }

    @Test
    fun testPatientList() {
        // Testing with patients Id
        composeTestRule.onNodeWithText("1999-05-02-xxxx").assertExists()
        composeTestRule.onNodeWithText("1990-01-02-xxxx").assertExists()
        composeTestRule.onNodeWithText("1993-12-15-xxxx").assertExists()
    }

    @Test
    fun testIconButtons() {
        // TODO: When backend comes we need mockdata to get the length
        val currentPatientsLength = 3
        composeTestRule.onAllNodesWithContentDescription("Comments")
            .assertCountEquals(currentPatientsLength)
        composeTestRule.onAllNodesWithContentDescription("Overview")
            .assertCountEquals(currentPatientsLength)
        composeTestRule.onAllNodesWithContentDescription("Warnings")
            .assertCountEquals(currentPatientsLength)
    }
}