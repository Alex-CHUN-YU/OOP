package edu.ncku;

/**
 * Student Class.
 *
 * @version 1.0 2017年10月03日
 * @author Alex
 *
 */
class Student extends Teacher implements Sleep, Exercise {
    /**
     * Constructor.
     * @param schoolName school name
     */
    Student(String schoolName) {
        super(schoolName);
    }

    // 以下兩個 function 比較表示出靜態多型，introduction function 實作動態多型
    /**
     * Introduction myself.
     */
    void introduction() {
        System.out.println("I am a student, I study in " + schoolName + ".");
    }

    /**
     * Introduction myself.
     * @param studentName student name
     */
    void introduction(String studentName) {
        System.out.println("My name is " + studentName + ".");
    }

    // 實作 interface 功能
    /**
     * Sleep time.
     * @param hours hours
     */
    public void sleepTime(final int hours) {
        System.out.println("I sleep " + hours + "hours a day!");
    }

    /**
     * Exercise Time.
     * @param hours hours
     */
    public void exerciseTime(final int hours) {
        System.out.println("I spend " + hours + " hours do exerciseTime!");
    }
}
