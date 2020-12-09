import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Companies companies = Companies.getInstance("pink");
        Company decisionDiagnostics = companies.createCompany(
                "DECN", "https://rss.app/feeds/1QtbF7Q6zMa8E17k.xml"
        );
//        Company enzolytics = companies.createCompany(
//                "ENZC", "https://rss.app/feeds/Ttlmq05MWM18AuiO.xml"
//        );
        System.out.println("--------------------------");
        People investors = People.getInstance("investors");
        Person garrett = new Person("Garrett", "+15734658386");
        investors.addPerson(garrett);
        System.out.println("--------------------------");
        decisionDiagnostics.addRecipient(garrett);
//        enzolytics.addRecipient(garrett);
        System.out.println("--------------------------");
        decisionDiagnostics.run();
//        enzolytics.run();
    }
}
