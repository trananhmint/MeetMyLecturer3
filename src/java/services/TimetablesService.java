/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import models.FreeSlots;
import models.Requests;
import models.Slots;
import models.Timetables;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repositories.SlotsRepository;
import repositories.TimetablesRepository;

/**
 *
 * @author DELL
 */
public class TimetablesService {

    public List<Timetables> readExcel(String lecturerID, String semesterID, String EXCEL_FILE_PATH) throws FileNotFoundException, IOException, SQLException {
        List<Timetables> list = new ArrayList<>();
        TimetablesRepository tr = new TimetablesRepository();

//        EXCEL_FILE_PATH = "D:\\MeetMyLecturer-main\\MeetMyLecturer\\test.xlsx";
        FileInputStream file = new FileInputStream(new File(EXCEL_FILE_PATH));
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);

        String subjectCode = null, slotID = null;
        SlotsRepository sr = new SlotsRepository();
        List<Slots> listSlots = sr.select();

        FormulaEvaluator fmEval = wb.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) {
            for (Cell cell : row) {

                switch (fmEval.evaluateInCell(cell).getCellTypeEnum()) {
                    case STRING: {
                        if (cell.getRichStringCellValue().getString().length() == 2) {
                            slotID = cell.getRichStringCellValue().getString();
                        } else {
                            subjectCode = cell.getRichStringCellValue().getString();
                        }
                        break;
                    }
                    default: {
                        subjectCode = null;
                        break;
                    }
                }
            }

//            tr.create(new Timetables(subjectCode, slotID, lecturerID, semesterID));
            list.add(new Timetables(subjectCode, slotID, lecturerID, semesterID));
        }
        return list;
    }

    public static boolean duplicateSlot(FreeSlots f) throws SQLException {
        TimetablesRepository tr = new TimetablesRepository();
        Calendar startTime = Utilities.dateToCalendar(f.getStartTime());

        String start = Services.sdfTime.format(f.getStartTime());
        String end = Services.sdfTime.format(f.getEndTime());

        String day = Utilities.intToDays(startTime.get(Calendar.DAY_OF_WEEK));

        List<Timetables> list = tr.listByDate(f.getLecturerID(), day, start, end);
        
        if (list.size() > 0) {
            return false;
        }
        return true;
    }

    public static boolean duplicateSlot(Requests r) throws SQLException {
        TimetablesRepository tr = new TimetablesRepository();
        Calendar startTime = Utilities.dateToCalendar(r.getStartTime());

        String start = Services.sdfTime.format(r.getStartTime());
        String end = Services.sdfTime.format(r.getEndTime());

        String day = Utilities.intToDays(startTime.get(Calendar.DAY_OF_WEEK));

        List<Timetables> list = tr.listByDate(r.getLecturerID(), day, start, end);
        if (list.size() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, SQLException, ParseException {
        TimetablesService ts = new TimetablesService();
        String d = "2023-11-11 8:00";
        String d1 = "2023-11-11 10:00";

        Date date = Services.sdfDateTime.parse(d);
        Date date1 = Services.sdfDateTime.parse(d1);

        System.out.println(date);
        FreeSlots f = new FreeSlots(1, "swe", date, date1, "123", 1, "asdfg", 5, "GV0002");
        Requests r = new Requests(1, 1, "Swe", date, date1, "asdfghj", "se123", "gv0002");

        System.out.println(ts.duplicateSlot(r));
    }

}
