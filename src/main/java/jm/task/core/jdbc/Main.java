package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

//        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//
//        //+++Создание таблицы User(ов)
//        userDaoJDBC.createUsersTable();
//
//        //+++Добавление 4 User(ов) в таблицу с данными на свой выбор.
//        userDaoJDBC.saveUser("vasya1","petrov1", (byte) 32);
//        userDaoJDBC.saveUser("vasya2","petrov2", (byte) 33);
//        userDaoJDBC.saveUser("vasya3","petrov3", (byte) 34);
//        userDaoJDBC.saveUser("vasya4","petrov4", (byte) 35);
//
//        //+++Получение всех User из базы и вывод в консоль
//        System.out.println(userDaoJDBC.getAllUsers());
//
//        //+++Удаление User из таблицы ( по id )
//        userDaoJDBC.removeUserById(7);
//
//        //+++Очистка таблицы User(ов)
//        userDaoJDBC.cleanUsersTable();
//
//        //+++Удаление таблицы
//        userDaoJDBC.dropUsersTable();


        //hipernate
        //соединение гипер УДАЛИТЬ
        Util.getSessionFactory();

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        //Создание таблицы User(ов)
        userDaoHibernate.createUsersTable();

        //Добавление 4 User(ов) в таблицу с данными на свой выбор.
        userDaoHibernate.saveUser("alex1", "ivanov", (byte)33);
        userDaoHibernate.saveUser("alex2", "ivanov", (byte)33);

        //Получение всех User из базы и вывод в консоль
        System.out.println(userDaoHibernate.getAllUsers());

        //Удаление User из таблицы ( по id )
        userDaoHibernate.removeUserById(1);

        //Очистка таблицы User(ов)
        userDaoHibernate.cleanUsersTable();

        //Удаление таблицы
        userDaoHibernate.dropUsersTable();

    }
}
