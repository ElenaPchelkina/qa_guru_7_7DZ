package guru.qa;

import com.codeborne.pdftest.assertj.Assertions;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DocxFileTest {

    @Test
    void docxTest() throws IOException {
    String docxFilePath = "./src/test/resources/files/doc_test.docx";
    String expectedData = "Иванов Иван Иванович";

        XWPFDocument doc = new XWPFDocument(
            Files.newInputStream(Paths.get(docxFilePath)));
        XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
        String docText = xwpfWordExtractor.getText();
        Assertions.assertThat(docText).contains(expectedData);

    }
}
