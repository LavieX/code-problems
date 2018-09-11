package checkwriting;

import static checkwriting.CheckWriter.convertToString;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckWriterTest {

    @Test
    public void testCheckWriter1() {
        String s = convertToString("5");
        assertEquals("five" , s);
        
        s = convertToString("15");
        assertEquals("fifteen" , s);
        
        s = convertToString("100");
        assertEquals("one hundred" , s);
        
        s = convertToString("101");
        assertEquals("one hundred one" , s);
        
        s = convertToString("561");
        assertEquals("five hundred sixty one" , s);
        
        s = convertToString("1,000");
        assertEquals("one thousand" , s);
        
        s = convertToString("1,562");
        assertEquals("one thousand five hundred sixty two" , s);
        
        s = convertToString("756,562");
        assertEquals("seven hundred fifty six thousand five hundred sixty two" , s);
        
        s = convertToString("6,756,562");
        assertEquals("six million seven hundred fifty six thousand five hundred sixty two" , s);
        
    }
}
