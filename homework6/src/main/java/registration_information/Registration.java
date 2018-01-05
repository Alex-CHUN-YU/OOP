package registration_information;

/**
 * Registration.
 * @version 1.0 2018年01月01日
 * @author ALEX-CHUN-YU
 */
public class Registration {
    /**
     * Course Section.
     */
    private CourseSection courseSection;

    /**
     * Student.
     */
    private Student student;

    /**
     * Constructor(link).
     * @param courseSection courseSection
     * @param student student
     */
    Registration(CourseSection courseSection, Student student) {
        System.out.println("-------------------------------------");
        System.out.println("恭喜~選課成功!");
        student.showInformationOfStudent();
        this.courseSection = courseSection;
        this.courseSection.addToRegistrationList(this);
        this.student = student;
        this.student.addToSchedule(this);
        System.out.println("以下為你的選課資訊:");
        courseSection.course.showInformationOfCourse();
    }

    /**
     * Unregister Student.
     */
    public void unregisterStudent() {
        student.removeToSchedule(this);
    }

    /**
     * Show Registration Information.
     */
    public void showInformationOfRegistration() {
        System.out.print("學號:" + student.getStudentID());
        System.out.print(" 學生:" + student.getStudentName());
        System.out.print(" 課程編號:" + courseSection.course.getCourseID());
        System.out.println(" 課程名稱:" + courseSection.course.getCourseName());
    }
}
