package ua.alevel.lesson24;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class StudentDao {

    private SessionFactory sessionFactory;

    // Вывод всех студентов
    public List<StudentEntity> getAll(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From StudentEntity");
        return query.list();
    }

    // Поиска студента по ID
    public StudentEntity getStudentById(long studentId){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From StudentEntity WHERE studentId = :id");
        query.setParameter("id", studentId);
        return (StudentEntity) query.getSingleResult();
    }

    // Добавление студента
    public StudentEntity addStudent(StudentEntity newEntity){
        Session session = sessionFactory.openSession();
        session.save(newEntity);
        session.close();
        return newEntity;
    }

    // Обновление студента по I
    public StudentEntity updateStudent(long studentId, StudentEntity entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        entity.setStudentId(studentId);
        session.update(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    // Удаление студента
    public boolean deleteStudent(long studentId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StudentEntity entityToDelete = getStudentById(studentId);
        session.delete(entityToDelete);
        transaction.commit();
        session.close();
        return true;
    }

    public StudentDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
}

