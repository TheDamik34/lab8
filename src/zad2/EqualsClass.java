package zad2;


import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

@Autor(
        autor = "Damian Jacewicz",
        iq = 3,
        znaki = 's'
)
public class EqualsClass {
    private String name;
    private boolean isFresh;
    private Integer age;

    @IgnoreEquals
    private double money;

    public String getName() {
        return name;
    }

    @Deprecated
    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFresh() {
        return isFresh;
    }

    public void setFresh(Boolean fresh) {
        isFresh = fresh;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof EqualsClass))
            return false;

        EqualsClass temp = (EqualsClass) obj;
        return this.getName().equals(temp.getName()) && this.getFresh() == temp.getFresh() && this.getAge().equals(temp.getAge());
    }

    public boolean equals2(Object obj) {
        Class cls = this.getClass();

        Field[] fields = cls.getDeclaredFields();
        for(Field i : fields) {
            Annotation[] annotations = i.getAnnotations();
            System.out.println(Arrays.toString(annotations));
            System.out.println(i.getName());
        }

       /* Arrays.stream(fields).filter(field -> {
            Annotation[] annotations = field.getAnnotations();
        })*/



        return true;
    }
}
