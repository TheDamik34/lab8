package zad2;

import java.lang.reflect.Field;
import java.util.Arrays;


public class EqualsClass {
    private String name = "damian";
    @IgnoreEquals
    private boolean isRich = true;
    private Integer age = 0;
    private double money = 0;

    public String getName() {
        return name;
    }

    @Deprecated
    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRich() {
        return isRich;
    }

    public void setRich(Boolean rich) {
        isRich = rich;
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
        return this.getName().equals(temp.getName()) && this.getMoney() == temp.getMoney() && this.getAge().equals(temp.getAge());
    }

    public boolean equals2(Object obj) {
        if(!(obj instanceof EqualsClass))
            return false;

        EqualsClass temp = (EqualsClass) obj;

        Class cls = this.getClass();
        Field[] fieldsThis = cls.getDeclaredFields();
        Field[] fieldsObj = cls.getDeclaredFields();

        Field[] filteredFieldsIgnoreThis = Arrays.stream(fieldsThis).filter(field -> field.getAnnotation(IgnoreEquals.class) == null).toArray(Field[]::new);
        Field[] filteredFieldsIgnoreObj = Arrays.stream(fieldsObj).filter(field -> field.getAnnotation(IgnoreEquals.class) == null).toArray(Field[]::new);

        try {
            return  filteredFieldsIgnoreThis[0].get(this).equals(filteredFieldsIgnoreObj[0].get(temp)) &&
                    filteredFieldsIgnoreThis[1].get(this).equals(filteredFieldsIgnoreObj[1].get(temp)) &&
                    filteredFieldsIgnoreThis[2].get(this).equals(filteredFieldsIgnoreObj[2].get(temp));

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }
}
