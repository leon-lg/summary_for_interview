import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
public class ExcelTest {

    @Test
    void getExcelCon() throws Exception {
        FileInputStream file = new FileInputStream("D:\\git\\summary_for_interview\\jave-test\\src\\test\\resources\\交规.xlsx");
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\git\\summary_for_interview\\jave-test\\src\\test\\resources\\交规01.json");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        writer.write("{" + "\n");

        int count = 0;
        for (Row row : sheet) {
            if(count == 0){
                count++;
                continue;
            }
            String res = String.format("\"%s\":\"%s\"", row.getCell(0).toString(), row.getCell(2).toString() + "." + row.getCell(3).toString());
            writer.write(res + "\n");
        }
        writer.write("}" + "\n");
        writer.close();
    }
}
