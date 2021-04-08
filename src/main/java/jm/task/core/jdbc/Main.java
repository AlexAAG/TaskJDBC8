package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм  здесь

        UserService userService = new UserServiceImpl();

        //Создание таблицы User(ов)
        userService.createUsersTable();

        //Добавление 4 User(ов) в таблицу с данными на свой выбор.
        userService.saveUser("alex1", "ivanov", (byte)33);
        userService.saveUser("alex2", "ivanov", (byte)33);
        userService.saveUser("alex3", "ivanov", (byte)33);
        userService.saveUser("alex4", "ivanov", (byte)33);

        //Получение всех User из базы и вывод в консоль
        System.out.println("allUsers"+userService.getAllUsers());

        //Удаление User из таблицы ( по id )
        userService.removeUserById(1);

        //Очистка таблицы User(ов)
        userService.cleanUsersTable();

        //Удаление таблицы
        userService.dropUsersTable();
    }
}
