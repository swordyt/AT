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
	private String filePath = "";// excel 路径
	private String sheetName = "";
	private String[] cellName;
	private Workbook book = null;
	private Sheet sheet = null;
	private int total = 0;// 数据表的行数
	private int position = 1;
	public ExcelDriver(Method method) {
		this.parameter = DataDriver.parameteres.get(md5(method));
		this.totalParameter = parameter.length;
		filePath = parameter[0];// 第一个参数为filePath
		sheetName = parameter[1];// 第二个参数为sheetName
		initPara(filePath, sheetName);
	}

	public boolean hasNext() {
		return position <= this.total - 1;
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
	private void initPara(String path, String sheet) {
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
		this.total = this.sheet.getRows();
	}

}
