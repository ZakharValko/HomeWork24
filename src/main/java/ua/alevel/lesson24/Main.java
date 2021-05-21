package ua.alevel.lesson24;

import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao(HibernateSessionFactory.getSessionFactory());

        StudentEntity entity = new StudentEntity("First", "Second", new Date(1999-01-01));
        System.out.println(entity.getStudentId());
        List<StudentEntity> allStudents = studentDao.getAll();
        System.out.println(allStudents);
    }
}
