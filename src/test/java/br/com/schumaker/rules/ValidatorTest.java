package br.com.schumaker.rules;

/**
 *
 * @author hudson.schumaker
 */
public class ValidatorTest {

    @Mock
    private WorkingTimeRepository workingtimes;

    @InjectMocks
    private WorkingTimeBLDtoValidator validator;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(validator, "enabled", true);
    }

    // Not working test, just to show how is the way to assert exceptions.
    @Test
    public void testHasOverlappingWorkingTime() {

        // Rule, assertion
        exception.expect(WorkingTimeException.class);
        exception.expect(hasProperty("fields", containsInAnyOrder("startTime", "endTime")));

        // Preparation
        Mockito.when(workingtimes.existsForPeriod(Mockito.anyLong(), Mockito.anyLong(), Mockito.any(Date.class),
                Mockito.any(Date.class), Mockito.any(Date.class), Mockito.any(Date.class))).thenReturn(true);

        WorkingTimeDTO dto = new WorkingTimeDTO();
        dto.setJobId(new EncryptedId(IntegrationTestConsts.COMPANY_ID, IntegrationTestConsts.JOB_ID));

        // Test
        validator.validate(dto, 1L);
    }
}
