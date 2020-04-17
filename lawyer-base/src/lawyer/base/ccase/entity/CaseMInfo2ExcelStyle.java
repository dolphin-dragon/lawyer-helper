package lawyer.base.ccase.entity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.entity.params.ExcelForEachParams;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;

public class CaseMInfo2ExcelStyle implements IExcelExportStyler {

	@Override
	public CellStyle getHeaderStyle(short headerColor) {
		return null;
	}

	@Override
	public CellStyle getTitleStyle(short color) {
		return null;
	}

	@Override
	public CellStyle getStyles(boolean parity, ExcelExportEntity entity) {
		return null;
	}

	@Override
	public CellStyle getStyles(Cell cell, int dataRow, ExcelExportEntity entity, Object obj, Object data) {
		return null;
	}

	@Override
	public CellStyle getTemplateStyles(boolean isSingle, ExcelForEachParams excelForEachParams) {
		return null;
	}
}
