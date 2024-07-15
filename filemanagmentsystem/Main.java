package com.filemanagmentsystem;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int selectedOperation = 0;
        String menu = "\n1. Create File    ---- enter 1" +
                      "\n2. Read File      ---- enter 2" +
                      "\n3. Update File    ---- enter 3" +
                      "\n4. Delete File    ---- enter 4" +
                      "\n5. Appennd File   ---- enter 5" +
                      "\n6. Copying File   ---- enter 6" +
                      "\n7. Merge Files    ---- enter 7";

        while (true) {
            System.out.println("\nSelect operation you want to perform from the below menu. Select 0 to terminate the program.");
            System.out.println(menu);
            selectedOperation = scanner.nextInt();

            if (selectedOperation==0) break; // break the loop

            Operation operation = new Operation();
            operation.handleOperation(selectedOperation);

        }

    }
}
