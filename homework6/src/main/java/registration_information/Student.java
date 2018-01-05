package registration_information;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Students Class.
 * @version 1.0 2018年01月01日
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
     * History Course List.
     */
    private ArrayList<Course> historyCourses = new ArrayList<Course>();

    /**
     * Constructor.
     * @param studentID studentID
     * @param studentName studentName
     */
    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
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
        System.out.println(" 學生:" + this.getStudentName());
        //System.out.println("-------------------------------");
    }
}
