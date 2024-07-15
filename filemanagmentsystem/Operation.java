package com.filemanagmentsystem;

import java.io.IOException;
import java.util.Scanner;

public class Operation {

    Scanner scanner = new Scanner(System.in);

    public void handleOperation(int selectedOperation) throws IOException {

        FileManagement fileManagement = new FileManagement();

        switch (selectedOperation) {
            case 1: {
                System.out.println("!!!! CREATE FILE !!!!\n\nEnter path of directory to create"+
                        "(\nExample: 'D:\\folder1')");
                String dir = scanner.nextLine();

                System.out.println("Enter file name to be created"+
                        "\nExample:'file1.txt'");
                String fileName = scanner.nextLine();

                System.out.println("Enter content of the file");
                String content = scanner.nextLine();

                fileManagement.createFile(dir, fileName, content);
                break;
            }
            case 2: {
                System.out.println("!!!! READ FILE !!!!\n\nEnter full path of the file" +
                        "(\nExample: 'D:\\folder1\\file1.txt')");
                String filePath = scanner.nextLine();

                System.out.println(fileManagement.readFile(filePath));
                break;
            }
            case 3: {
                System.out.println("!!!! UPDATE FILE !!!!\n\nEnter full path of the file"+
                        "(\nExample: 'D:\\folder1\\file1.txt')");
                String filePath = scanner.nextLine();
                System.out.println(fileManagement.updateFile(filePath));
                break;
            }
            case 4: {
                System.out.println("!!!! DELETE FILE !!!!\n\nEnter full path of the file"+
                        "(\nExample: 'D:\\folder1\\file1.txt')");
                String filePath = scanner.nextLine();
                System.out.println(fileManagement.deleteFile(filePath));
                break;
            }
            case 5: {
                System.out.println("!!!! UPDATE FILE !!!!\n\nEnter full path of the file"+
                        "(\nExample: 'D:\\folder1\\file1.txt')");
                String filePath = scanner.nextLine();
                System.out.println("Enter content of the file");
                String content = scanner.nextLine();
                System.out.println(fileManagement.appendFile(filePath, content));
                break;
            }
            case 6: {
                System.out.println("!!!! COPY FILE !!!!\n\nEnter full path of the file"+
                        "(\nExample: 'D:\\folder1\\file1.txt')");
                String filePath = scanner.nextLine();
                System.out.println("\nEnter full path of the destination folder"+
                        "(\nExample: 'D:\\folder1')");
                String destPath = scanner.nextLine();
                System.out.println(fileManagement.copyFile(filePath, destPath));
                break;
            }
            case 7: {
                System.out.println("!!!! MERGE FILES !!!!\n\nEnter full path of the file you wannt to merge into"+
                        "(\nExample: 'D:\\folder1\\file1.txt')");
                String mergedFile = scanner.nextLine();
                System.out.println("\nEnter full path of the file you want to merge"+
                        "(\nExample: 'D:\\folder2\\file2.txt')");
                String filePath = scanner.nextLine();
                System.out.println(fileManagement.mergeFile(mergedFile, filePath));
                break;
            }
        }
    }

}
