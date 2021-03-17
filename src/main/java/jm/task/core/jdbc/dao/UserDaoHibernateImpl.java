package jm.task.core.jdbc.dao;



import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDaoHibernateImpl implements UserDao {

    //private final SessionFactory factory;

    public UserDaoHibernateImpl() {


    }


    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {

            // start the transaction
            transaction = session.beginTransaction();

            // save object
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS user7(\n" +
                    "   id INT AUTO_INCREMENT,\n" +
                    "   PRIMARY KEY (id), \n" +
                    "   name VARCHAR(50),\n" +
                    "   lastName VARCHAR(50),\n" +
                    "   age INT\n" +
                    ")")
                    .executeUpdate();   //обновляет инфу

            // commit transction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {

            // start the transaction
            transaction = session.beginTransaction();

            // save object
            session.createSQLQuery("DROP TABLE IF EXISTS user7;")
                    .executeUpdate();   //обновляет инфу

            // commit transction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {

            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(new User(name, lastName, age));

            // commit transction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {

            // start the transaction
            transaction = session.beginTransaction();

            //сначала нужно найти объект по данному id
            User user1 = session.find(User.class, id);

            // save object
            session.delete(user1);

            // commit transction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {

            // start the transaction
            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM User");
            userList = query.list();

            // commit transction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {

            // start the transaction
            transaction = session.beginTransaction();

            session.createQuery("DELETE FROM User")
                    .executeUpdate();   //обновляет инфу

            // commit transction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
