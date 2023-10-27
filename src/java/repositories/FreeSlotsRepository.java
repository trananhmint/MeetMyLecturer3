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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import models.FreeSlots;

/**
 *
 * @author Dell
 */
public class FreeSlotsRepository {

    public List<FreeSlots> select1() throws SQLException {
        List<FreeSlots> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from FreeSlots");
        list = new ArrayList<>();
        while (rs.next()) {
            FreeSlots freeSlots = new FreeSlots();
            freeSlots.setID(rs.getInt("ID"));
            freeSlots.setFreeSlotID(rs.getString("freeSlotID"));
            freeSlots.setSubjectCode(rs.getString("subjectCode"));
            freeSlots.setStartTime(rs.getTimestamp("startTime"));
            freeSlots.setEndTime(rs.getTimestamp("endTime"));
            freeSlots.setPassword(rs.getString("password"));
            freeSlots.setCapacity(rs.getInt("capacity"));
            freeSlots.setMeetLink(rs.getString("meetLink"));
            freeSlots.setCount(rs.getInt("count"));
            freeSlots.setLecturerID(rs.getString("lecturerID"));
            list.add(freeSlots);
        }
        con.close();
        return list;
    }

    public List<FreeSlots> select() throws SQLException {
        List<FreeSlots> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(
                "select f.ID, f.freeSlotID, f.subjectCode, f.startTime, f.endTime, f.capacity, f.lecturerID, f.password, f.meetLink, f.count, booked\n"
                + "from FreeSlots f\n"
                + "left join (\n"
                + "   select freeSlotID, COUNT(freeSlotID) as 'booked'\n"
                + "   from Bookings b\n"
                + "   GROUP BY freeSlotID\n"
                + ") b on f.freeSlotID = b.freeSlotID ");
        list = new ArrayList<>();
        while (rs.next()) {
            FreeSlots freeSlots = new FreeSlots();
            freeSlots.setID(rs.getInt("ID"));
            freeSlots.setFreeSlotID(rs.getString("freeSlotID"));
            freeSlots.setSubjectCode(rs.getString("subjectCode"));
            freeSlots.setStartTime(rs.getTimestamp("startTime"));
            freeSlots.setEndTime(rs.getTimestamp("endTime"));
            freeSlots.setPassword(rs.getString("password"));
            freeSlots.setCapacity(rs.getInt("capacity"));
            freeSlots.setMeetLink(rs.getString("meetLink"));
            freeSlots.setCount(rs.getInt("count"));
            freeSlots.setLecturerID(rs.getString("lecturerID"));
            freeSlots.setBooked(rs.getInt("booked"));
            list.add(freeSlots);
        }
        con.close();
        return list;
    }

    public List<FreeSlots> selectFromLecturer1(String lecturerID) throws SQLException {

        List<FreeSlots> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from FreeSlots where lecturerID = ?");
        stm.setString(1, lecturerID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            FreeSlots freeSlots = new FreeSlots();
            freeSlots.setID(rs.getInt("ID"));
            freeSlots.setFreeSlotID(rs.getString("freeSlotID"));
            freeSlots.setSubjectCode(rs.getString("subjectCode"));
            freeSlots.setStartTime(rs.getTimestamp("startTime"));
            freeSlots.setEndTime(rs.getTimestamp("endTime"));
            freeSlots.setPassword(rs.getString("password"));
            freeSlots.setCapacity(rs.getInt("capacity"));
            freeSlots.setMeetLink(rs.getString("meetLink"));
            freeSlots.setCount(rs.getInt("count"));
            freeSlots.setLecturerID(rs.getString("lecturerID"));
            list.add(freeSlots);
        }
        con.close();
        return list;
    }

    public List<FreeSlots> selectFromLecturer(String lecturerID) throws SQLException {

        List<FreeSlots> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select f.ID, f.freeSlotID, f.subjectCode, f.startTime, f.endTime, f.capacity, f.lecturerID, f.password, f.meetLink, f.count, booked\n"
                + "from FreeSlots f\n"
                + "left join (\n"
                + "   select freeSlotID, COUNT(freeSlotID) as 'booked'\n"
                + "   from Bookings b\n"
                + "   GROUP BY freeSlotID\n"
                + ") b on f.freeSlotID = b.freeSlotID where lecturerID = ?");
        stm.setString(1, lecturerID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            FreeSlots freeSlots = new FreeSlots();
            freeSlots.setID(rs.getInt("ID"));
            freeSlots.setFreeSlotID(rs.getString("freeSlotID"));
            freeSlots.setSubjectCode(rs.getString("subjectCode"));
            freeSlots.setStartTime(rs.getTimestamp("startTime"));
            freeSlots.setEndTime(rs.getTimestamp("endTime"));
            freeSlots.setPassword(rs.getString("password"));
            freeSlots.setCapacity(rs.getInt("capacity"));
            freeSlots.setMeetLink(rs.getString("meetLink"));
            freeSlots.setCount(rs.getInt("count"));
            freeSlots.setLecturerID(rs.getString("lecturerID"));
            freeSlots.setBooked(rs.getInt("booked"));
            list.add(freeSlots);
        }
        con.close();
        return list;
    }

    public List<FreeSlots> searchByLecturerID(String lecturerID) throws SQLException {

        List<FreeSlots> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select f.ID, f.freeSlotID, f.subjectCode, f.startTime, f.endTime, f.capacity, f.lecturerID, f.password, f.meetLink, f.count, booked\n"
                + "from FreeSlots f\n"
                + "left join (\n"
                + "   select freeSlotID, COUNT(freeSlotID) as 'booked'\n"
                + "   from Bookings b\n"
                + "   GROUP BY freeSlotID\n"
                + ") b on f.freeSlotID = b.freeSlotID where lecturerID = ?");
        stm.setString(1, lecturerID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            FreeSlots freeSlots = new FreeSlots();
            freeSlots.setID(rs.getInt("ID"));
            freeSlots.setFreeSlotID(rs.getString("freeSlotID"));
            freeSlots.setSubjectCode(rs.getString("subjectCode"));
            freeSlots.setStartTime(rs.getDate("startTime"));
            freeSlots.setEndTime(rs.getDate("endTime"));
            freeSlots.setPassword(rs.getString("password"));
            freeSlots.setCapacity(rs.getInt("capacity"));
            freeSlots.setMeetLink(rs.getString("meetLink"));
            freeSlots.setCount(rs.getInt("count"));
            freeSlots.setLecturerID(rs.getString("lecturerID"));
            freeSlots.setBooked(rs.getInt("booked"));
            list.add(freeSlots);
        }
        con.close();
        return list;
    }

//    public List<FreeSlots> searchByLecturerID1(String lecturerID, String studentID) throws SQLException {
//        List<FreeSlots> list = null;
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("select f.ID, f.freeSlotID, f.subjectCode, f.startTime, f.endTime, f.capacity, f.lecturerID, f.password, f.meetLink, f.count, booked\n"
//                + "from FreeSlots f\n"
//                + "left join (\n"
//                + "   select freeSlotID, COUNT(freeSlotID) as 'booked'\n"
//                + "   from Bookings b\n"
//                + "   GROUP BY freeSlotID\n"
//                + ") b on f.freeSlotID = b.freeSlotID where lecturerID = ? and studentID = ?");
//        stm.setString(1, lecturerID);
//        stm.setString(2, studentID);
//        ResultSet rs = stm.executeQuery();
//        list = new ArrayList<>();
//        while (rs.next()) {
//           FreeSlots freeSlots = new FreeSlots();
//            freeSlots.setID(rs.getInt("ID"));
//            freeSlots.setFreeSlotID(rs.getString("freeSlotID"));
//            freeSlots.setSubjectCode(rs.getString("subjectCode"));
//            freeSlots.setStartTime(rs.getDate("startTime"));
//            freeSlots.setEndTime(rs.getDate("endTime"));
//            freeSlots.setPassword(rs.getString("password"));
//            freeSlots.setCapacity(rs.getInt("capacity"));
//            freeSlots.setMeetLink(rs.getString("meetLink"));
//            freeSlots.setCount(rs.getInt("count"));
//            freeSlots.setLecturerID(rs.getString("lecturerID"));
//            freeSlots.setBooked(rs.getInt("booked"));
//            list.add(freeSlots);
//        }
//        con.close();
//        return list;
//    }

    public List<FreeSlots> searchBySubjectCode(String subjectCode) throws SQLException {

        List<FreeSlots> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select f.ID, f.freeSlotID, f.subjectCode, f.startTime, f.endTime, f.capacity, f.lecturerID, f.password, f.meetLink, f.count, booked\n"
                + "from FreeSlots f\n"
                + "left join (\n"
                + "   select freeSlotID, COUNT(freeSlotID) as 'booked'\n"
                + "   from Bookings b\n"
                + "   GROUP BY freeSlotID\n"
                + ") b on f.freeSlotID = b.freeSlotID where subjectCode = ?");
        stm.setString(1, subjectCode);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            FreeSlots freeSlots = new FreeSlots();
            freeSlots.setID(rs.getInt("ID"));
            freeSlots.setFreeSlotID(rs.getString("freeSlotID"));
            freeSlots.setSubjectCode(rs.getString("subjectCode"));
            freeSlots.setStartTime(rs.getDate("startTime"));
            freeSlots.setEndTime(rs.getDate("endTime"));
            freeSlots.setPassword(rs.getString("password"));
            freeSlots.setCapacity(rs.getInt("capacity"));
            freeSlots.setMeetLink(rs.getString("meetLink"));
            freeSlots.setCount(rs.getInt("count"));
            freeSlots.setLecturerID(rs.getString("lecturerID"));
            freeSlots.setBooked(rs.getInt("booked"));
            list.add(freeSlots);
        }
        con.close();
        return list;
    }

//    public List<FreeSlots> searchBySubjectCode1(String subjectCode, String studentID) throws SQLException {
//
//        List<FreeSlots> list = null;
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("select f.ID, f.freeSlotID, f.subjectCode, f.startTime, f.endTime, f.capacity, f.lecturerID, f.password, f.meetLink, f.count, booked\n"
//                + "from FreeSlots f\n"
//                + "left join (\n"
//                + "   select freeSlotID, COUNT(freeSlotID) as 'booked'\n"
//                + "   from Bookings b\n"
//                + "   GROUP BY freeSlotID\n"
//                + ") b on f.freeSlotID = b.freeSlotID where subjectCode = ? and studentID = ?");
//        stm.setString(1, subjectCode);
//        stm.setString(2, studentID);
//        ResultSet rs = stm.executeQuery();
//        list = new ArrayList<>();
//        while (rs.next()) {
//            FreeSlots freeSlots = new FreeSlots();
//            freeSlots.setID(rs.getInt("ID"));
//            freeSlots.setFreeSlotID(rs.getString("freeSlotID"));
//            freeSlots.setSubjectCode(rs.getString("subjectCode"));
//            freeSlots.setStartTime(rs.getDate("startTime"));
//            freeSlots.setEndTime(rs.getDate("endTime"));
//            freeSlots.setPassword(rs.getString("password"));
//            freeSlots.setCapacity(rs.getInt("capacity"));
//            freeSlots.setMeetLink(rs.getString("meetLink"));
//            freeSlots.setCount(rs.getInt("count"));
//            freeSlots.setLecturerID(rs.getString("lecturerID"));
//            freeSlots.setBooked(rs.getInt("booked"));
//            list.add(freeSlots);
//        }
//        con.close();
//        return list;
//    }

    public List<FreeSlots> searchBySubjectCode2(String subjectCode, String lecturerID) throws SQLException {

        List<FreeSlots> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select f.ID, f.freeSlotID, f.subjectCode, f.startTime, f.endTime, f.capacity, f.lecturerID, f.password, f.meetLink, f.count, booked\n"
                + "from FreeSlots f\n"
                + "left join (\n"
                + "   select freeSlotID, COUNT(freeSlotID) as 'booked'\n"
                + "   from Bookings b\n"
                + "   GROUP BY freeSlotID\n"
                + ") b on f.freeSlotID = b.freeSlotID where subjectCode = ? and lecturerID = ?");
        stm.setString(1, subjectCode);
        stm.setString(2, lecturerID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            FreeSlots freeSlots = new FreeSlots();
            freeSlots.setID(rs.getInt("ID"));
            freeSlots.setFreeSlotID(rs.getString("freeSlotID"));
            freeSlots.setSubjectCode(rs.getString("subjectCode"));
            freeSlots.setStartTime(rs.getDate("startTime"));
            freeSlots.setEndTime(rs.getDate("endTime"));
            freeSlots.setPassword(rs.getString("password"));
            freeSlots.setCapacity(rs.getInt("capacity"));
            freeSlots.setMeetLink(rs.getString("meetLink"));
            freeSlots.setCount(rs.getInt("count"));
            freeSlots.setLecturerID(rs.getString("lecturerID"));
            freeSlots.setBooked(rs.getInt("booked"));
            list.add(freeSlots);
        }
        con.close();
        return list;
    }

    public FreeSlots read(int ID) throws SQLException {
        FreeSlots freeSlots = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from FreeSlots where ID = ?");
        stm.setInt(1, ID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            freeSlots = new FreeSlots();
            freeSlots.setID(rs.getInt("ID"));
            freeSlots.setFreeSlotID(rs.getString("freeSlotID"));
            freeSlots.setSubjectCode(rs.getString("subjectCode"));
            freeSlots.setStartTime(rs.getTimestamp("startTime"));
            freeSlots.setEndTime(rs.getTimestamp("endTime"));
            freeSlots.setPassword(rs.getString("password"));
            freeSlots.setCapacity(rs.getInt("capacity"));
            freeSlots.setMeetLink(rs.getString("meetLink"));
            freeSlots.setCount(rs.getInt("count"));
            freeSlots.setLecturerID(rs.getString("lecturerID"));
        }
        con.close();
        return freeSlots;
    }

    public void create(FreeSlots freeSlots) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into FreeSlots values(?, ?, ?, ?, ?, ?, ?, ?)");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        stm.setString(1, freeSlots.getFreeSlotID());
        stm.setString(1, freeSlots.getSubjectCode());
        stm.setString(2, sdf.format(freeSlots.getStartTime()));
        stm.setString(3, sdf.format(freeSlots.getEndTime()));
        stm.setString(4, freeSlots.getPassword());
        stm.setInt(5, freeSlots.getCapacity());
        stm.setString(6, freeSlots.getMeetLink());
        stm.setInt(7, freeSlots.getCount());
        stm.setString(8, freeSlots.getLecturerID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(FreeSlots freeSlots) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update FreeSlots set subjectCode = ?,  password = ?, capacity = ?, meetLink = ?, count = ?, lecturerID = ?  where ID = ?");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        stm.setString(1, freeSlots.getSubjectCode());
//        stm.setString(2, sdf.format(freeSlots.getStartTime()));
//        stm.setString(3, sdf.format(freeSlots.getEndTime()));
        stm.setString(2, freeSlots.getPassword());
        stm.setInt(3, freeSlots.getCapacity());
        stm.setString(4, freeSlots.getMeetLink());
        stm.setInt(5, freeSlots.getCount());
        stm.setString(6, freeSlots.getLecturerID());
        stm.setInt(7, freeSlots.getID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void updateByLecturer(FreeSlots freeSlots) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update FreeSlots set subjectCode = ?, password = ?, capacity = ?, meetLink = ?, lecturerID = ?  where ID = ?");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        stm.setString(1, freeSlots.getSubjectCode());
//        stm.setString(2, sdf.format(freeSlots.getStartTime()));
//        stm.setString(3, sdf.format(freeSlots.getEndTime()));
        stm.setString(2, freeSlots.getPassword());
        stm.setInt(3, freeSlots.getCapacity());
        stm.setString(4, freeSlots.getMeetLink());
//        stm.setInt(7, freeSlots.getCount());
        stm.setString(5, freeSlots.getLecturerID());
        stm.setInt(6, freeSlots.getID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int ID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from FreeSlots where ID = ? ");
        stm.setInt(1, ID);
        int count = stm.executeUpdate();
        con.close();
    }

}
