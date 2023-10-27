/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.FreeSlots;
import models.Semesters;
import repositories.FreeSlotsRepository;
import repositories.SemestersRepository;
import services.Services;

/**
 *
 * @author Dell
 */
@WebServlet(name = "FreeSlotsController", urlPatterns = {"/freeSlots"})
public class FreeSlotsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        switch (action) {

            case "list": {
                list(request, response);
                break;
            }

            case "listOfLecturer": {
                listOfLecturer(request, response);
                break;
            }

            case "listOfStudent": {
                listOfStudent(request, response);
                break;
            }

            case "search":
                try {

                    search(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("message", e.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;

            case "searchByStudent":
                try {
                    searchByStudent(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("message", e.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;

            case "searchByLecturer":
                try {
                    searchByLecturer(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("message", e.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;

            case "update": {
                update(request, response);
                break;
            }

            case "updateByLecturer": {
                updateByLecturer(request, response);
                break;
            }

            case "update_handler": {
                update_handler(request, response);
                break;
            }

            case "update_handlerByLecturer": {
                update_handlerByLecturer(request, response);
                break;
            }

            case "create": {
                create(request, response);
                break;
            }

            case "create_handler": {
                create_handler(request, response);
                break;
            }

            case "delete": {
                delete(request, response);
                break;
            }

            default: {
                break;
            }

        }
    }

    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            FreeSlotsRepository fsr = new FreeSlotsRepository();
            List<FreeSlots> list = fsr.select();
            HttpSession session = request.getSession();
            List<FreeSlots> listSearch = (List<FreeSlots>) session.getAttribute("listSearch");
            if (listSearch != null && !listSearch.isEmpty()) {
                list = listSearch;
            }
            request.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void listOfStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            FreeSlotsRepository fsr = new FreeSlotsRepository();
            List<FreeSlots> list = fsr.select();
            HttpSession session = request.getSession();
            List<FreeSlots> listSearch = (List<FreeSlots>) session.getAttribute("listSearch");
            if (listSearch != null && !listSearch.isEmpty()) {
                list = listSearch;
            }
            request.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void listOfLecturer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            FreeSlotsRepository fsr = new FreeSlotsRepository();
            HttpSession session = request.getSession();
            String lecturerID = (String) session.getAttribute("userID");
            List<FreeSlots> list = fsr.selectFromLecturer(lecturerID);
            List<FreeSlots> listSearch = (List<FreeSlots>) session.getAttribute("listSearch");
            if (listSearch != null && !listSearch.isEmpty()) {
                list = listSearch;
            }
            request.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        HttpSession session = request.getSession();
        String select = request.getParameter("select");
        System.out.println("Select:" + select);
        switch (select) {
            case "subjectCode": {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String semester = (String) request.getParameter("semester");
                    String subjectCode = (String) request.getParameter("ID");
                    FreeSlotsRepository fsr = new FreeSlotsRepository();
                    SemestersRepository sr = new SemestersRepository();
                    List<FreeSlots> listSearch = fsr.searchBySubjectCode(subjectCode);
                    List<FreeSlots> listSearchBySC = new ArrayList<>();
                    List<Semesters> listSemester = sr.select();
                    for (Semesters s : listSemester) {
                        System.out.println("Semester: " + semester);
                        if (semester.equals(s.getSemesterID())) {
                            for (FreeSlots fs : listSearch) {
                                if (fs.getStartTime().compareTo(s.getStartDay()) >= 0 && fs.getEndTime().compareTo(s.getEndDay()) <= 0) {
                                    listSearchBySC.add(fs);
                                    session.setAttribute("listSearch", listSearchBySC);
                                    System.out.println(fs.getStartTime());
                                } else {
                                    System.out.println("no");
                                }
                            }
                        } else {
                            System.out.println("NO RESULTS");
                        }
                    }
                    if (listSearchBySC.isEmpty()) {
                        System.out.println("Empty");
                        request.setAttribute("msg", "NO RESULTS");
                        request.getRequestDispatcher("/freeSlots/list.do").forward(request, response);
                    } else {
                        System.out.println("listSearch" + listSearchBySC);
                        response.sendRedirect(request.getContextPath() + "/freeSlots/list.do");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }

            case "lecturer": {
                try {
                    String lecturerID = (String) request.getParameter("ID");
                    String semester = (String) request.getParameter("semester");
                    SemestersRepository sr = new SemestersRepository();
                    FreeSlotsRepository fsr = new FreeSlotsRepository();
                    List<FreeSlots> listSearch = fsr.searchByLecturerID(lecturerID);
                    List<FreeSlots> listSearchByL = new ArrayList<>();
                    List<Semesters> listSemester = sr.select();
                    for (Semesters s : listSemester) {
                        if (semester.equals(s.getSemesterID())) {
                            for (FreeSlots fs : listSearch) {
                                if (fs.getStartTime().compareTo(s.getStartDay()) >= 0 && fs.getEndTime().compareTo(s.getEndDay()) <= 0) {
                                    listSearchByL.add(fs);
                                    session.setAttribute("listSearch", listSearchByL);

                                } else {
                                    System.out.println("Min Min");
                                }
                            }
                        } else {
                            System.out.println("Son Son");
                        }
                    }
                    if (listSearchByL.isEmpty()) {
                        System.out.println("Empty");
                        request.setAttribute("msg", "NO RESULTS");
                        request.getRequestDispatcher("/freeSlots/list.do").forward(request, response);
                    } else {
                        System.out.println("listSearch" + listSearchByL);
                        response.sendRedirect(request.getContextPath() + "/freeSlots/list.do");
                    }

                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }
            default: {
            }
            break;
        }
        request.setAttribute("select", select);

    }

     protected void searchByStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        HttpSession session = request.getSession();
        String select = request.getParameter("select");
        System.out.println("Select:" + select);
        switch (select) {
            case "subjectCode": {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String semester = (String) request.getParameter("semester");
                    String subjectCode = (String) request.getParameter("ID");
                    FreeSlotsRepository fsr = new FreeSlotsRepository();
                    SemestersRepository sr = new SemestersRepository();
                    List<FreeSlots> listSearch = fsr.searchBySubjectCode(subjectCode);
                    List<FreeSlots> listSearchBySC = new ArrayList<>();
                    List<Semesters> listSemester = sr.select();
                    for (Semesters s : listSemester) {
                        System.out.println("Semester: " + semester);
                        if (semester.equals(s.getSemesterID())) {
                            for (FreeSlots fs : listSearch) {
                                if (fs.getStartTime().compareTo(s.getStartDay()) >= 0 && fs.getEndTime().compareTo(s.getEndDay()) <= 0) {
                                    listSearchBySC.add(fs);
                                    session.setAttribute("listSearch", listSearchBySC);
                                    System.out.println(fs.getStartTime());
                                } else {
                                    System.out.println("no");
                                }
                            }
                        } else {
                            System.out.println("NO RESULTS");
                        }
                    }
                    if (listSearchBySC.isEmpty()) {
                        System.out.println("Empty");
                        request.setAttribute("msg", "NO RESULTS");
                        request.getRequestDispatcher("/freeSlots/listOfStudent.do").forward(request, response);
                    } else {
                        System.out.println("listSearch" + listSearchBySC);
                        response.sendRedirect(request.getContextPath() + "/freeSlots/listOfStudent.do");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }

            case "lecturer": {
                try {
                    String lecturerID = (String) request.getParameter("ID");
                    String semester = (String) request.getParameter("semester");
                    SemestersRepository sr = new SemestersRepository();
                    FreeSlotsRepository fsr = new FreeSlotsRepository();
                    List<FreeSlots> listSearch = fsr.searchByLecturerID(lecturerID);
                    List<FreeSlots> listSearchByL = new ArrayList<>();
                    List<Semesters> listSemester = sr.select();
                    for (Semesters s : listSemester) {
                        if (semester.equals(s.getSemesterID())) {
                            for (FreeSlots fs : listSearch) {
                                if (fs.getStartTime().compareTo(s.getStartDay()) >= 0 && fs.getEndTime().compareTo(s.getEndDay()) <= 0) {
                                    listSearchByL.add(fs);
                                    session.setAttribute("listSearch", listSearchByL);

                                } else {
                                    System.out.println("Min Min");
                                }
                            }
                        } else {
                            System.out.println("Son Son");
                        }
                    }
                    if (listSearchByL.isEmpty()) {
                        System.out.println("Empty");
                        request.setAttribute("msg", "NO RESULTS");
                        request.getRequestDispatcher("/freeSlots/listOfStudent.do").forward(request, response);
                    } else {
                        System.out.println("listSearch" + listSearchByL);
                        response.sendRedirect(request.getContextPath() + "/freeSlots/listOfStudent.do");
                    }

                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }
            default: {
            }
            break;
        }
        request.setAttribute("select", select);

    }

//    
    protected void searchByLecturer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        HttpSession session = request.getSession();
        String select = request.getParameter("select");
        System.out.println("Select:" + select);
        switch (select) {
            case "subjectCode": {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String semester = (String) request.getParameter("semester");
                    String subjectCode = (String) request.getParameter("ID");
                    String lecturerID = (String) session.getAttribute("userID");
                    FreeSlotsRepository fsr = new FreeSlotsRepository();
                    SemestersRepository sr = new SemestersRepository();
                    List<FreeSlots> listSearch = fsr.searchBySubjectCode2(subjectCode, lecturerID);
                    List<FreeSlots> listSearchBySC = new ArrayList<>();
                    List<Semesters> listSemester = sr.select();
                    for (Semesters s : listSemester) {
                        System.out.println("Semester: " + semester);
                        if (semester.equals(s.getSemesterID())) {
                            for (FreeSlots fs : listSearch) {
                                if (fs.getStartTime().compareTo(s.getStartDay()) >= 0 && fs.getEndTime().compareTo(s.getEndDay()) <= 0) {
                                    listSearchBySC.add(fs);
                                    session.setAttribute("listSearch", listSearchBySC);
                                    System.out.println(fs.getStartTime());
                                } else {
                                    System.out.println("no");
                                }
                            }
                        } else {
                            System.out.println("NO RESULTS");
                        }
                    }
                    if (listSearchBySC.isEmpty()) {
                        System.out.println("Empty");
                        request.setAttribute("msg", "NO RESULTS");
                        request.getRequestDispatcher("/freeSlots/listOfLecturer.do").forward(request, response);
                    } else {
                        System.out.println("listSearch" + listSearchBySC);
                        response.sendRedirect(request.getContextPath() + "/freeSlots/listOfLecturer.do");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }

            default: {
                break;
            }

        }
        request.setAttribute("select", select);

    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FreeSlotsRepository fsr = new FreeSlotsRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create": {
                try {
                    String subjectCode = request.getParameter("subjectCode");
//                    Date day = Services.sdfDate.parse(request.getParameter("day"));
//                    Date start = Services.sdfTime.parse(request.getParameter("start"));
                    String day = request.getParameter("day");
                    String start = request.getParameter("start");
                    String startTime1 = day + " " + start;
                    Date startTime = Services.sdfDateTime.parse(startTime1);
//                    Date end = Services.sdfTime.parse(request.getParameter("end"));
                    String end = request.getParameter("end");
                    String endTime1 = day + " " + end;
                    Date endTime = Services.sdfDateTime.parse(endTime1);
                    String password = request.getParameter("password");
                    int capacity = Integer.parseInt(request.getParameter("capacity"));
                    String meetLink = request.getParameter("meetLink");
                    int count = Integer.parseInt(request.getParameter("count"));
                    String lecturerID = request.getParameter("lecturerID");
                    FreeSlots freeSlots = new FreeSlots(subjectCode, startTime, endTime, password, capacity, meetLink, count, lecturerID);
                    request.setAttribute("freeSlots", freeSlots);
                    fsr.create(freeSlots);
                    response.sendRedirect(request.getContextPath() + "/freeSlots/listOfLecturer.do");
                } catch (Exception ex) {
                    //Hiện lại create form để nhập lại dữ liệu
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "create");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }

            case "cancel": {
                response.sendRedirect(request.getContextPath() + "/freeSlots/listOfLecturer.do");
                break;
            }
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FreeSlotsRepository fsr = new FreeSlotsRepository();
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            FreeSlots freeSlots = fsr.read(ID);
            request.setAttribute("freeSlots", freeSlots);
            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void updateByLecturer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FreeSlotsRepository fsr = new FreeSlotsRepository();
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            FreeSlots freeSlots = fsr.read(ID);
            request.setAttribute("freeSlots", freeSlots);
            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void update_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FreeSlotsRepository fsr = new FreeSlotsRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    int ID = Integer.parseInt(request.getParameter("ID"));
                    String subjectCode = request.getParameter("subjectCode");
//                    Date day = Services.sdfDate.parse(request.getParameter("day"));
//                    Date start = Services.sdfTime.parse(request.getParameter("start"));
//                    String day = request.getParameter("day");
//                    String start = request.getParameter("start");
//                    String startTime1 = day + " " + start;
//                    Date startTime = Services.sdfDateTime.parse(startTime1);
////                    Date end = Services.sdfTime.parse(request.getParameter("end"));
//                    String end = request.getParameter("end");
//                    String endTime1 = day + " " + end;
//                    Date endTime = Services.sdfDateTime.parse(endTime1);
                    String password = request.getParameter("password");
                    int capacity = Integer.parseInt(request.getParameter("capacity"));
                    String meetLink = request.getParameter("meetLink");
                    int count = Integer.parseInt(request.getParameter("count"));
                    String lecturerID = request.getParameter("lecturerID");
                    FreeSlots freeSlots = new FreeSlots(ID, subjectCode, password, capacity, meetLink, count, lecturerID);
                    request.setAttribute("freeSlots", freeSlots);
                    fsr.update(freeSlots);
                    response.sendRedirect(request.getContextPath() + "/freeSlots/list.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/freeSlots/list.do");
        }
    }

    protected void update_handlerByLecturer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FreeSlotsRepository fsr = new FreeSlotsRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    int ID = Integer.parseInt(request.getParameter("ID"));
                    String subjectCode = request.getParameter("subjectCode");
////                    Date day = Services.sdfDate.parse(request.getParameter("day"));
////                    Date start = Services.sdfTime.parse(request.getParameter("start"));
//                    String day = request.getParameter("day");
//                    String start = request.getParameter("start");
//                    String startTime1 = day + " " + start;
//                    Date startTime = Services.sdfDateTime.parse(startTime1);
////                    Date end = Services.sdfTime.parse(request.getParameter("end"));
//                    String end = request.getParameter("end");
//                    String endTime1 = day + " " + end;
//                    Date endTime = Services.sdfDateTime.parse(endTime1);
                    String password = request.getParameter("password");
                    int capacity = Integer.parseInt(request.getParameter("capacity"));
                    String meetLink = request.getParameter("meetLink");
//                    int count = Integer.parseInt(request.getParameter("count"));
                    String lecturerID = request.getParameter("lecturerID");
                    FreeSlots freeSlots = new FreeSlots(ID, subjectCode, password, capacity, meetLink, lecturerID);
                    request.setAttribute("freeSlots", freeSlots);
                    fsr.updateByLecturer(freeSlots);
                    response.sendRedirect(request.getContextPath() + "/freeSlots/listOfLecturer.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/freeSlots/listOfLecturer.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FreeSlotsRepository fsr = new FreeSlotsRepository();
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            fsr.delete(ID);
            HttpSession session = request.getSession();
            String roleID = (String) session.getAttribute("roleID");
            if (roleID.equals("1")) {
                response.sendRedirect(request.getContextPath() + "/freeSlots/list.do");
            }
            if (roleID.equals("2 ")) {
                response.sendRedirect(request.getContextPath() + "/freeSlots/listOfLecturer.do");
            }
//            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
