/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Person;

/**
 *
 * @author ASUS
 */
public interface IFormatCSV {
    void importCSV(List<Person> personList);
    void formatAddress(List<Person> personList);
    void formatName(List<Person> personList);
    void exportCSV(List<Person> personList);
}
