import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Calc calc = new Calc();
        System.out.println("Пожалуюста введите операции");
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        try {
            String result = calc.calc(str);
            System.out.println(str + " = " + result);
        } catch (IncorrectDataException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Извините произашло ошибка");
        }
    }
}
