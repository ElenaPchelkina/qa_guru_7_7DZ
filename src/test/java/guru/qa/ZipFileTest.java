package guru.qa;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipFileTest {
    @Test
    void zipTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/zip_test.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String zipPassword = "12345678";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/txt_test.txt";


        ZipFile zipFile = new ZipFile(zipFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(zipPassword);

            zipFile.extractAll(unzipFolderPath);
            File unzippedFile = new File(unzipTxtFilePath);
            String fileContent = FileUtils.readFileToString(unzippedFile, StandardCharsets.UTF_8);
            assertThat(fileContent).contains("Иванов Иван Иванович");
        }
    }
}
