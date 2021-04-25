package matchmaker.db;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import matchmaker.models.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Repository {

    public List<User> getAllUsers() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader userJson = new JsonReader(new FileReader("src/main/resources/data.json"));
        User[] userArray = gson.fromJson(userJson, User[].class);
        return Arrays.asList(userArray);
    }
}
