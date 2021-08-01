package guru.qa;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class ZipFileTest {

    @Test
    static void zipTest() throws IOException, ZipException {
        String zipFilePath = ".src/test/resources/zip_test.zip";
        String unzipFolderPath = ".src/test/resources/unzip";
        String zipPassword = "12345678";
        String unzipTxtFilePath = ".src/test/resources/unzip/txt_test.txt";
        String expectedData = "Иванов Иван Иванович";
    
        ZipFile zipFile = new ZipFile(zipFilePath);

        if (zipFile.isEncrypted()) {
            zipFile.setPassword(zipPassword);
        }
        zipFile.extractAll(unzipFolderPath);
        
        String actualData = readTextFromPath(unzipTxtFilePath);
        
        assertThat(actualData, containsString(expectedData));
        





}

    private static Object containsString(String expectedData) {
    }

    private static String readTextFromPath(String unzipTxtFilePath) {
    }

