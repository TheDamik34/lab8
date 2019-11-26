package zad3;

public class WatekMain {
    private static String[] strings = {"aaaa", "bb", "ccccccccccccc", "dddddd"};

    public static void main(String[] args) {
        Thread[] temp =  new Thread[4];
       for(int i = 0; i < strings.length; ++i) {
           temp[i] = new Thread(new Watek1(strings[i]));
           //temp.start();
       }

       temp[0].start();
       temp[1].start();
       temp[2].start();
       temp[3].start();
    }
}
