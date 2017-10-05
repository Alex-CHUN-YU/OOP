package edu.ncku;

/**
 * Teacher Class.
 *
 * @version 1.0 2017年10月03日
 * @author Alex
 *
 */
class Teacher extends School {
    /**
     * Constructor.
     * @param schoolName school name
     */
    Teacher(String schoolName) {
        super(schoolName);
    }

    // 以下兩個 function 比較表示出靜態多型，introduction function 實作動態多型
    /**
     * Introduction myself.
     */
    void introduction() {
        System.out.println("I am a Teacher, I work at " + schoolName + ".");
    }

    /**
     * Introduction myself.
     * @param teacherName teacher name
     */
    void introduction(String teacherName) {
        System.out.println("My name is " + teacherName + ".");
    }

    // 繼承 abstract class 並實作它
    /**
     * Student Class Information.
     */
    public void showClassInformation() {
        System.out.println("He took a course in object oriented programming.");
    }
}
