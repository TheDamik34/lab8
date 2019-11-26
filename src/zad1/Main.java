package zad1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MaxSearchAlgorithms maxSearchAlgorithms = new MaxSearchAlgorithms();

        /*List<Integer> temp = maxSearchAlgorithms.leftToRightScan(new int[]{4, 10, 3, 7, 4, 1, 6, 2});
        System.out.println(temp);

        temp = maxSearchAlgorithms.rightToLeftScan(new int[]{4, 10, 3, 7, 4, 1, 6, 2});
        System.out.println(temp);

        temp = maxSearchAlgorithms.evenToOddScan(new int[]{4, 10, 3, 7, 4, 1, 6, 2});
        System.out.println(temp);*/

        Class cls = maxSearchAlgorithms.getClass();
        Method[] methods = cls.getDeclaredMethods();
        List<Method> listMethonds = new ArrayList<>();

        for(Method method:methods) {
            if(method.getName().contains("Scan"))
                listMethonds.add(method);
        }

        for (Method method:listMethonds) {
            method.setAccessible(true);
            System.out.println(method.getName());
            System.out.println(method.invoke(maxSearchAlgorithms, new int[]{4, 10, 3, 7, 4, 1, 6, 2}));
        }


    }
}
