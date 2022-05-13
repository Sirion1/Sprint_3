package courier;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class Courier {
    private String login;
    private String password;
    private String firstName;

    public Courier (String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public static Courier getRandom () {
        String login = RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomAlphabetic(10);
        String firstName = RandomStringUtils.randomAlphabetic(10);

        return new Courier(login, password, firstName);
    }

    public static Courier getRandomLogin() {
        String login = RandomStringUtils.randomAlphabetic(10);

        return new Courier(login, null, null);
    }

}
