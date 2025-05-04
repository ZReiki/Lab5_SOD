package main;

import main.hashTable.HashTable;

import java.util.Scanner;

public class Main {
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        HashTable hashTable = new HashTable(5);

        while(true) {
            System.out.print("""
                    Menu:
                    1. Add new element
                    2. Delete element
                    3. Is the element in the table?
                    4. Display elements
                    0. Exit
                    Your option >> \s""");

            switch (sc.nextInt()){
                case 1 -> hashTable.insert(sc.next());
                case 2 -> hashTable.delete(sc.next());
                case 3 -> System.out.println(hashTable.search(sc.next()) ? "Yes" : "No");
                case 4 -> hashTable.display();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }
    }
}
