public class Main {
    public static void main(String args[])
    {
        Person TranLam = new Person("Tran","Lam",51);
        Person TranLong = new Person();
        TranLong.SetAge(26);
        TranLong.checkAgeToVaccinCovid();
        System.out.println("Tran lam duoc chich vaccin");
        TranLam.checkAgeToVaccinCovid();
        System.out.println("Tran Long duoc chich vaccin");

    }
}
