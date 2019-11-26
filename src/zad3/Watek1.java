package zad3;

public class Watek1 implements Runnable {

    private String tab;

    public Watek1(String tab) {
        this.tab = tab;
    }

    @Override
    public void run() {
        for(int i = 0; i < tab.length(); ++i) {
            System.out.print(tab.charAt(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
