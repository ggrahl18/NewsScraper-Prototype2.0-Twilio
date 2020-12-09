import java.util.ArrayList;
import java.util.List;

public class People {
    private static People peopleInstance = null;
    public String name;
    public List<Person> peopleList;

    private People(String name) {
        this.name = name;
        this.peopleList = new ArrayList<>();
    }

    public static People getInstance(String name) {
        if (peopleInstance == null) {
            peopleInstance = new People(name);
        }

        return peopleInstance;
    }

    public void addPerson(Person person) {
        if(person != null) {
            System.out.println(person.getName() + " was added to the list.");
            this.peopleList.add(person);
        } else System.out.println("Person was not added.");
    }

    public void removePerson(Person person) {
        if(person != null) {
            System.out.println(person.getName() + " has been removed.");
            this.peopleList.remove(person);
        } else System.out.println("Person was not removed");
    }

    public int findPerson(Person person) {
        return this.peopleList.indexOf(person);
    }

    public int findPerson(String name) {
        for(int i=0; i<this.peopleList.size(); i++) {
            Person person = this.peopleList.get(i);
            if(person.getName().equalsIgnoreCase(name)) return i;
        }

        return -1;
    }

    public String queryPerson(Person person) {
        if(findPerson(person) >= 0) {
            return person.getName();
        }

        return null;
    }

    public Person queryPerson(String name) {
        int position = findPerson(name);
        if(position >= 0) {
            return this.peopleList.get(position);
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
