package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/railwaystat";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "****";
    private static final Connection connection;
   private static List<Client> clients= new ArrayList<>();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        CRUD crud = new CRUD();
        Input input = new Input();
        Scanner scanner = new Scanner(System.in);
        ui(crud, input, scanner);
    }

    private void ui(CRUD crud, Input input, Scanner scanner) {
        System.out.println("""
                Натисніть 1 для створення клієнта (пасажирів)
                Натисніть 2 для прочитання списку клієнтів (пасажирів)
                Натисніть 3 для відновлення списку клієнтів (пасажирів)
                Натисніть 4 для видалення клієнта з списку
                Натисніть 5 для демострації списку клієнтів (пасажирів)
                Натисніть 6 для виходу""");
        boolean status = true;
        while (status) {
            System.out.print("Вибір дії: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> createClient(crud, input);
                case 2 -> readClient(crud);
                case 3 -> updateClient(crud, input, scanner);
                case 4 -> deleteClient(crud, scanner);
                case 5 -> showClient(clients);
                case 6 -> status = false;
            }
            System.out.println("Задача виконана!");
        }
    }

    private void createClient(CRUD crud, Input input) {
        crud.Create(connection,input.inputCl());
    }
    private void readClient(CRUD crud) {
        crud.Read(connection);
    }
    private void updateClient(CRUD crud, Input input, Scanner scanner) {
        System.out.print("Введіть ID клієнта, який ви хочете змінити: ");
        int id = scanner.nextInt();
        crud.Update(connection, input.inputCl(), id);
    }
    private void deleteClient(CRUD crud, Scanner scanner) {
        System.out.print("Введіть ID клієнта, який ви хочете видалити: ");
        int id = scanner.nextInt();
        crud.Delete(connection, id);
    }
    private void showClient(List<Client> clients) {
        for (Client client : clients) System.out.println(client + "\n\n");
    }

}