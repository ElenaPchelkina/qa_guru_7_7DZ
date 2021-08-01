package guru.qa;

import com.codeborne.pdftest.PDF;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;


public class PdfFileTest {
    @Test
    void pdfTest() throws IOException {
        String pdfFilePath = "./src/test/resources/files/pdf_test.pdf";
        String expectedData = "Document";

        PDF pdf = new PDF(new File(pdfFilePath));
        assertThat(pdf, PDF.containsText(expectedData));
    }



}
