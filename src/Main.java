import builder.Person;
import factory.VehicleFactoryEnum;
import factory.VehicleFactoryFactory;
import factory.Vehilce;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Vehilce car = VehicleFactoryFactory.getInstance().getVehilce(VehicleFactoryEnum.CAR);
        Vehilce ship = VehicleFactoryFactory.getInstance().getVehilce(VehicleFactoryEnum.PLANE);
        Vehilce plane = VehicleFactoryFactory.getInstance().getVehilce(VehicleFactoryEnum.SHIP);

        Vehilce[] vehilces = {car, ship, plane};

        Arrays.stream(vehilces).forEach(Vehilce::start);

        Person person1 = Person.PersonBuilder.aPerson("99999999999").build();
        Person person2 = Person.PersonBuilder.aPerson("99999999999").withFirstName("Adam").build();
        Person person3 = Person.PersonBuilder.aPerson("99999999999").withFirstName("Bilbo")
                .withLastName("Faggot").build();
        Person[] people = {person1, person2, person3};
        Arrays.stream(people).forEach(person -> System.out.println(person));

        MyInterface myAnnonumusImplementation = new MyInterface() {
            @Override
            public String go(String s, int a) {
                return s+a+"Implementacja w 'anonimowej' klasie";
            }
        };

        MyInterface myLambda = (s, a) -> s+a+"Implementacja w 'lambdzie'";
        System.out.println(myLambda.go("s", 5));

        useClassOrLambdaAnonumousInterface(new MyFirstImplementation(), "s", 5);
        useClassOrLambdaAnonumousInterface(myAnnonumusImplementation, "s", 3);
        useClassOrLambdaAnonumousInterface(myLambda, "s", 5);
        useClassOrLambdaAnonumousInterface((s, a) -> s+a+ "lambda anonimowej zmiennej", "2", 5);
    }

    static void useClassOrLambdaAnonumousInterface(MyInterface myInterface, String s, int a){
        System.out.println(myInterface.go(s,a));
    }
}
