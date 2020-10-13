package br.com.schumaker.invocation;

public CompanyClientImplTest {  

  @InjectMocks
  private CompanyClient tested = new CompanyClientImpl();
    
  @Mock
  private IdCryptoTool idCryptoTool;
  
  @Before
  public void setUp() throws Exception {
    ContextTestHelper.setDummyContext();

    when(idCryptoTool.encryptId(any(Long.class))).thenAnswer(
      invocation -> "_" + invocation.getArgument(0) + "_");

    when(idCryptoTool.encryptId(any(EncryptedId.class))).thenAnswer(
      invocation -> "_" + ((EncryptedId)invocation.getArgument(0)).getId() + "_");

    when(idCryptoTool.decryptId(any(String.class))).thenAnswer(
      invocation -> {
            String encryptedId = invocation.getArgument(0);
            return new EncryptedId(HeavenContext.getCompanyId(), Long.valueOf(encryptedId.substring(1, encryptedId.length() - 1)));
       });
    }
}
