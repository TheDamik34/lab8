package zad2;

public @interface Autor {
    String autor();
    int iq() default 1;
    char[] znaki();
}
