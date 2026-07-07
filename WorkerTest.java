import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    @Test
    void testConstructorAndGetters() {
        Worker w = new Worker("Петров П.П.", "Доцент", 75000, 2020);
        assertEquals("Петров П.П.", w.getFullName());
        assertEquals("Доцент", w.getPosition());
        assertEquals(75000.0, w.getSalary());
        assertEquals(2020, w.getHireYear());
    }

    @Test
    void testExperience() {
        int currentYear = java.time.LocalDate.now().getYear();
        Worker w = new Worker("Сидоров С.С.", "Профессор", 100000, 2021);
        assertEquals(currentYear - 2021, w.getExperience());
    }

    @Test
    void testDefaultConstructor() {
        Worker w = new Worker();
        assertEquals("", w.getFullName());
        assertEquals(0.0, w.getSalary());
    }

    @Test
    void testSetMethods() {
        Worker w = new Worker();
        w.setFullName("Козлова К.К.");
        w.setSalary(60000);
        assertEquals("Козлова К.К.", w.getFullName());
        assertEquals(60000.0, w.getSalary());
    }
}