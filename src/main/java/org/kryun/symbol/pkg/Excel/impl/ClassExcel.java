package org.kryun.symbol.pkg.Excel.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.kryun.symbol.model.ClassDTO;
import org.kryun.symbol.pkg.Excel.interfaces.ExcelServiceInterface;

public class ClassExcel implements ExcelServiceInterface {

    private List<String> columnList = new ArrayList<String>(
            Arrays.asList("id", "name", "type"));
    private List<ClassDTO> dataList = new ArrayList<ClassDTO>();

    @Override
    public void createExcelSheet(XSSFWorkbook wb) throws Exception {
        XSSFSheet sheet = wb.createSheet("ClassDTO");

        CellStyle headStyle = wb.createCellStyle();

        XSSFFont title_font = wb.createFont();
        title_font.setFontName(HSSFFont.FONT_ARIAL);
        title_font.setFontHeightInPoints((short) 12);
        title_font.setBold(true);

        headStyle.setFont(title_font);
        headStyle.setAlignment(HorizontalAlignment.CENTER);
        headStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        XSSFRow titleRow = sheet.createRow(0);
        // 타이틀 컬럼 값 지정
        for (int i = 0; i < columnList.size(); i++) {
            XSSFCell cell = titleRow.createCell(i);
            cell.setCellStyle(headStyle);
            cell.setCellValue(columnList.get(i));
        }

        // 데이터 입력
        for (int i = 0; i < dataList.size(); i++) {
            Row bodyRow = sheet.createRow(i + 1);
            ClassDTO current_cd = dataList.get(i);
            for (int j = 0; j < columnList.size(); j++) {
                Cell cell = bodyRow.createCell(j);
                switch (columnList.get(j)) {
                    case "id":
                        cell.setCellValue(current_cd.getClassId());
                        break;
                    case "name":
                        cell.setCellValue(current_cd.getName());
                        break;
                    case "type":
                        cell.setCellValue(current_cd.getType());
                        break;
                    default:
                        System.out.println("column 값을 다시 확인해주세요");
                }
            }
        }
    }

    public List<String> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<String> columnList) {
        this.columnList = columnList;
    }

    public List<ClassDTO> getDataList() {
        return dataList;
    }

    public void setDataList(List<ClassDTO> dataList) {
        this.dataList = dataList;
    }

}
