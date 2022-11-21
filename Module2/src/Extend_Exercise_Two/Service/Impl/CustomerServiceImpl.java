package Extend_Exercise_Two.Service.Impl;



import Extend_Exercise_Two.Model.InternationalCustomer;
import Extend_Exercise_Two.Model.VietnamCustomer;
import Extend_Exercise_Two.Service.CustomerService;
import Extend_Exercise_Two.Util.ReadAndWriteFile;
import Extend_Exercise_Two.Util.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    Scanner scanner = new Scanner(System.in);
    private final String REGEXVN = "(KHVN)(-)[0-9]{5}";
    private final String REGEXQT = "(KHNN)(-)[0-9]{5}";
    private final String PATHVN = "E:\\Codegym\\Module2\\src\\Extend_Exercise_Two\\Data\\Vncustomer.csv";
    private final String PATHNN = "E:\\Codegym\\Module2\\src\\Extend_Exercise_Two\\Data\\Nncustomer.csv";
    private final String HEADERS = " ID, Name, Type, consumptionRate, Nationality";
    ReadAndWriteFile<VietnamCustomer> vnReadAndWriteFile = new ReadAndWriteFile<>();
    ReadAndWriteFile<InternationalCustomer> nnReadAndWriteFile = new ReadAndWriteFile<>();

    public VietnamCustomer inputVietNam() {
        try {
            System.out.print("input ID: ");
            String id = Regex.regexID(scanner.nextLine(), REGEXVN, "PLEASE RE-INPUT!");
            System.out.print("input Name: ");
            String name = scanner.nextLine();
            System.out.println("input Type: ");
            String type = scanner.nextLine();
            System.out.println("input Consumption Rate: ");
            String consumptionRate = scanner.nextLine();
            return new VietnamCustomer(id, name, type, consumptionRate);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public InternationalCustomer inputInternational() {
        try {
            System.out.print("input ID: ");
            String id = Regex.regexID(scanner.nextLine(), REGEXQT, "PLEASE RE-INPUT!");
            System.out.print("input Name: ");
            String name = scanner.nextLine();
            System.out.println("input Nationality: ");
            String nationality = scanner.nextLine();
            return new InternationalCustomer(id, name, nationality);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<VietnamCustomer> getVNList() {
        List<String> stringList = vnReadAndWriteFile.readFromFile(PATHVN);

        List<VietnamCustomer> vnList = new ArrayList<>();
        for (String vnString : stringList) {
            String[] stringProperty = vnString.split(",");
            vnList.add(new VietnamCustomer(stringProperty[0], stringProperty[1], stringProperty[2], stringProperty[3]));
        }
        return vnList;
    }

    public List<InternationalCustomer> getNNList() {
        List<String> stringList = nnReadAndWriteFile.readFromFile(PATHNN);

        List<InternationalCustomer> nnList = new ArrayList<>();
        for (String nnString : stringList) {
            String[] stringProperty = nnString.split(",");
            nnList.add(new InternationalCustomer(stringProperty[0], stringProperty[1], stringProperty[2]));
        }
        return nnList;
    }


    @Override
    public void addNew() {

    }

    @Override
    public void display() {

    }

    @Override
    public void find() {

    }

    @Override
    public void addNewNN() {
        List<InternationalCustomer> nnList = getNNList();
        nnList.add(inputInternational());
        nnReadAndWriteFile.writeToFile(nnList, PATHNN,HEADERS);
    }

    @Override
    public void addNewVN() {
        List<VietnamCustomer> vnList = getVNList();
        vnList.add(inputVietNam());
        vnReadAndWriteFile.writeToFile(vnList, PATHVN, HEADERS);

    }
}
