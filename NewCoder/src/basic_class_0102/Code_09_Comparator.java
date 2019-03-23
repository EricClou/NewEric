package basic_class_0102;

import java.util.Arrays;
import java.util.Comparator;

//当设计到对象的排序比较的时候，要自己制作比较器

public class Code_09_Comparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student ( String name, int id, int age ) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator <Student> {

        @Override
        public int compare ( Student o1, Student o2 ) {
            return o1.id - o2.id;
        }

    }

    public static class IdDescendingComparator implements Comparator <Student> {

        @Override
        public int compare ( Student o1, Student o2 ) {
            return o2.id - o1.id;
        }

    }

    public static class AgeAscendingComparator implements Comparator <Student> {

        @Override
        public int compare ( Student o1, Student o2 ) {
            return o1.age - o2.age;
        }

    }

    public static class AgeDescendingComparator implements Comparator <Student> {

        @Override
        public int compare ( Student o1, Student o2 ) {
            return o2.age - o1.age;
        }

    }

    public static void printStudents ( Student[] students ) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }

    public static void main ( String[] args ) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[]{student3, student2, student1};
        printStudents(students);

        //在对自定义类的元素进行排序的时候需要自己重写一个比较器，否则将按照对象地址进行比较排序
        //在使用mybatis框架的时候框架帮助完成了排序的功能
        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);

    }

}