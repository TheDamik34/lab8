package zad2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    @Test
    @DisplayName("Zwykly equals")
    public void testEquals() {
        EqualsClass arg1 = new EqualsClass();
        EqualsClass arg2 = new EqualsClass();

        assertEquals(arg1, arg2, "Obiekty nie sa takie same");

        arg1.setRich(false);

        assertEquals(arg1, arg2, "Obiekty nie sa takie same");

        arg1.setName("damian2");

        assertNotEquals(arg1, arg2, "Obiekty sa takie same");
    }

    @Test
    @DisplayName("Reflection Equals")
    public void testEqualsReflection() {
        EqualsClass arg1 = new EqualsClass();
        EqualsClass arg2 = new EqualsClass();

        assertTrue(arg1.equals2(arg2), "Obiekty nie sa takie same");

        arg1.setRich(false);

        assertTrue(arg1.equals2(arg2), "Obiekty nie sa takie same");

        arg1.setName("damian2");

        assertFalse(arg1.equals2(arg2), "Obiekty sa takie same");

    }
}
