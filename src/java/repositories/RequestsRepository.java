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
import models.Requests;
import models.Users;
import services.Services;

/**
 *
 * @author Dell
 */
public class RequestsRepository {

    public List<Requests> select() throws SQLException {

        List<Requests> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from [dbo].[Requests]");
        list = new ArrayList<>();
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public List<Requests> selectFromStudent(String studentID) throws SQLException {

        List<Requests> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from [dbo].[Requests] where studentID = ? and (status=1 or status=0)");
        stm.setString(1, studentID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public List<Requests> selectFromStudent1(String studentID) throws SQLException {

        List<Requests> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from [dbo].[Requests] where studentID = ? and status = 2");
        stm.setString(1, studentID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public List<Requests> selectFromLecturer(String lecturerID) throws SQLException {

        List<Requests> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from [dbo].[Requests] where lecturerID = ?");
        stm.setString(1, lecturerID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public List<Requests> searchByStudentID(String studentID) throws SQLException {

        List<Requests> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from [dbo].[Requests] where studentID = ?");
        stm.setString(1, studentID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public List<Requests> searchByStudentID1(String studentID, String lecturerID) throws SQLException {

        List<Requests> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from [dbo].[Requests] where studentID = ? and lecturerID = ?");
        stm.setString(1, studentID);
        stm.setString(2, lecturerID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public List<Requests> searchByLecturerID(String lecturerID) throws SQLException {

        List<Requests> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from [dbo].[Requests] where lecturerID = ?");
        stm.setString(1, lecturerID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public List<Requests> searchByLecturerID1(String lecturerID, String studentID) throws SQLException {

        List<Requests> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from [dbo].[Requests] where lecturerID = ? and studentID = ?");
        stm.setString(1, lecturerID);
        stm.setString(2, studentID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public List<Requests> searchBySubjectCode1(String subjectCode, String studentID) throws SQLException {

        List<Requests> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from [dbo].[Requests] where subjectCode = ? and studentID = ?");
        stm.setString(1, subjectCode);
        stm.setString(2, studentID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public List<Requests> searchBySubjectCode2(String subjectCode, String lecturerID) throws SQLException {

        List<Requests> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from [dbo].[Requests] where subjectCode = ? and lecturerID = ?");
        stm.setString(1, subjectCode);
        stm.setString(2, lecturerID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public List<Requests> searchBySubjectCode(String subjectCode) throws SQLException {

        List<Requests> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from [dbo].[Requests] where subjectCode = ?");
        stm.setString(1, subjectCode);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Requests requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
            list.add(requests);
        }
        con.close();
        return list;
    }

    public Requests read(int ID) throws SQLException {
        Requests requests = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Requests where ID = ?");
        stm.setInt(1, ID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            requests = new Requests();
            requests.setID(rs.getInt("ID"));
            requests.setRequestID(rs.getString("requestID"));
            requests.setStatus(rs.getInt("status"));
            requests.setSubjectCode(rs.getString("subjectCode"));
            requests.setStartTime(rs.getTimestamp("startTime"));
            requests.setEndTime(rs.getTimestamp("endTime"));
            requests.setDescription(rs.getString("description"));
            requests.setStudentID(rs.getString("studentID"));
            requests.setLecturerID(rs.getString("lecturerID"));
            requests.setStatusText(Services.getStatusOfRequests(rs.getInt("status")));
        }
        con.close();
        return requests;
    }

    public void create(Requests requests) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Requests values(?, ?, ?, ?, ?, ?, ?)");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        stm.setInt(1, requests.getStatus());
        stm.setString(2, requests.getSubjectCode());
        stm.setString(3, sdf.format(requests.getStartTime()));
        stm.setString(4, sdf.format(requests.getEndTime()));
        stm.setString(5, requests.getDescription());
        stm.setString(6, requests.getStudentID());
        stm.setString(7, requests.getLecturerID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Requests requests) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Requests set status = ?, subjectCode = ?, description = ?, studentID = ?, lecturerID = ? where ID = ? ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        stm.setInt(1, requests.getStatus());
        stm.setString(2, requests.getSubjectCode());
//        stm.setString(3, sdf.format(requests.getStartTime()));
//        stm.setString(4, sdf.format(requests.getEndTime()));
        stm.setString(3, requests.getDescription());
        stm.setString(4, requests.getStudentID());
        stm.setString(5, requests.getLecturerID());
        stm.setInt(6, requests.getID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update1(Requests requests) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Requests set status = ? where ID = ? ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        stm.setInt(1, requests.getStatus());
//        stm.setString(2, requests.getSubjectCode());
//        stm.setString(3, sdf.format(requests.getStartTime()));
//        stm.setString(4, sdf.format(requests.getEndTime()));
//        stm.setString(5, requests.getDescription());
//        stm.setString(6, requests.getStudentID());
//        stm.setString(7, requests.getLecturerID());
        stm.setInt(2, requests.getID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int ID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from Requests where ID = ? ");
        stm.setInt(1, ID);
        int count = stm.executeUpdate();
        con.close();
    }
}
