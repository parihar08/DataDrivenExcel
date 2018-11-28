package utility;

import java.util.ArrayList;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		String excelPath = "/Users/Parihar08/Documents/workspace/DataDrivenExcel/src/testdata/HalfEbayTestData.xlsx";
		
		try{
			reader = new Xls_Reader(excelPath);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("RegTestData");rowNum++){
			//String currentTestMethod = reader.getCellData("RegTestData", "firstname", rowNum);
			//if(currentTestMethod.equals("getTestData")){
				System.out.println("<===================================================>");
				String firstname = reader.getCellData("RegTestData", "firstname", rowNum);
				System.out.println("Firstname: "+firstname);
				String lastname = reader.getCellData("RegTestData", "lastname", rowNum);
				System.out.println("Lastname: "+lastname);
				String email = reader.getCellData("RegTestData", "email", rowNum);
				System.out.println("Email id: "+email);
				String password = reader.getCellData("RegTestData", "password", rowNum);
				System.out.println("Password: "+password);
				
				Object[] obj = {firstname,lastname,email,password};  //In object array we can store different types of values
				myData.add(obj); 
		}
		return myData;
		
	}

}
