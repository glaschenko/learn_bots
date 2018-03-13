package slack;

/*
 * Author: glaschenko
 * Created: 13.03.2018
 */
public class SlackMessage {
    private String channel;
    private String text;

    public SlackMessage(String channel, String text) {
        this.channel = channel;
        this.text = text;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
