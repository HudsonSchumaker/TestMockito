package br.com.schumaker.invocation;

/**
 *
 * @author hudson.schumaker
 */
 
@Data
public class EncryptedId implements Serializable {

    private long companyId;
    private long id;

    public EncryptedId(long companyId, long id) {
        this.id = id;
        this.companyId = companyId;
    }
}
