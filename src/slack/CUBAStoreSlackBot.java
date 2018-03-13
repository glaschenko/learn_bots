package slack;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import utils.BotsUtils;

import java.io.IOException;

/*
 * Author: glaschenko
 * Created: 13.03.2018
 */
public class CUBAStoreSlackBot {
    private String name;
    private String icon;
    private String webhookURL;

    public CUBAStoreSlackBot(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public void setWebhookURL(String webhookURL) {
        this.webhookURL = webhookURL;
    }

    public void postMessage(SlackMessage msg) throws IOException {
        JSONObject body = new JSONObject();
        body.put("name", name);
        body.put("icon_emoji", icon);
        body.put("channel", msg.getChannel());
        body.put("text", msg.getText());

        HttpClientBuilder builder = HttpClientBuilder.create();
        HttpClient client = builder.build();
        HttpPost request = new HttpPost(webhookURL);

        StringEntity entity = BotsUtils.wrapToStringEntity(body);

        request.setEntity(entity);
        System.out.println(BotsUtils.readHttpEntity(request.getEntity()));

        HttpResponse response = client.execute(request);
        System.out.println(BotsUtils.readHttpEntity(response.getEntity()));
    }


}
