import java.util.Arrays;

public class App {
    public static String heyName(String name) {
        final String out = "Hey, " + name;
        return out;
    } 
    public static void printMany(String... items) {
        for (String item : items) {
            System.out.println(item);
        }
    }
    public static void main(String[] args) throws Exception {
        final int length = 10;
        final int width = 5;
        final int area = length * width;
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
        System.out.println("The area is: " + Integer.toString(area));

        int[] nums = {1,2,3,9,8,7};
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(heyName("Theodor"));
        final Person myPerson = new Person("Per", "Pål", 53);
        System.out.println(myPerson.getFullName());
        myPerson.talk("yo");
        Person.scream();
        printMany("hello", "there", "bee");
        String a = "a";
        String b = a;
        a = "b";
        System.out.println(a + b);
        System.out.println(myPerson.getSpecies());
        final byte myByte = 12;
        final int myInt = myByte;
        final double myDouble = 24;
        final long myLong = (long) myDouble;
        final boolean hiIsHi = "Hi" == "Hi";
        final boolean yesIsNo = "Yes" == "No";
        System.out.println(hiIsHi | yesIsNo);
        System.out.println(Math.pow(3, 2));
        final Cat myCat = new Cat(10, "Bjørnar");
        myCat.play();
        System.out.println(myCat.getName());
    }
}
