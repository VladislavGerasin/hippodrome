import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    @Disabled
    @Timeout(21)
    void testMethodExecutionTime() throws Exception {

        Main.main(null);
    }
}
