import org.assertj.swing.fixture.FrameFixture;
import org.example.CalculatorController;
import org.example.CalculatorModel;
import org.example.CalculatorView;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import javax.swing.*;

public class TestGUI {

    private JFrame calculatorFrame;
    private CalculatorView calculatorView;

    private CalculatorController controller;
    private CalculatorModel model;
    private FrameFixture frameFixture;

    @Before
    public void setUp() {
        // Initialize the class-level model, view, and controller
        model = new CalculatorModel();
        calculatorView = new CalculatorView();
        controller = new CalculatorController(model, calculatorView);
        model.addObserver(calculatorView);

        // Initialize the FrameFixture for the view
        frameFixture = new FrameFixture(calculatorView);
        frameFixture.show(); // Ensure the frame is shown
    }



    @Test
    public void testButtonClick() {
        // Simulate button click for '5' using name
        frameFixture.button("digit5").click();  // Using setName("digit5")

        // Check that the display shows "5"
        assertThat(calculatorView.getDisplay().getText()).isEqualTo("5");
    }

    @Test
    public void testAdditionOperation() {
        // Perform 1 + 2 = operation using button names
        frameFixture.button("digit1").click();
        frameFixture.button("+").click();
        frameFixture.button("digit2").click();
        frameFixture.button("=").click();

        // Check if result is 3
        assertThat(calculatorView.getDisplay().getText()).isEqualTo("3.0");
    }

    @Test
    public void testClearButton() {
        // Type a number and clear it
        frameFixture.button("digit5").click();
        frameFixture.button("C").click();

        // Verify the display is cleared
        assertThat(calculatorView.getDisplay().getText()).isEqualTo("");
    }
    @Test
    public void testSquareOperation() {
        frameFixture.button("digit3").click();
        frameFixture.button("^2").click();
        frameFixture.button("=").click();

        // Verify that the result is 9 (3^2)
        assertThat(calculatorView.getDisplay().getText()).isEqualTo("9.0");
    }
    @Test
    public void testDivisionByZero() {
        frameFixture.button("digit2").click();
        frameFixture.button("digit2").click();
        frameFixture.button("/").click();
        frameFixture.button("digit0").click();
        frameFixture.button("=").click();

        // Verify that the result is "Error" for division by zero
        assertThat(calculatorView.getDisplay().getText()).isEqualTo("Error");
    }
    @Test
    public void testNegativeNumber() {
        frameFixture.button("digit2").click();
        frameFixture.button("-").click();
        frameFixture.button("digit3").click();
        frameFixture.button("=").click();

        // Verify that the result is -1 (2 - 3)
        assertThat(calculatorView.getDisplay().getText()).isEqualTo("-1.0");
    }
    @Test
    public void testMemoryAdditionOnNumber() {
        frameFixture.button("digit5").click();
        frameFixture.button("C").click();
        frameFixture.button("M+").click();
        // Verify that the memory was successfully not updated because it was not an outcome
        assertThat(calculatorView.getDisplay().getText()).isEqualTo("");
    }
    @Test
    public void testDecimalAddition() {
        frameFixture.button("digit1").click();
        frameFixture.button(".").click();
        frameFixture.button("digit2").click();
        frameFixture.button("+").click();
        frameFixture.button("digit3").click();
        frameFixture.button(".").click();
        frameFixture.button("digit4").click();
        frameFixture.button("=").click();

        // Verify that the result is 4.6 (1.2 + 3.4)
        assertThat(calculatorView.getDisplay().getText()).isEqualTo("4.6");
    }





    @Test
    public void testSquareRootOperation() {
        frameFixture.button("digit9").click();
        frameFixture.button("√").click();
        frameFixture.button("=").click();

        // Verify that the result is 3 (√9)
        assertThat(calculatorView.getDisplay().getText()).isEqualTo("3.0");
    }


    @After
    public void tearDown() {
        if (frameFixture != null) {
            frameFixture.cleanUp();
        }
    }
}
