package guru.qa;


import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class XlsxFileTest {
    @Test
    void xlsxSimpleTest() throws IOException {
        String xlsxFilePath = "./src/test/resources/files/xls_test.xlsx";
        String expectedData = "Иванов Иван Иванович";

        XLS xlsx = new XLS(new File(xlsxFilePath));
        assertThat(xlsx, XLS.containsText(expectedData));
    }

    @Test
    void xlsxCellTest() throws IOException {
        String xlsxFilePath = "./src/test/resources/files/xls_test.xlsx";
        String expectedData = "Иванов Иван Иванович";

        XLS xlsx = new XLS(new File(xlsxFilePath));
        String actualData = xlsx.excel.getSheetAt(0).getRow(1).getCell(0).toString();
        assertThat(actualData, containsString(expectedData));

    }
}
