import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PatternMatchTest {

    @Test
    public void testPattern() {
        PatternMatcher pm = new PatternMatcher();
        assertTrue(pm.matches("aabab", "catcatcacatca"));
    }

}
