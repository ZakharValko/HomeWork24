package ua.alevel.lesson24;

import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao(HibernateSessionFactory.getSessionFactory());

        List<StudentEntity> allStudents = studentDao.getAll();
        System.out.println(allStudents);
    }
}
