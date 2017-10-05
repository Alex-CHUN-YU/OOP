package edu.ncku;

/**
 * This is a Demo.
 *
 * @version 1.0 2017年10月03日
 * @author Alex
 *
 */
public class Main {
    /**
     * Main Function.
     * @param args system default
     */
    public static void main(String[] args) {
        System.out.println("Early Binding Demo:");
        Student studentStaticPolymorphism = new Student("NCKU");
        studentStaticPolymorphism.introduction();
        studentStaticPolymorphism.introduction("Alex");

        System.out.println("\nLate Binding Demo:");
        Teacher teacherDynamicPolymorphism = new Teacher("NCKU");
        Teacher studentPolymorphism = new Student("NCKU");
        teacherDynamicPolymorphism.introduction();
        studentPolymorphism.introduction();

        System.out.println("\nAbstract Class Demo:");
        School teacherAbstractClass = new Teacher("NCKU");
        teacherAbstractClass.showClassInformation();

        System.out.println("\nInterface Demo:");
        Student studentInterface = new Student("NCKU");
        studentInterface.sleepTime(8);
        studentInterface.exerciseTime(3);
    }
}
