package Bee;  // same package as the class being tested

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParserTest {
    @Test
    public void validateIntInRange_smaller_indexExceptionThrown() {
        try {
            Parser.validateIntInRange("0", 1, 2);
            fail();
        } catch (Exception e) {
            assertEquals("Task doesn't exit... please enter a valid task index!", e.getMessage());
        }
    }

    @Test
    public void validateIntInRange_larger_indexExceptionThrown() {
        try {
            Parser.validateIntInRange("3", 1, 2);
            fail();
        } catch (Exception e) {
            assertEquals("Task doesn't exit... please enter a valid task index!", e.getMessage());
        }
    }

    @Test
    public void validateIntInRange_notNumber_indexExceptionThrown() {
        try {
            Parser.validateIntInRange("a", 1, 2);
            fail();
        } catch (Exception e) {
            assertEquals("Please enter a number", e.getMessage());
        }
    }

    @Test
    public void validateIntInRange_valid_success() {
        try {
            assertEquals(Parser.validateIntInRange("2", 1, 3), 2);
        } catch (Exception e) {
            fail();
        }
    }
}
