package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {

	// Reference na privatna polja koja nam sluze za
	// skladistenje objekata excell-a

	private static HSSFWorkbook ExcelWBook;
	private static HSSFCell Cell;
	private static HSSFRow Row;
	// Pomocu ovoga bilo kij podatak pretvaramo u string
	private static DataFormatter formatter;
	
	private static HSSFSheet ExcelWSheet;
	public static HSSFSheet getExcelWSheet() {
		return ExcelWSheet;
	}
	
	// Metoda koja nam postavlja excell fajl
	// i poslato ime worksheeta
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Ucitavamo neki fajl cija je putanja
			// poslata kao Path
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Otvaramo fajl kao excell fajl
			ExcelWBook = new HSSFWorkbook(ExcelFile);

			// uzimamo worksheet iz datog excell fajla
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			// inicijalizujemo dataformatter objekat
			formatter = new DataFormatter();
		} catch (Exception e) {
			throw (e);
		}

	}

	// Uzimamo podatak iz excelltabele za zadat red i kolonu
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {

			// uzimamo celiju
			// tako sto uzmemo zadati red
			// a onda zadatu kolonu
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			// Pretvara u string infomarciju iz celije
			String CellData = formatter.formatCellValue(Cell);
			// String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}

	}

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {

			// uzimamo red u koji upisujemo
			Row = ExcelWSheet.getRow(RowNum);

			// uzimamo celiju u koju zelimo da upisemo
			Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

			// ukoliko je celija prazna ili nepostojeca
			if (Cell == null) {
				// kreiramo jen na zadatom mestu
				Cell = Row.createCell(ColNum);

				// postavljamo vrednsot u celiji
				Cell.setCellValue(Result);
			} else {

				// ako posotji podatak, svakak postavljamo vrednost tj gazimo stari
				Cell.setCellValue(Result);
			}

			// Ovaj deo koda upisuje izmene u excell fajl
			FileOutputStream fileOut = new FileOutputStream(Config.Path_TestData + Config.File_TestData);
			ExcelWBook.write(fileOut);

			// prazni podatke unutar fajla
			fileOut.flush();

			// zatvaramo izlazni tok ka fajlu
			fileOut.close();
		} catch (Exception e) {
			throw (e);

		}

	}
	//Vraca referencu na worksheet
	public static HSSFSheet getWorkSheet() {
		return ExcelWSheet;
	}

}
