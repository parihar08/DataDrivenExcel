package datadriventest;
import utility.Xls_Reader;

public class Exceloperations {

	public static void main(String[] args) throws InterruptedException {
		
		String excelPath = "/Users/Parihar08/Documents/workspace/DataDrivenExcel/src/testdata/HalfEbayTestData.xlsx";
		Xls_Reader reader = new Xls_Reader(excelPath);
		int rowCount = reader.getRowCount("RegTestData");
		System.out.println("<===================================================>");
		System.out.println("Row count of RegTestData sheet is: "+rowCount);	
		reader.addColumn("RegTestData", "Status"); //Creating a new Column
		reader.addSheet("HomePage"); //Creating a new Sheet
		
		if(!reader.isSheetExist("LoginPage")){  //Check if a sheet exist and then create the sheet
			reader.addSheet("LoginPage");
		}
		
		if(!reader.isSheetExist("HomePage")){  //Check if a sheet exist and it exists then do not create a new sheet
			reader.addSheet("HomePage");
		}
		
		int colCount = reader.getColumnCount("RegTestData");
		System.out.println("<===================================================>");
		System.out.println("Column count of RegTestData sheet is: "+colCount);	
		System.out.println("<===================================================>");
		System.out.println(reader.getCellRowNum("RegTestData", "firstname", "Roger"));
		
		}		

}
