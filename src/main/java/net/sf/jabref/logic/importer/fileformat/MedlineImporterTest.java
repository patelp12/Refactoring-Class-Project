package net.sf.jabref.logic.importer.fileformat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import net.sf.jabref.logic.importer.ParseException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MedlineImporterTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testImportCorruptedXmlThrowsParseException() throws Exception {
        MedlineImporter importer = new MedlineImporter();
        
        // Malformed/truncated XML input stream
        InputStream invalidStream = new ByteArrayInputStream("<PubmedArticle><MedlineCitation>".getBytes(StandardCharsets.UTF_8));

        thrown.expect(ParseException.class);
        importer.importDatabase(invalidStream);
    }
}