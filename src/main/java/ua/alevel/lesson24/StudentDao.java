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
    public StudentEntity getStudentById(int student_id){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From StudentEntity WHERE student_id = :id");
        query.setParameter("id", student_id);
        return (StudentEntity) query.getSingleResult();
    }

    // Добавление студента
    public StudentEntity addStudent(StudentEntity newEntity){
        Session session = sessionFactory.openSession();
        session.save(newEntity);
        session.close();
        return newEntity;
    }

    // Обновление студента по ID
    public StudentEntity updateStudent(long student_id, StudentEntity entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE StudentEntity SET first_name = :first_name, last_name = :last_name, date_of_birth = :date_of_birth WHERE student_id =:id");
        query.setParameter("id", student_id);
        query.setParameter("first_name", entity.getFirst_name());
        query.setParameter("last_name", entity.getLast_name());
        query.setParameter("date_of_birth", entity.getDate_of_birth());
        query.executeUpdate();
        transaction.commit();
        return entity;
    }

    // Удаление студента
    public boolean deleteStudent(long student_id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE StudentEntity WHERE student_id = :id");
        query.setParameter("id", student_id);
        query.executeUpdate();
        transaction.commit();
        return true;
    }

    public StudentDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
}

