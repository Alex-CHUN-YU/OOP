import registration_information.Course;
import registration_information.CourseSection;
import registration_information.Student;

/**
 * Base on Sequence diagrams 所設計的 GUI Test.
 * @version 1.0 2018年01月02日
 * @author ALEX-CHUN-YU
 */
class RegistrationTest {
    /**
     * This is test.
     * @param args system default
     */
    public static void main(String[] args) {
        // 上學期課程
        Course priorCourseOne = new Course("P750311", "專題討論（一）", 60 , 20);
        Course priorCourseSecond = new Course("P764600", "資料探勘", 50 , 20);

        // 這學期課程
        Course courseOne = new Course("P750321", "專題討論（二）", 2, 0);
        courseOne.setPreviousCourse(priorCourseOne);
        Course courseSecond = new Course("P75J000", "資料科學與人工智慧競技", 60 , 20);
        courseSecond.setPreviousCourse(priorCourseSecond);

        // 學生以及每位學生已經通過的課程
        Student studentOne = new Student("P76064538", "簡君聿");
        studentOne.setHistoryCourse(priorCourseOne);

        Student studentSecond = new Student("P76064539", "劉德華");
        studentSecond.setHistoryCourse(priorCourseSecond);

        Student studentThird = new Student("P76064540", "周星馳");
        studentThird.setHistoryCourse(priorCourseOne);
        studentThird.setHistoryCourse(priorCourseSecond);

        Student studentFourth = new Student("P76064559", "周杰倫");
        studentFourth.setHistoryCourse(priorCourseOne);

        // 開始進行選課
        System.out.println("****************************************************************************************");
        System.out.println("選課成功與失敗因應不同情境 Demo:");
        CourseSection courseSectionOne = new CourseSection(courseOne);
        CourseSection courseSectionSecond = new CourseSection(courseSecond);
        courseSectionOne.openRegistration();
        courseSectionSecond.openRegistration();
        // 選課成功 Demo
        courseSectionSecond.requestToRegister(studentThird);
        // 選課成功 Demo
        courseSectionOne.requestToRegister(studentOne);
        // 選課失敗 Demo
        courseSectionOne.requestToRegister(studentSecond);
        // 選課成功 Demo
        courseSectionOne.requestToRegister(studentThird);
        // 選課人數已滿 Demo
        courseSectionOne.requestToRegister(studentFourth);
        courseSectionSecond.closeRegistration();
        System.out.println("****************************************************************************************");
        System.out.println("秀出特定課程選課的學生 Demo:");
        // 秀出全部選課的學生 Demo
        courseSectionOne.getAllRegistrationOfCourse();
        courseSectionSecond.getAllRegistrationOfCourse();
        System.out.println("****************************************************************************************");
        System.out.println("秀出特定學生所有選課資訊 Demo:");
        // 秀出學生所有選上的課程 Demo
        studentThird.getAllRegistrationOfStudent();
    }
}