package br.com.schumaker.mockito;

/**
 *
 * @author hudson.schumaker
 */
public enum EnumEvenOdd {
    EVEN("even"),
    ODD("odd");
    
    private final String value;   
    private EnumEvenOdd(String value){
        this.value = value;
    }
    
    public String getValue(){
        return value;
    }
}