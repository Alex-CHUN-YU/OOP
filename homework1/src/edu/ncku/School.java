package edu.ncku;

/**
 * School abstract Class(if polymorphism demo no use abstract keyword).
 *
 * @version 1.0 2017年10月03日
 * @author Alex
 *
 */
abstract class School {
    /**
     * School Name.
     */
     String schoolName;

    /**
     * Constructor.
     * @param schoolName school name
     */
    School(String schoolName) {
        this.schoolName = schoolName;
    }

    // 代表著抽象類別中可存在非抽象方法
    /**
     * School Introduction.
     */
    void introduction() {
        System.out.println("I am " + this.schoolName + ".");
    }

    // 抽象方法
    /**
     * Class Information.
     */
    abstract void showClassInformation();
}