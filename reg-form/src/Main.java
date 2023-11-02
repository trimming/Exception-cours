import model.User;
import service.DataService;
import service.WriteUserData;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DataService service = new DataService();
        service.createUser();
    }
}