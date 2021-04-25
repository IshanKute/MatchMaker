package matchmaker;

import matchmaker.db.Repository;
import matchmaker.input.InputReader;
import matchmaker.input.PropertyReader;
import matchmaker.input.UserBuilder;
import matchmaker.models.Score;
import matchmaker.models.User;
import matchmaker.util.Console;
import matchmaker.util.Util;

import java.io.FileNotFoundException;
import java.util.List;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        List<User> data = new Repository().getAllUsers();
        Console console = new Console();
        Util util = new Util(console);
        InputReader inputReader = new InputReader(console, util);
        PropertyReader propertyReader = new PropertyReader(inputReader, util, console);
        UserBuilder userBuilder = new UserBuilder(propertyReader);

        MatchMaker matchMaker = new MatchMaker(userBuilder, data);
        User user = matchMaker.getUser();
        List<User> hardRulesFilteredUsers = matchMaker.getHardRulesFilteredUsers(user);
        List<Score> result = matchMaker.getMatchingUsers(hardRulesFilteredUsers, user);
        util.printResult(result);
    }
}
