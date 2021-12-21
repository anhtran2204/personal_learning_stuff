package sample.DataModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;


public class EmployeeData {
    private static final String CONTACTS_FILE = "employeeInfos.xml";

    private static final String EMPLOYEE = "employee";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String DATE_OF_BIRTH = "date_of_birth";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String EMAIL = "email";
    private static final String POSITION = "position";
    private static final String INSURANCE_INVESTMENT_SAVINGS = "insurance_investment_savings";
    private static final String SALARY_OR_WAGE = "salaryWage";
    private static final String BONUS = "bonus";
    private static final String VACATION_DAYs = "vacation_days";
    private static final String NOTES = "notes";

    private static EmployeeData employee = new EmployeeData();

    private ObservableList<EmployeeInfo> employeeInfos;

    public EmployeeData() {
        // *** initialize the contacts list here ***
        employeeInfos = FXCollections.observableArrayList();
    }

    public static EmployeeData getInstance() {
        return employee;
    }

    // *** Add methods to add/delete/access contacts here ***
    public ObservableList<EmployeeInfo> getEmployeeInfos() {
        return employeeInfos;
    }

    public void addEmployeeInfo(EmployeeInfo item) {
        employeeInfos.add(item);
    }

    public void deleteEmployeeInfo(EmployeeInfo item) {
        employeeInfos.remove(item);
    }

    public void loadEmployeeInfo() {
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(CONTACTS_FILE);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            EmployeeInfo employeeInfo = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have a contact item, we create a new contact
                    if (startElement.getName().getLocalPart().equals(EMPLOYEE)) {
                        employeeInfo = new EmployeeInfo();
                        continue;
                    }

                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart()
                                .equals(FIRST_NAME)) {
                            event = eventReader.nextEvent();
                            employeeInfo.setFirstName(event.asCharacters().getData());
                            continue;
                        }
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(LAST_NAME)) {
                        event = eventReader.nextEvent();
                        employeeInfo.setLastName(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(DATE_OF_BIRTH)) {
                        event = eventReader.nextEvent();
                        employeeInfo.setDateOfBirth(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(PHONE_NUMBER)) {
                        event = eventReader.nextEvent();
                        employeeInfo.setPhoneNumber(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(EMAIL)) {
                        event = eventReader.nextEvent();
                        employeeInfo.setEmail(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(POSITION)) {
                        event = eventReader.nextEvent();
                        employeeInfo.setPosition(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(SALARY_OR_WAGE)) {
                        event = eventReader.nextEvent();
                        employeeInfo.setSalaryOrWage(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(INSURANCE_INVESTMENT_SAVINGS)) {
                        event = eventReader.nextEvent();
                        employeeInfo.setInsuranceInvestmentSavings(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(BONUS)) {
                        event = eventReader.nextEvent();
                        employeeInfo.setBonus(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(VACATION_DAYs)) {
                        event = eventReader.nextEvent();
                        employeeInfo.setVacationDays(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(NOTES)) {
                        event = eventReader.nextEvent();
                        employeeInfo.setNotes(event.asCharacters().getData());
                        continue;
                    }
                }

                // If we reach the end of a contact element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(EMPLOYEE)) {
                        employeeInfos.add(employeeInfo);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void saveEmployeeInfo() {

        try {
            // create an XMLOutputFactory
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            // create XMLEventWriter
            XMLEventWriter eventWriter = outputFactory
                    .createXMLEventWriter(new FileOutputStream(CONTACTS_FILE));
            // create an EventFactory
            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            XMLEvent end = eventFactory.createDTD("\n");
            // create and write Start Tag
            StartDocument startDocument = eventFactory.createStartDocument();
            eventWriter.add(startDocument);
            eventWriter.add(end);

            StartElement contactsStartElement = eventFactory.createStartElement("",
                    "", "employees");
            eventWriter.add(contactsStartElement);
            eventWriter.add(end);

            for (EmployeeInfo employeeInfo: employeeInfos) {
                saveEmployeeInfo(eventWriter, eventFactory, employeeInfo);
            }

            eventWriter.add(eventFactory.createEndElement("", "", "employees"));
            eventWriter.add(end);
            eventWriter.add(eventFactory.createEndDocument());
            eventWriter.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Problem with Contacts file: " + e.getMessage());
            e.printStackTrace();
        }
        catch (XMLStreamException e) {
            System.out.println("Problem writing contact: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void saveEmployeeInfo(XMLEventWriter eventWriter, XMLEventFactory eventFactory, EmployeeInfo employeeInfo)
            throws FileNotFoundException, XMLStreamException {

        XMLEvent end = eventFactory.createDTD("\n");

        // create contact open tag
        StartElement configStartElement = eventFactory.createStartElement("",
                "", EMPLOYEE);
        eventWriter.add(configStartElement);
        eventWriter.add(end);
        // Write the different nodes
        createNode(eventWriter, FIRST_NAME, employeeInfo.getFirstName());
        createNode(eventWriter, LAST_NAME, employeeInfo.getLastName());
        createNode(eventWriter, DATE_OF_BIRTH, employeeInfo.getDateOfBirth());
        createNode(eventWriter, PHONE_NUMBER, employeeInfo.getPhoneNumber());
        createNode(eventWriter, EMAIL, employeeInfo.getEmail());
        createNode(eventWriter, POSITION, employeeInfo.getPosition());
        createNode(eventWriter, SALARY_OR_WAGE, employeeInfo.getSalaryOrWage());
        createNode(eventWriter, INSURANCE_INVESTMENT_SAVINGS, employeeInfo.getInsuranceInvestmentSavings());
        createNode(eventWriter, BONUS, employeeInfo.getBonus());
        createNode(eventWriter, VACATION_DAYs, employeeInfo.getVacationDays());
        createNode(eventWriter, NOTES, employeeInfo.getNotes());

        eventWriter.add(eventFactory.createEndElement("", "", EMPLOYEE));
        eventWriter.add(end);
    }

    public void updateEmployee(EmployeeInfo employeeInfo) {
        employeeInfos.set(employeeInfos.indexOf(employeeInfo), employeeInfo);
    }

    private void createNode(XMLEventWriter eventWriter, String name,
                            String value) throws XMLStreamException {

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        // create Start node
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // create Content
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        // create End node
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);
    }
}
