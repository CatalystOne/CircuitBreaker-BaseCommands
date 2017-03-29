package no.cantara.base.command.soap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static no.cantara.base.command.soap.XpathHelper.findValue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by baardl on 2017-03-29.
 */
public class XpathHelperTest {
    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testFindValueOk() throws Exception {
        String value = findValue(xml, "//base");
        assertNotNull(value);
        assertEquals(value, "test");

    }

    @Test
    public void testFindValueMissingValue() throws Exception {
        assertEquals("", findValue(null, null));
        assertEquals("", findValue(null, ""));
        assertEquals("", findValue("", null));
        assertEquals("", findValue(xml, null));
        assertEquals("", findValue(null, "//base"));

    }

    private static final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<no><cantara><base>test</base></cantara></no>";

}