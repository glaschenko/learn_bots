package slack;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * Author: glaschenko
 * Created: 13.03.2018
 */
public class TestSlackBot {
    @Test
    public void testSendMessage(){
        Properties properties = readProperties();
        String hookURL = (String)properties.get("slack_hook");

        System.out.println("hookURL = " + hookURL);

        CUBAStoreSlackBot bot = new CUBAStoreSlackBot("StoreBot", ":ghost:");
        bot.setWebhookURL(hookURL);
        try {
            bot.postMessage(new SlackMessage("#meistertask", "hey!"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    private Properties readProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("app.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return properties;
    }
}
