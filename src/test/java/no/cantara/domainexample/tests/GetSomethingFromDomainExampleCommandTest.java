package no.cantara.domainexample.tests;

import no.cantara.domainexample.commands.GetSomethingFromDomainExampleCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.assertNotNull;

public class GetSomethingFromDomainExampleCommandTest extends DomainExampleCommandBaseTest {
    private final static Logger LOG = LoggerFactory.getLogger(GetSomethingFromDomainExampleCommandTest.class);

    @Test
    public void test_GetSomethingFromDomainExampleCommand() throws Exception {
        MyDomainContract myDomainContract = new GetSomethingFromDomainExampleCommand()
            .withFallback(true)
            .withConfiguration(configuration)
            .withPatientId(UUID.randomUUID())
            .withPrescriptionId(UUID.randomUUID())
            .execute();

        LOG.debug("Got myDomainContract: {}",myDomainContract);

        assertNotNull(myDomainContract);
    }
}