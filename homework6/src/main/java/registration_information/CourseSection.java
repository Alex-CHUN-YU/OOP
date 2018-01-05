package registration_information;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Course Section.
 * @version 1.0 2018年01月01日
 * @author ALEX-CHUN-YU
 */
public class CourseSection {
    /**
     * Registration List.
     */
    private ArrayList<Registration> registrationList;

    /**
     * Registration Course.
     */
    public Course course;

    /**
     * Open Course Registration Flag.
     */
    private boolean open = false;

    /**
     * Closed Or Canceled Course Registration Flag.
     */
    private boolean closedOrCanceled = false;

    /**
     * Constructor.
     */
    public CourseSection(Course course) {
        this.course = course;
        registrationList = new ArrayList<Registration>();
    }

    /**
     * Open Course Registration.
     */
    public void openRegistration() {
        if(!closedOrCanceled) {
            open = true;
        }
    }

    /**
     * Closed Course Registration.
     */
    public void closeRegistration() {
        open = false;
        closedOrCanceled = true;
        if (registrationList.size() < course.getMinimum()) {
            System.out.println("-------------------------------------");
            course.showInformationOfCourse();
            System.out.println("開課人數不足! 此課已取消原本有選上之學生~");
            unregisterStudents();
        }
    }

    /**
     * Canceled Course Registration.
     */
    public void cancel() {
        open = false;
        closedOrCanceled = true;
        unregisterStudents();
    }

    /**
     * Unregister Students.
     */
    private void unregisterStudents() {
        Iterator it = registrationList.iterator();
        while (it.hasNext()) {
            Registration r = (Registration)it.next();
            r.unregisterStudent();
            it.remove();
        }
    }

    /**
     * Request To Register.
     * @param student student
     */
    public void requestToRegister(Student student) {
        if (open) {
            Course prereq = course.getPrerequisite();
            if (student.hasPassedCourse(prereq)) {
                new Registration(this, student);
            } else {
                System.out.println("-------------------------------------");
                System.out.println("選課失敗!");
                student.showInformationOfStudent();
                System.out.println("此課程建議先修課程:");
                course.getPreviousCourse().showInformationOfCourse();
            }
            // Course Full, Check for automatic transition to 'Closed' state.
            if (registrationList.size() >= course.getMaximum()) {
                open = false;
                closedOrCanceled = true;
            }
        } else {
            System.out.println("-------------------------------------");
            course.showInformationOfCourse();
            System.out.print("此課程已滿 !!");
            student.showInformationOfStudent();
        }
    }

    /**
     * Add To Registration List(link).
     * @param registrationOne book one
     */
    void addToRegistrationList(Registration registrationOne) {
        registrationList.add(registrationOne);
    }

    /**
     * Get All Registration Of Course.
     */
    public void getAllRegistrationOfCourse() {
        System.out.println("-------------------------------------");
        course.showInformationOfCourse();
        Iterator<Registration> iterator = registrationList.iterator();
        while (iterator.hasNext()) {
            iterator.next().showInformationOfRegistration();
        }
        if (registrationList.size() == 0) {
            System.out.println("由於此課程人數不足! 故開課失敗~");
        }
    }
}
