import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.apache.commons.math3.primes.Primes.isPrime;

public class PrimeNumberFilter {
    private final String fileName;
    private final ArrayList<Integer> primeNumbers;

    public PrimeNumberFilter(String fileName){
        this.fileName = fileName;
        primeNumbers = new ArrayList<>();
        extractPrimeNumbers();
    }

    private void extractPrimeNumbers(){
        int rowNumber = 1;
        int columnNumber = 1;

        try(FileInputStream fis=new FileInputStream(fileName);
            Workbook wb=new XSSFWorkbook(fis))
        {

            String value;
            do {
                Sheet sheet = wb.getSheetAt(0);
                Row row = sheet.getRow(rowNumber);
                Cell cell = row.getCell(columnNumber);
                value = cell.getStringCellValue();
                if (value != null) {
                    try{
                        int valueInt = Integer.parseInt(value);
                        if (isPrime(valueInt)) {
                            primeNumbers.add(valueInt);
                        }
                    } catch (NumberFormatException ignored){

                    }
                }
                rowNumber += 1;
            }
            while (value != null);

        } catch(IOException | NullPointerException ignored)
        {

        }
    }

    public void printPrimeNumbers(){
        for(Integer prime: primeNumbers){
            System.out.println(prime);
        }
    }
}
