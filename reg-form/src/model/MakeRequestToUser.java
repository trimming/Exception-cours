package model;

import java.util.Scanner;

public class MakeRequestToUser implements MakeRequest{
    Scanner scanner;

    public MakeRequestToUser(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public UserAnswer getMakeUserAnswer() {
        System.out.println("Введите через пробел Фамилию Имя Отчество, дату рождения, телефон и пол. Для выхода введите 'q':");
        return new UserAnswer(this.scanner.nextLine());
    }
}
