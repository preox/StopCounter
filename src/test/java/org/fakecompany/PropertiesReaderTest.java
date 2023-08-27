package org.fakecompany;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class PropertiesReaderTest {


    @Test
    public void missingProperty() throws IOException {
        PropertiesReader propertiesReader = new PropertiesReader("empty.app.properties");
        assertNull(propertiesReader.getProperty("Whatever"));
    }

    @Test
    public void missingPropertyFile() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PropertiesReader("missingFile");
        });
        assertTrue(exception.getMessage().contains("inStream parameter is null"));
    }

    @Test
    public void existingProperty() throws IOException {
        PropertiesReader pr = new PropertiesReader("app.properties");
        assertEquals(pr.getProperty("test"), "HelloWorld!");
    }

}