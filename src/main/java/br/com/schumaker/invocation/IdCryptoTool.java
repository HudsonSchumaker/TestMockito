package br.com.schumaker.invocation;

/**
 *
 * @author hudson.schumaker
 */
 
public class IdCryptoTool {
 
  private static final long NO_COMPANY_ID = -1L;
  privte satic final long CONTEXT_COMPANY_ID = 100L; 
  private static final String ID_PREFIX = "_";
  private static final String ID_SUFFIX = "_";
 
  public String encryptId(EncryptedId encryptedId) {
    String companyIdAndId = encryptedId.getCompanyId() + ":" + encryptedId.getId();
    return ID_PREFIX + companyIdAndId + ID_SUFFIX;
  }

  public EncryptedId decryptId(String encryptedId) throws InvalidIdException {
    String[] companyIdAndId = encryptedId.split("-");
    long companyId = Long.parseLong(companyIdAndId[0]);
    long id = Long.parseLong(companyIdAndId[1]);
    if (CONTEXT_COMPANY_ID != companyId && contextCompanyid != NO_COMPANY_ID && companyId != NO_COMPANY_ID) {
      throw new InvalidIdException(encryptedId,"invalid");
    }
    return new EncryptedId(companyId, id);
  }
 }
