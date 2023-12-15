/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Semesters;
import models.Timetables;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import repositories.SemestersRepository;
import repositories.TimetablesRepository;
import services.TimetablesService;

/**
 *
 * @author Dell
 */
@WebServlet(name = "TimetablesController", urlPatterns = {"/timetables"})
public class TimetablesController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;

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
            case "listOfStudent": {
                listOfStudent(request, response);
                break;
            }
            case "listOfLecturer": {
                listOfLecturer(request, response);
                break;
            }

            case "update": {
                update(request, response);
                break;
            }

            case "update_handler": {
                update_handler(request, response);
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

            case "readExcel": {
                readExcel(request, response);
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
            TimetablesRepository ttr = new TimetablesRepository();
            List<Timetables> list = ttr.select();
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
            TimetablesRepository ttr = new TimetablesRepository();
            List<Timetables> list = ttr.select();
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
            TimetablesRepository ttr = new TimetablesRepository();
            HttpSession session = request.getSession();
            String lecturerID = (String) session.getAttribute("userID");
            List<Timetables> list = ttr.selectByLecturer(lecturerID);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TimetablesRepository ttr = new TimetablesRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create": {
                try {
                    String subjectCode = request.getParameter("subjectCode");
                    String slotID = request.getParameter("slotID");
                    String lecturerID = request.getParameter("lecturerID");
                    String semesterID = request.getParameter("semesterID");
                    Timetables timetables = new Timetables(subjectCode, slotID, lecturerID, semesterID);
                    request.setAttribute("timetables", timetables);
                    ttr.create(timetables);
                    response.sendRedirect(request.getContextPath() + "/timetables/list.do");
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
                response.sendRedirect(request.getContextPath() + "/timetables/list.do");
                break;
            }
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TimetablesRepository ttr = new TimetablesRepository();
        try {
            String subjectCode = request.getParameter("subjectCode");
            String slotID = request.getParameter("slotID");
            String lecturerID = request.getParameter("lecturerID");
            String semesterID = request.getParameter("semesterID");
            Timetables timetables = ttr.read(subjectCode, slotID, lecturerID, semesterID);
            request.setAttribute("timetables", timetables);
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
        TimetablesRepository ttr = new TimetablesRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    String subjectCode = request.getParameter("subjectCode");
                    String slotID = request.getParameter("slotID");
                    String lecturerID = request.getParameter("lecturerID");
                    String semesterID = request.getParameter("semesterID");
                    Timetables timetables = new Timetables(subjectCode, slotID, lecturerID, semesterID);
                    request.setAttribute("timetables", timetables);
                    ttr.update(timetables);
                    response.sendRedirect(request.getContextPath() + "/timetables/list.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/timetables/list.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TimetablesRepository ttr = new TimetablesRepository();
        try {
            String subjectCode = request.getParameter("subjectCode");
            String slotID = request.getParameter("slotID");
            String lecturerID = request.getParameter("lecturerID");
            String semesterID = request.getParameter("semesterID");
            ttr.delete(subjectCode, slotID, lecturerID, semesterID);
            response.sendRedirect(request.getContextPath() + "/timetables/list.do");
//            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void readExcel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        CheckInRepository cir = new CheckInRepository();
        TimetablesService tts = new TimetablesService();
        TimetablesRepository ttr = new TimetablesRepository();
        SemestersRepository sr = new SemestersRepository();
        HttpSession session = request.getSession();
        String op = request.getParameter("op");
        Date now = new Date();
        switch (op) {
            case "readExcel":
                try {
                    String fileName = request.getParameter("fileName");
                    if (!fileName.equals("")) {
                        File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
                        String EXCEL_FILE_PATH = file.getAbsolutePath();
                        Semesters sem = sr.read1(now);
                        System.out.println(sem.getSemesterID());
                        String semesterID = sem.getSemesterID();
                        System.out.println(semesterID);
                        String lecturerID = (String) session.getAttribute("userID");
                        System.out.println(lecturerID);
                        List<Timetables> list = tts.readExcel(lecturerID, semesterID, EXCEL_FILE_PATH);
                        for (Timetables t : list) {
                            Timetables tt = new Timetables(t.getSubjectCode(), t.getSlotID(), t.getLecturerID(), t.getSemesterID());
                            System.out.println(tt);
                            ttr.create(tt);
                        }
                        String roleID = (String) session.getAttribute("roleID");
                        if (roleID.equals("1")) {
                            response.sendRedirect(request.getContextPath() + "/timetables/list.do");
                        }
                        if (roleID.equals("2 ")) {
                            response.sendRedirect(request.getContextPath() + "/timetables/listOfLecturer.do");
                        }
                        if (roleID.equals("3 ")) {
                            response.sendRedirect(request.getContextPath() + "/timetables/listOfStudent.do");
                        }
//                        response.sendRedirect(request.getContextPath() + "/timetables/list.do");
                    } else {
                        request.setAttribute("message", "Please choose your file!!!");
                        String roleID = (String) session.getAttribute("roleID");
                        if (roleID.equals("1")) {
                            request.getRequestDispatcher("/timetables/list.do").forward(request, response);
                        }
                        if (roleID.equals("2 ")) {
                            request.getRequestDispatcher("/timetables/listOfLecturer.do").forward(request, response);
                        }
                        if (roleID.equals("3 ")) {
                            request.getRequestDispatcher("/timetables/listOfStudent.do").forward(request, response);
                        }
                        request.getRequestDispatcher("/timetables/listOfLecturer.do").forward(request, response);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("message", e.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            default:
                break;
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
    public void init() throws ServletException {
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
    }

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
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new ServletException("Content type is not multipart/form-data");
        }
        TimetablesService tts = new TimetablesService();
        TimetablesRepository ttr = new TimetablesRepository();
        SemestersRepository sr = new SemestersRepository();
        HttpSession session = request.getSession();
        String op = request.getParameter("op");
        Date now = new Date();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

//        out.write("<html><head></head><body>");
        try {

            List<FileItem> fileItemsList = uploader.parseRequest(request);
//            System.out.println("fileItemsList:" + fileItemsList);
            if (fileItemsList != null) {
                Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
                System.out.println("fileItemsIterator:" + fileItemsIterator);
                while (fileItemsIterator.hasNext()) {
                    FileItem fileItem = fileItemsIterator.next();
                    System.out.println("FieldName=" + fileItem.getFieldName());
                    System.out.println("FileName=" + fileItem.getName());
                    System.out.println("ContentType=" + fileItem.getContentType());
                    System.out.println("Size in bytes=" + fileItem.getSize());
                    File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileItem.getName());
                    System.out.println("Absolute Path at server=" + file.getAbsolutePath());
                    fileItem.write(file);
//                request.setAttribute("message", "Upload successfully");
                    if (!fileItem.getName().equals(null)) {
//                        out.write("File " + fileItem.getName() + " uploaded successfully.");
////                request.getRequestDispatcher("/checkIn/listOf.do").forward(request, response);
//                        out.write("<br>");
//                        out.write("<a href=\"index.do" + "\">Back" + "</a>");
//                out.write("<br>");
//                out.write("<a href=\"downloadFile.do?fileName=" + fileItem.getName() + "\">Download " + fileItem.getName() + "</a>");

//                        String fileName = request.getParameter("fileName");
//                        File file1 = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
                        String EXCEL_FILE_PATH = file.getAbsolutePath();
                        System.out.println(EXCEL_FILE_PATH);
                        Semesters sem = sr.read1(now);
                        System.out.println(sem.getSemesterID());
                        String semesterID = sem.getSemesterID();
                        System.out.println(semesterID);
                        String lecturerID = (String) session.getAttribute("userID");
                        System.out.println(lecturerID);
                        List<Timetables> list = tts.readExcel(lecturerID, semesterID, EXCEL_FILE_PATH);
                        System.out.println("jvdjvjdnvdnv");
                        for (Timetables t : list) {
                            Timetables tt = new Timetables(t.getSubjectCode(), t.getSlotID(), t.getLecturerID(), t.getSemesterID());
                            System.out.println(tt);
                            ttr.create(tt);
                        }
                        String roleID = (String) session.getAttribute("roleID");
                        if (roleID.equals("1")) {
                            response.sendRedirect(request.getContextPath() + "/timetables/list.do");
                        }
                        if (roleID.equals("2 ")) {
                            response.sendRedirect(request.getContextPath() + "/timetables/listOfLecturer.do");
                        }
                        if (roleID.equals("3 ")) {
                            response.sendRedirect(request.getContextPath() + "/timetables/listOfStudent.do");
                        }
//                        response.sendRedirect(request.getContextPath() + "/timetables/list.do");
//                        } else {
//                            request.setAttribute("message", "Please choose your file!!!");
//                            String roleID = (String) session.getAttribute("roleID");
//                            if (roleID.equals("1")) {
//                                request.getRequestDispatcher("/timetables/list.do").forward(request, response);
//                            }
//                            if (roleID.equals("2 ")) {
//                                request.getRequestDispatcher("/timetables/listOfLecturer.do").forward(request, response);
//                            }
//                            if (roleID.equals("3 ")) {
//                                request.getRequestDispatcher("/timetables/listOfStudent.do").forward(request, response);
//                            }
//                            request.getRequestDispatcher("/timetables/listOfLecturer.do").forward(request, response);
//                        }

                    }

                }
            } else {
                request.setAttribute("message", "Please choose your file!!!");
//                request.getRequestDispatcher("/uploadDowloadFile/index.do").forward(request, response);
                request.getRequestDispatcher("/timetables/listOfLecturer.do").forward(request, response);

            }

        } catch (FileUploadException e) {
            out.write("Exception in uploading file.");
            out.write("<br>");
            out.write("<a href=\"listOfLecturer.do" + "\">Back" + "</a>");
            e.printStackTrace();
        } catch (Exception e) {
            out.write("Exception in uploading file.");
            out.write("<br>");
            out.write("<a href=\"listOfLecturer.do" + "\">Back" + "</a>");
            e.printStackTrace();
        }
//        out.write("</body></html>");
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
