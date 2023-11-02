package service;

import model.*;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class DataService {

    static Scanner scanner = new Scanner(System.in);
    MakeRequestToUser request;
    CheckAnswer checkAnswer;
    boolean stage;

    public DataService() {
        this.request = new MakeRequestToUser(scanner);
//        this.checkAnswer = new CheckAnswer(request.getMakeUserAnswer());
        this.stage = true;
    }

    public void createUser(){
        while(stage){
            try {

                checkAnswer = new CheckAnswer(request.getMakeUserAnswer());
                String name = checkAnswer.parseUserAnswerToName();
                Date birthDate = checkAnswer.parseUserAnswerToBirthDate();
                Long telNumber = checkAnswer.parseUserAnswerToTelNumber();
                Character gender = checkAnswer.parseUserAnswerToGender();
                stage = checkAnswer.parseUserAnswerToQuit();
                if (name == null) throw new AssertionError("Данные не могут быть записаны, т.к. некорректное значение имени!");

                WriteUserData writeUserData = new WriteUserData(new User(name, birthDate, telNumber, gender));
                writeUserData.writeFile();

            }
            catch(AssertionError e){
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
