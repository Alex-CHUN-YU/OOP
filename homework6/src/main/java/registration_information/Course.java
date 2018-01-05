package registration_information;

/**
 * Course Class.
 * @version 1.0 2018年01月01日
 * @author ALEX-CHUN-YU
 */
public class Course {
    /**
     * Course ID.
     */
    private String courseID;

    /**
     * Course Name.
     */
    private String courseName;

    /**
     * Course Maximum Number.
     */
    private int maximum;

    /**
     * Course Minimum Number.
     */
    private int minimum;

    /**
     * Course.
     */
    private Course course;

    /**
     * Constructor.
     * @param courseID courseID
     * @param courseName courseName
     * @param maximum maximum
     * @param minimum minimum
     */
    public Course(String courseID, String courseName, int maximum, int minimum) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.maximum = maximum;
        this.minimum = minimum;
    }

    /**
     * Get Course ID.
     * @return courseID course id
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Get Course Name.
     * @return courseName course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Get Course Maximum Number.
     */
    public int getMaximum() {
        return maximum;
    }

    /**
     * Get Course Minimum Number.
     */
    public int getMinimum() {
        return minimum;
    }

    /**
     * Get Pre Requisite.
     */
    public Course getPrerequisite() {
        return this;
    }

    /**
     * Get Previously Course.
     */
    public void setPreviousCourse(Course course) {
        this.course = course;
    }

    /**
     * Get Previously Course.
     */
    public Course getPreviousCourse() {
        return this.course;
    }

    /**
     * Show Course Information.
     */
    public void showInformationOfCourse() {
        System.out.print("課號:" + this.getCourseID());
        System.out.print(" 課名:" + this.getCourseName());
        System.out.print(" 上限人數:" + this.getMaximum());
        System.out.println(" 開課要求人數:" + this.getMinimum());
        //System.out.println("-------------------------------");
    }
}
