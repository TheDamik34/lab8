package zad2;

public class EqualsClass {
    private String name;
    private boolean isFresh;
    private Integer age;
    private double money;

    public String getName() {
        return name;
    }

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
}
