/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Timetables;

/**
 *
 * @author Dell
 */
public class TimetablesRepository {

    public List<Timetables> select() throws SQLException {

        List<Timetables> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from Timetables ");
        list = new ArrayList<>();
        while (rs.next()) {
            Timetables timetables = new Timetables();
            timetables.setSubjectCode(rs.getString("subjectCode"));
            timetables.setSlotID(rs.getString("slotID"));
            timetables.setLecturerID(rs.getString("lecturerID"));
            timetables.setSemesterID(rs.getString("semesterID"));
            list.add(timetables);
        }
        con.close();
        return list;

    }

    public List<Timetables> selectByLecturer(String lecturerID) throws SQLException {
        List<Timetables> list = new ArrayList<>();
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement(
                "select t.semesterID, t.lecturerID, t.slotID, s.starttime, s.endtime, s.day1, s.day2, t.subjectCode from Timetables as t\n"
                + " left join Slots as s on t.slotID = s.slotID\n"
                + "  where lecturerID = ?");

        stm.setString(1, lecturerID);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Timetables t = new Timetables();
            t.setSemesterID(rs.getString("semesterID"));
            t.setLecturerID(rs.getString("lecturerID"));
            t.setSlotID(rs.getString("slotID"));
            t.setStartTime(rs.getTime("starttime"));
            t.setEndTime(rs.getTime("endtime"));
            t.setDay1(rs.getString("day1"));
            t.setDay2(rs.getString("day2"));
            t.setSubjectCode(rs.getString("subjectCode"));
            list.add(t);
        }
        con.close();
        return list;
    }

    public List<Timetables> listByDate(String lecturerID, String day, String start, String end) throws SQLException {
        List<Timetables> list = new ArrayList<>();
        System.out.println(day);
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement(
                "select t.semesterID, t.lecturerID, t.slotID, s.starttime, s.endtime, s.day1, s.day2, t.subjectCode\n"
                + "from Timetables as t\n"
                + "left join Slots as s on t.slotID = s.slotID\n"
                + "where lecturerID = ? and (day1 = ? or day2 = ?)\n "
                + "and ((? between starttime and endtime) or ( ? between starttime and endtime))");

        stm.setString(1, lecturerID);
        stm.setString(2, day);
        stm.setString(3, day);
        stm.setString(4, start);
        stm.setString(5, end);
        System.out.println(":))");
        ResultSet rs = stm.executeQuery();
        System.out.println("ou[pop");
        while (rs.next()) {
            Timetables t = new Timetables();
            t.setLecturerID(rs.getString("lecturerID"));
            t.setSlotID(rs.getString("slotID"));
            t.setStartTime(rs.getTime("starttime"));
            t.setEndTime(rs.getTime("endtime"));
            t.setDay1(rs.getString("day1"));
            t.setDay2(rs.getString("day2"));
            t.setSubjectCode(rs.getString("subjectCode"));
            System.out.println("weurweu");

            list.add(t);
        }
        System.out.println(list.size());
        con.close();
        return list;
    }

    public Timetables read(String subjectCode, String slotID, String lecturerID, String semesterID) throws SQLException {
        Timetables timetables = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Timetables where subjectCode = ? and slotID = ? and lecturerID = ? and semesterID = ? ");
        stm.setString(1, subjectCode);
        stm.setString(2, slotID);
        stm.setString(3, lecturerID);
        stm.setString(4, semesterID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            timetables = new Timetables();
            timetables.setSubjectCode(rs.getString("subjectCode"));
            timetables.setSlotID(rs.getString("slotID"));
            timetables.setLecturerID(rs.getString("lecturerID"));
            timetables.setSemesterID(rs.getString("semesterID"));
        }
        con.close();
        return timetables;
    }

    public Timetables read1(String subjectCode) throws SQLException {
        Timetables timetables = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Timetables where subjectCode = ?");
        stm.setString(1, subjectCode);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            timetables = new Timetables();
            timetables.setSubjectCode(rs.getString("subjectCode"));
            timetables.setSlotID(rs.getString("slotID"));
            timetables.setLecturerID(rs.getString("lecturerID"));
            timetables.setSemesterID(rs.getString("semesterID"));
        }
        con.close();
        return timetables;
    }

    public void create(Timetables timetables) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Timetables values(?, ?, ?, ?)");
        stm.setString(1, timetables.getSubjectCode());
        stm.setString(2, timetables.getSlotID());
        stm.setString(3, timetables.getLecturerID());
        stm.setString(4, timetables.getSemesterID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Timetables timetables) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Timetables set subjectCode = ?, slotID = ?, lecturerID = ?, semesterID = ?  where subjectCode = ? and slotID = ? and lecturerID = ? and semesterID = ? ");
//        PreparedStatement stm = con.prepareStatement("update Timetables set slotID = ?, lecturerID = ?, semesterID = ?  where subjectCode = ? ");
        stm.setString(1, timetables.getSubjectCode());
        stm.setString(2, timetables.getSlotID());
        stm.setString(3, timetables.getLecturerID());
        stm.setString(4, timetables.getSemesterID());
        stm.setString(5, timetables.getSubjectCode());
        stm.setString(6, timetables.getSlotID());
        stm.setString(7, timetables.getLecturerID());
        stm.setString(8, timetables.getSemesterID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(String subjectCode, String slotID, String lecturerID, String semesterID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from Timetables where subjectCode = ? and slotID = ? and lecturerID = ? and semesterID = ? ");
        stm.setString(1, subjectCode);
        stm.setString(2, slotID);
        stm.setString(3, lecturerID);
        stm.setString(4, semesterID);
        int count = stm.executeUpdate();
        con.close();
    }
}
