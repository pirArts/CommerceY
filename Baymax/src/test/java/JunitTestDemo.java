import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: EricQiu
 * Date: 5/25/15
 * Time: 12:04 PM
 */
public class JunitTestDemo {
    @Test
    public void testEquals() {
    	Assert.assertEquals("Test", "Test");
    }
}
