/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ScannerFactory;
import dataAccess.DaoFormatCSV;
import java.util.List;
import model.Person;

/**
 *
 * @author ASUS
 */
public class FormatCSV implements IFormatCSV {

    private ScannerFactory sc;

    public FormatCSV() {
        sc = new ScannerFactory();
    }

    @Override
    public void importCSV(List<Person> personList) {
        String input = sc.getFilePath("Enter Path: ");
        DaoFormatCSV.Instance().importFile(input, personList);
    }

    @Override
    public void formatAddress(List<Person> personList) {
        DaoFormatCSV.Instance().formatAddress(personList);
    }

    @Override
    public void formatName(List<Person> personList) {
        DaoFormatCSV.Instance().formatName(personList);
    }

    @Override
    public void exportCSV(List<Person> personList) {
        String dest = sc.getFilePath("Enter Dest: ");
        DaoFormatCSV.Instance().exportFile(dest, personList);
    }

}
