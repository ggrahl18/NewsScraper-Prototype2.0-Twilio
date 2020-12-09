import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Companies {
    private static Companies companiesInstance = null;
    public String name;
    public List<TimerTask> companiesList;

    private Companies(String name) {
        this.name = name;
        this.companiesList = new ArrayList<>();
    }

    public static Companies getInstance(String name) {
        if (companiesInstance == null) {
            companiesInstance = new Companies(name);
        }

        return companiesInstance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // the issue is with TimerTask being returned here
    public Company createCompany(String name, String url) throws IOException {
        Timer timer = new Timer();
        TimerTask task = Company.getInstance(name, url);
        timer.schedule(task, 3000, 60000);
        if(task != null) {
            this.companiesList.add(task);
            System.out.println(name + " has been added to " + this.name);
            // issue is here with having to cast
            return (Company) task; // had to cast this object
        } else System.out.println(name + " was not added.");

        return null;
    }

    private int findCompany(Company company) { return this.companiesList.indexOf(company); }

    private int findCompany(String name) {
        for(int i=0; i<this.companiesList.size(); i++) {
            TimerTask company = this.companiesList.get(i);
            if(company.equals(company)) return i;
        }

        return -1;
    }

    public String queryCompany(Company company) {
        if(findCompany(company) >= 0) {
            return company.getName();
        }

        return null;
    }

    public TimerTask queryCompany(String name) {
        int position = findCompany(name);
        if(position >= 0) {
            return this.companiesList.get(position);
        }

        return null;
    }

    public void deleteCompany(String name) {
        TimerTask company = queryCompany(name);
        if(company != null) {
            System.out.println("Company has been removed");
            this.companiesList.remove(company);
        } else System.out.println("Company could not be removed.");
    }

    // modifyCompany or maybe just remove the company and create another in its stead
}
