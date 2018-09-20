package br.com.schumaker.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

/**
 *
 * @author hudson.schumaker
 */
public class EvenOddTest {
    
    @Spy
    private EvenOdd eo;
    
    @Before
    public void initTestCase(){
        eo = Mockito.spy(new EvenOdd());
    }
    
    @Test
    public void testPlayEnven(){
        Mockito.when(eo.verifyNumber(Mockito.anyInt())).thenReturn(true);
        Assert.assertEquals(EnumEvenOdd.EVEN, eo.play(4));
    }
    
    @Test
    public void testPlayOdd(){
        Mockito.when(eo.verifyNumber(Mockito.anyInt())).thenReturn(true);
        Assert.assertEquals(EnumEvenOdd.ODD, eo.play(3));
    }
    
    @Test
    public void testVerifyNumberTrue(){
        Assert.assertTrue(eo.verifyNumber(5));
    }
    
    @Test
    public void testVerifyNumberFalse(){
        Assert.assertFalse(eo.verifyNumber(6));
    }
}
