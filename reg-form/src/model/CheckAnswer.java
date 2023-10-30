package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import static java.lang.Long.parseLong;


public class CheckAnswer {

    String[] answerUserArray;
    UserAnswer answer;

    public CheckAnswer(UserAnswer answer) {
        this.answer = answer;
    }

    public String[] getAnswerUserArray() {
        try {
            answerUserArray = answer.getAnswer().split(" ");
            if (answerUserArray.length < 6) {
                throw new InsufficientDataException("Недостаточно данных!");
            }
            if (answerUserArray.length > 6) {
                throw new ExtraInfoException("Лишняя информация!");
            }
            return answerUserArray;
        } catch (InsufficientDataException | ExtraInfoException e) {
            System.out.println(e.getMessage());
        }
        return answerUserArray;
    }

    public Character parseUserAnswerToGender(){
        String[] answers = getAnswerUserArray();
        Character gender = null;
        try {
            for (String answer : answers) {
                if (answer.equals("f") || answer.equals("m")) {
                    gender = answer.charAt(0);
                }
            }
            if(gender == null){
                throw new ParseGenderException("Отсутствует значение пола!");
            } else {
                return gender;
            }
        }
        catch(ParseGenderException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Long parseUserAnswerToTelNumber() {
        String[] answers = getAnswerUserArray();
        Long telNumber = null;
        try{
            boolean res = true;
            for(String answer: answers) {
                res = answer.matches("\\d+");
                if (res) {
                    telNumber = Long.parseLong(answer);
                    return telNumber;
                } else {
                    continue;
                }
            }
            throw new ParseTelNumberException("Некорректный номер телефона!");
        }
        catch (ParseTelNumberException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String parseUserAnswerToName(){
        String[] answers = getAnswerUserArray();
        StringBuilder name = new StringBuilder();
        try{
            boolean res = true;
            for (String s : answers) {
                res = s.matches("[a-zA-zА-Яа-я]+");
                if (res && s.length() > 1) {
                    name.append(s).append(" ");
                }
            }
            if(name.toString().split(" ").length != 3){
                throw new ParseNameException("Некорректное значение имени!");
            } else {
                return name.toString();
            }
        }
        catch (ParseNameException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Date parseUserAnswerToBirthDate(){
        String[] answers = getAnswerUserArray();
        Date birthDate = null;
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try{
            boolean res = true;
            for(String s: answers){
                res = s.matches("\\d{2}.\\d{2}.\\d{4}");
                if(res){
                    birthDate = format.parse(s);
                    return birthDate;
                } else {
                    continue;
                }
            }
            throw new ParseBirthDateException("Некорректная дата дня рождения!");
        } catch (ParseBirthDateException | java.text.ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
