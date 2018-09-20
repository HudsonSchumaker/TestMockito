package br.com.schumaker.mockito;

/**
 *
 * @author hudson.schumaker
 */
public class EvenOdd {
    
    public EnumEvenOdd play(int n){
        if(!verifyNumber(n)){
            throw new NumberFormatException();
        }
        if(n%2==0){
            return EnumEvenOdd.EVEN;
        } else {
            return EnumEvenOdd.ODD;
        }
    }
    
    public boolean verifyNumber(int n){
        return n>=0 && n<=5;
    }
}
