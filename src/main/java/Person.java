import java.util.ArrayList;
import java.util.List;

public class Person {
    public String name;
    public String number;
    public List<Company> companyList;

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
        this.companyList = new ArrayList<Company>();
    }

    public void addCompany(Company company) {
        if(company != null) {
            System.out.println(company.getName() + " was added.");
            this.companyList.add(company);
        } else System.out.println("Company was not added.");
    }

    public void removeCompany(Company company) {
        if(company != null) {
            System.out.println(company.getName() + " was removed.");
            this.companyList.remove(company);
        }
    }

    public void printCompanyList() {
        System.out.println("Company List: ");
        for (Company company : this.companyList) {
            System.out.print(company + ", ");
        }
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
