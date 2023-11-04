/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Person;
import repository.FormatCSV;
import repository.IFormatCSV;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class FormatCSVManager extends Menu {

    private IFormatCSV mn;
    private List<Person> personList;
    static String[] mc = {"Import CSV", "Format Address", "Format Name", "Export CSV", "Exit"};

    public FormatCSVManager() {
        super("Format CSV Program", mc);
        mn = new FormatCSV();
        personList = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> mn.importCSV(personList);
            case 2 -> mn.formatAddress(personList);
            case 3 -> mn.formatName(personList);
            case 4 -> mn.exportCSV(personList);
            case 5 -> System.exit(0);
        }
    }

}
