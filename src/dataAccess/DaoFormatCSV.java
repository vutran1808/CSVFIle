/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import model.Person;

/**
 *
 * @author ASUS
 */
public class DaoFormatCSV {

    private static DaoFormatCSV instance = null;

    public static DaoFormatCSV Instance() {
        if (instance == null) {
            synchronized (DaoFormatCSV.class) {
                if (instance == null) {
                    instance = new DaoFormatCSV();
                }
            }
        }
        return instance;
    }

    public void importFile(String path, List<Person> personList) {
        File file = new File(path);
        String name = "", address = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(":");
                if (data[0].equalsIgnoreCase("Name")) {
                    name = data[1];
                } else {
                    address = data[1];
                }
                if (!name.isBlank() && !address.isBlank()) {
                    personList.add(new Person(name, address));
                    name = address = "";
                }
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("File not exists!");
        }
        if (!personList.isEmpty()) {
            System.out.println("Import: Done");
        } else {
            System.out.println("Empty File");
        }
    }

    public void formatAddress(List<Person> personList) {
        for (Person person : personList) {
            String format = person.getAddress().trim().replaceAll("\\-", " - ").replaceAll("\\s+", " ");
            person.setAddress(format);
        }
        System.out.println("Format: Done");
    }

    public void formatName(List<Person> personList) {
        for (Person person : personList) {
            String newName = "";
            String data[] = person.getName().trim().replaceAll("\\s+", " ").split(" ");
            for (int i = 0; i < data.length; i++) {
                String firstW = data[i].substring(0, 1).toUpperCase();
                data[i] = firstW + data[i].substring(1);
                newName += data[i] + (i < data.length - 1 ? " " : "");
            }
            person.setName(newName);
        }
        System.out.println("Format: Done");
    }

    public void exportFile(String dest, List<Person> personList) {
        File file = new File(dest);
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (Person p : personList) {
                pw.println(p.toString());
            }
            pw.close();
            System.out.println("Export: Done");
        } catch (Exception e) {
            System.out.println("File is not found!");
        }
    }
}
