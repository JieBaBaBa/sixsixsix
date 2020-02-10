package com.time.demo.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

public class ExcelUtil {

	/**
	 * 
	 * @param sheetName sheet的名字
	 * @param path      保存的路径
	 * @param list      需要导出的list集合（内容）
	 * @param object    导出的模型类（此类必须继承了BaseRowModel）
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void getExcel(String sheetName, String path, List<? extends BaseRowModel> list, Object object)
			throws Exception {
		OutputStream out = new FileOutputStream(path);
		ExcelWriter writer = EasyExcelFactory.getWriter(out);
		Sheet sheet1 = new Sheet(1, 0, (Class<? extends BaseRowModel>) object);
		sheet1.setSheetName(sheetName);
		writer.write(list, sheet1);
		writer.finish();
		out.close();
	}
}
