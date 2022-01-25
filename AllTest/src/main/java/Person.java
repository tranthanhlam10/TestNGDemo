

public class Person {
    private String firstname;
    private String lastname;
    private int age;


    public Person(String fname,String lname, int age)
    {
        this.firstname=fname;
        this.lastname=lname;
        this.age= age;
    }
    public Person(){

    }

    public void SetAge(int age)
    {
        this.age = age;
    }

    public String getFirstName()
    {
        return firstname;
    }
    public String getLastName()
    {
        return lastname;
    }
    public int getAge()
    {
        return age;
    }

    public int getAllAge(int age){
        return age;
    }


    public String checkAgeToVaccinCovid()
    {
        if (age > 50 ){
          return   "Prifzer";
        } else if (age <18) {
           return "Astra";
        } else {
          return  "Verocell";
        }

    }
}
