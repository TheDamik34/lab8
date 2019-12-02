package zad2;

public class MainZad2 {
    public static void main(String[] args) {
        EqualsClass equalsClass = new EqualsClass();
        EqualsClass equalsClass2 = new EqualsClass();


        System.out.println(equalsClass.equals2(equalsClass2));
        equalsClass.setAge(10);
        System.out.println(equalsClass.equals2(equalsClass2));

    }
}
