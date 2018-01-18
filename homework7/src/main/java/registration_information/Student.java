package registration_information;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Students Class.
 * @version 1.0 2018年01月07日
 * @author ALEX-CHUN-YU
 */
public class Student {
    /**
     * Registrations List.
     */
    private ArrayList<Registration> registrationList = new ArrayList<Registration>();

    /**
     * Student ID.
     */
    private String studentID;

    /**
     * Student Name.
     */
    private String studentName;

    /**
     * Special Permission.
     */
    private boolean hasPermission = false;

    /**
     * History Course List.
     */
    private ArrayList<Course> historyCourses = new ArrayList<Course>();

    /**
     * Constructor.
     * @param studentID studentID
     * @param studentName studentName
     */
    public Student(String studentID, String studentName, boolean hasPermission) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.hasPermission = hasPermission;
    }

    /**
     * Get Student ID.
     * @return studentID student id
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Get Student Name.
     * @return studentName student name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Add To Schedule(link).
     * @param registrationOne registration One
     */
    void addToSchedule(Registration registrationOne) {
        registrationList.add(registrationOne);
    }

    /**
     * Remove To Schedule(link).
     * @param registrationOne registration One
     */
    void removeToSchedule(Registration registrationOne) {
        registrationList.remove(registrationOne);
    }

    /**
     * Check Special Permission.
     */
    public boolean checkSpecialPermission() {
        return hasPermission;
    }

    /**
     * Has Passed Course Of Student(association).
     */
    public boolean hasPassedCourse(Course course) {
        return this.getHistoryCourse().contains(course.getPreviousCourse());
    }

    /**
     * Has Passed Course Of Student(association).
     */
    public void setHistoryCourse(Course course) {
        historyCourses.add(course);
    }

    /**
     * Has Passed Course History Of Student.
     */
    public ArrayList<Course> getHistoryCourse() {
        return historyCourses;
    }

    /**
     * Get All Registration Of Student.
     */
    public void getAllRegistrationOfStudent() {
        this.showInformationOfStudent();
        Iterator<Registration> iterator = registrationList.iterator();
        while (iterator.hasNext()) {
            iterator.next().showInformationOfRegistration();
        }
    }

    /**
     * Show Student Information.
     */
    public void showInformationOfStudent() {
        System.out.print("學號:" + this.getStudentID());
        System.out.print(" 學生:" + this.getStudentName());
        System.out.println(" 特殊選課權限:" + this.checkSpecialPermission());
        //System.out.println("-------------------------------");
    }
}
