package me.rizqy.amikomdispatch;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * Created by Rizqy on 19/05/2017.
 */

public class ApiClient {
    private static final String BASE_URL = "http://amikom-dispatch.rizqy.me/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void getContent(Integer id, AsyncHttpResponseHandler responseHandler) {
        client.get(String.format("%scontent/%s", BASE_URL, id.toString()), null, responseHandler);
    }
}
