import model.MakeRequestToUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = null;
        MakeRequestToUser request = new MakeRequestToUser(scanner);
        System.out.println(request.getMakeUserAnswer());
    }
}