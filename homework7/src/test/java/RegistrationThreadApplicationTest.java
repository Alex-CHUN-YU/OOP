import registration_information.Course;
import registration_information.CourseSection;
import registration_information.Student;

/**
 * Registration Thread Application Test Base On Activity Diagrams.
 * @version 1.0 2018年01月07日
 * @author ALEX-CHUN-YU
 */
class RegistrationThreadApplicationTest {
    /**
     * This Is Multi Thread Test.
     * @param args system default
     */
    public static void main(String[] args) {
        // 上學期課程
        Course priorCourseOne = new Course("P750311", "專題討論（一）", 60 , 20);
        Course priorCourseSecond = new Course("P764600", "資料探勘", 50 , 20);

        // 這學期課程
        Course courseOne = new Course("P750321", "專題討論（二）", 2, 1);
        courseOne.setPreviousCourse(priorCourseOne);
        Course courseSecond = new Course("P75J000", "資料科學與人工智慧競技", 60 , 20);
        courseSecond.setPreviousCourse(priorCourseSecond);

        // 學生以及每位學生已經通過的課程
        Student studentOne = new Student("P76064538", "蠟筆小新", false);
        studentOne.setHistoryCourse(priorCourseOne);

        Student studentSecond = new Student("P76064539", "阿兩", false);
        studentSecond.setHistoryCourse(priorCourseSecond);

        Student studentThird = new Student("P76064540", "陳妍希", true);
        studentThird.setHistoryCourse(priorCourseOne);

        Student studentFourth = new Student("P76064559", "簡君聿", true);
        studentFourth.setHistoryCourse(priorCourseOne);
        studentFourth.setHistoryCourse(priorCourseSecond);

        Student studentFifth = new Student("P76064560", "春嬌", false);
        studentFifth.setHistoryCourse(priorCourseOne);
        studentFifth.setHistoryCourse(priorCourseSecond);

        Student studentSixth = new Student("P76064588", "志明", true);
        studentSixth.setHistoryCourse(priorCourseOne);
        studentSixth.setHistoryCourse(priorCourseSecond);

        // 開始進行選課
        System.out.println("透過 MultiThread 的方式進行驗證選課成功與否之 Demo:");
        CourseSection courseSectionOne = new CourseSection(courseOne);
        CourseSection courseSectionSecond = new CourseSection(courseSecond);
        courseSectionOne.openRegistration();
        courseSectionSecond.openRegistration();
        // 選課成功
        System.out.println("-------------------------------------");
        System.out.println("有完成先修課程 and 課程人數未滿 and 沒有特殊權限:");
        courseSectionOne.requestToRegister(studentOne);
        // 選課失敗
        System.out.println("-------------------------------------");
        System.out.println("沒有完成先修課程 and 課程人數未滿 and 沒有特殊權限:");
        courseSectionOne.requestToRegister(studentSecond);
        // 選課成功
        System.out.println("-------------------------------------");
        System.out.println("有完成先修課程 and 課程人數未滿 and 有特殊權限:");
        courseSectionOne.requestToRegister(studentThird);
        // 選課成功
        System.out.println("-------------------------------------");
        System.out.println("沒有完成先修課程 and 課程人數未滿 and 有特殊權限:");
        courseSectionSecond.requestToRegister(studentThird);
        // 選課成功
        System.out.println("-------------------------------------");
        System.out.println("有完成先修課程 and 課程人數未滿 and 有特殊權限:");
        courseSectionSecond.requestToRegister(studentFourth);
        // 選課失敗
        System.out.println("-------------------------------------");
        System.out.println("有完成先修課程 and 課程人數已滿 and 有特殊權限:");
        courseSectionOne.requestToRegister(studentSixth);
    }
}