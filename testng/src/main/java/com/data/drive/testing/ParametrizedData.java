package com.data.drive.testing;

import com.excel.utilities.Xls_Reader;

public class ParametrizedData {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\jose.maciel\\eclipse-workspace\\testng\\src\\main\\resources\\googledataexcel.xlsx");
		int rowCount = reader.getRowCount("Planilha1");

		for(int rowNum = 2; rowNum <= rowCount ; rowNum++) {
			String rowValue = reader.getCellData("Planilha1", "termoPesquisa", rowNum);
			System.out.println(rowValue);
		}
	}
}
