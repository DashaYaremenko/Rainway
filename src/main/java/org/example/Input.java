package org.example;

import java.util.Scanner;

public class Input implements InterInput {

    @Override
    public Client inputCl() {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        System.out.print("Введіть ID: ");
        client.setID(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Введіть Призвіще: ");
        client.setLastName(scanner.nextLine());

        System.out.print("Введіть Ім'я: ");
        client.setFirstName(scanner.nextLine());

        System.out.print("Введіть Тип Документа: ");
        client.setTypeDoc(scanner.nextLine());

        return client;
    }
}
