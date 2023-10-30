import model.CheckAnswer;
import model.MakeRequestToUser;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = null;
        MakeRequestToUser request = new MakeRequestToUser(scanner);
        CheckAnswer checkAnswer = new CheckAnswer(request.getMakeUserAnswer());
        System.out.println(checkAnswer.parseUserAnswerToGender());

        System.out.println(checkAnswer.parseUserAnswerToName());
        System.out.println(checkAnswer.parseUserAnswerToTelNumber());
        System.out.println(checkAnswer.parseUserAnswerToBirthDate());
    }
}