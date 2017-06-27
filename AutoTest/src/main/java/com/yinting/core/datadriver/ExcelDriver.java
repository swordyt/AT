package com.yinting.core.datadriver;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelDriver extends DataDriver {
	private int position = 1;
	private int totalParameter = 0;
	private String[] parameter;
	private String filePath = "";// excel 路径
	private String sheetName = "";
	private String[] cellName;
	private Workbook book = null;
	private Sheet sheet = null;
	private int rowNum = 0;// 数据表的行数

	public ExcelDriver(Method method) {
		parameter = DataDriver.parameteres.get(md5(method));
		this.totalParameter = parameter.length;
		filePath = parameter[0];// 第一个参数为filePath
		sheetName = parameter[1];// 第二个参数为sheetName
		readExcel(filePath, sheetName);
	}

	public boolean hasNext() {
		return position <= this.rowNum - 1;
	}

	public Object[] next() {
		Map<String, String> data = this.readRow(this.position);
		this.position++;
		return new Object[] { data };
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void remove() {
		// TODO Auto-generated method stub

	}

	private Map<String, String> readRow(int rowNum) {
		Cell[] cells = this.sheet.getRow(rowNum);
		Map<String, String> data = new HashMap<String, String>();
		for (int i = 0; i < this.cellName.length; i++) {
			// 如果有为空的列该列就会被抛弃，不被载入。
			if (i>=cells.length||cells[i].getType() == CellType.EMPTY) {
				continue;
			}
			data.put(this.cellName[i], cells[i].getContents().toString());
		}
		return data;
	}

	// 初始化Excel数据
	private void readExcel(String path, String sheet) {
		try {
			this.book = Workbook.getWorkbook(new File(path));
		} catch (Exception e) {
			throw new RuntimeException(path + "文件未发现");
		}
		this.sheet = this.book.getSheet(sheet);
		Cell[] cells = this.sheet.getRow(0);
		this.cellName=new String[cells.length];
		for (int i = 0; i < cells.length; i++) {
			this.cellName[i] = cells[i].getContents().toString();
		}
		this.rowNum = this.sheet.getRows();
	}

}
