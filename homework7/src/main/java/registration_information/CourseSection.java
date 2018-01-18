package registration_information;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Registration Verify Thread.
 * @version 1.0 2018年01月06日
 * @author ALEX-CHUN-YU
 */
class RegistrationVerifyThread extends Thread {
    /**
     * Thread Function Name.
     */
    private String threadName;

    /**
     * Course Section.
     */
    private CourseSection  courseSection;

    /**
     * Constructor.
     * @param name function name
     * @param courseSection course section
     */
    RegistrationVerifyThread(String name, CourseSection courseSection) {
        this.threadName = name;
        this.courseSection = courseSection;
    }

    /**
     * Thread Run And Synchronization.
     */
    public void run() {
        System.out.println("Starting " +  threadName + " thread");
        synchronized(courseSection) {
            if (threadName.equals(ConstantField.VERIFY_COURSE_NOT_FULL)) {
                courseSection.verifyCourseNotFull();
            } if (threadName.equals(ConstantField.CHECK_PREREQUISITES)) {
                courseSection.checkPrerequisites();
            }
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
}

/**
 * Course Section.
 * @version 1.0 2018年01月06日
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
     * Has Prerequisites Flag.
     */
    private boolean hasPrereqs = false;

    /**
     * Open Course Registration Flag.
     */
    private boolean open = false;

    /**
     * Student.
     */
    private Student student;

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
        this.student = student;
        Thread threadOne = new RegistrationVerifyThread(ConstantField.VERIFY_COURSE_NOT_FULL, this);
        Thread threadSecond = new RegistrationVerifyThread(ConstantField.CHECK_PREREQUISITES, this);
        threadOne.start();
        threadSecond.start();
        // wait for threads to end
        try {
            threadOne.join();
            threadSecond.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
        if (open) {
            if (hasPrereqs) {
                new Registration(this, student);
            } else {
                System.out.println("選課失敗!");
                student.showInformationOfStudent();
                System.out.println("此課程建議先修課程:");
                course.getPreviousCourse().showInformationOfCourse();
            }
        } else {
            course.showInformationOfCourse();
            System.out.print("此課程已滿 !!");
            student.showInformationOfStudent();
        }
    }

    /**
     * Check Prerequisites.
     */
    void checkPrerequisites() {
        Course prereq = course.getPrerequisite();
        hasPrereqs = student.hasPassedCourse(prereq);
        if (!hasPrereqs) {
            hasPrereqs = student.checkSpecialPermission();
        }
    }

    /**
     * Verify Course Not Null.
     */
    void verifyCourseNotFull() {
        if (registrationList.size() >= course.getMaximum()) {
            open = false;
            closedOrCanceled = true;
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
