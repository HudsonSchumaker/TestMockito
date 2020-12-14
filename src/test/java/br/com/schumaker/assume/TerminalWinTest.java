package br.com.schumaker.assume;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

/**
 *
 * @author hudson.schumaker
 */
 public class TerminalWinTest {
 
    @Test
    public void testExecuteCommand() throws InterruptedException {
        // Verification
        assumeTrue(System.getProperty("os.name").contains("Windows"));

        // Preparation
        var path = System.getProperty("user.dir");
        var cmd = "pwd";

        // Test
        TerminalWin tested = new TerminalWin();
        tested.executeCommand(new String[]{cmd});

        // Assertion
        Thread.sleep(500); // wait for clean the buffer.
        assertEquals(path, tested.getOutput().get(0));
    }
 }
