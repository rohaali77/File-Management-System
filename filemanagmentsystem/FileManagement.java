package com.filemanagmentsystem;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileManagement {

    Scanner scanner = new Scanner(System.in);

    public void createFile(String dir, String fileName, String content) throws IOException {

        boolean success = false;

        File tempDir = new File(dir);
        if (!tempDir.exists()) {
            System.out.println("Directory doesn't exist. Creating now....");
            tempDir.mkdir();
        }

        File file = new File(dir+"\\"+fileName);
        if (file.exists()) {
            System.out.println("File already exists");
        } else {
            System.out.println("No such file exists, creating now....");
            success = file.createNewFile();
            if (success) {
                System.out.printf("Successfully created new file: %s%n", fileName);
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.append(content);
                fileWriter.close();
                System.out.println("File updated and saved successfully.");
            } else {
                System.out.printf("Failed to create new file: %s%n", fileName);
            }
        }
    }

    public String readFile(String filePath) throws IOException {

        File file = new File(filePath);

        if (file.exists()) {
            FileReader fileReader = new FileReader(file);
            int i;
            String output = "";
            while ((i = fileReader.read()) != -1)
                output = output + (char) i;
            fileReader.close();
            return output;
        }
        return "File doesn't exists.";
    }

    public String updateFile(String filePath) throws IOException {
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("Enter content of the file");
            String content = scanner.nextLine();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append(content);
            fileWriter.close();

            return "File updated and saved successfully.";
        }
        return "File doesn't exists.";
    }

    public String deleteFile(String filePath) {

        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
            return "File deleted successfully.";

        }
        return "File doesn't exists.";
    }

    public String appendFile(String filePath, String content) throws IOException {

        File file = new File(filePath);

        if (file.exists()) {
            String previousContent = this.readFile(filePath);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append(previousContent);
            fileWriter.append(content);
            fileWriter.close();

            return "File updated and saved successfully.";
        }
        return "File doesn't exists.";
    }

    public String copyFile(String filePath, String destinationPath) throws IOException {

        File copiedFile = new File(filePath);
        String[] fileName = filePath.split(Pattern.quote(File.separator));
        File desPath = new File(destinationPath);
        if (copiedFile.exists()) {
            if (!desPath.exists()) {
                System.out.println("Directory doesn't exist. Creating now....");
                desPath.mkdir();
            }

            File newFile = new File(destinationPath + "\\" + fileName[fileName.length - 1]);
            if (newFile.exists()) {
                return "File already exists in the destination folder";
            } else {
                System.out.println("No such file exists, copying now....");
                Files.copy(copiedFile.toPath(), newFile.toPath());
                return "File copied successfully.";
            }
        }
        return "File doesn't exists.";
    }

    public String mergeFile(String mergedFilePath, String filePath) throws IOException {

        File mergedFile = new File(mergedFilePath);
        File file = new File(filePath);
        if (mergedFile.exists() && file.exists()) {
            String content = this.readFile(filePath);
            this.appendFile(mergedFilePath, "\n" + content);
            this.deleteFile(filePath);
            return "File merged successfully.";
        }
        return "File doesn't exist.";
    }

}
