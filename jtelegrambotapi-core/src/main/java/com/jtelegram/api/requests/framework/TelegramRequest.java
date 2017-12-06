package com.jtelegram.api.requests.framework;

import com.jtelegram.api.TelegramBot;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public interface TelegramRequest {
    MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    /**
     * Use GSON to properly serialize the request
     * to send to Telegram's servers. This method
     * exists if there are any special cases or
     * pre-processing required.
     *
     * @return the serialized JSON string
     */
    String serialize();

    default Request.Builder build(TelegramBot bot) {
        return new Request.Builder()
                .url(bot.getRegistry().getApiUrl() + bot.getApiKey() + "/" + getEndPoint())
                .post(RequestBody.create(JSON_MEDIA_TYPE, serialize()));
    }

    /**
     * Get the appropriate endpoint for this request.
     *
     * @return The endpoint
     */
    String getEndPoint();

    /**
     * Handle the response from the server, call any
     * relevant callbacks and do error validation
     *
     * @param response The response
     *
     * @throws IOException If any I/O error occurred
     */
    void handleResponse(Response response) throws IOException;

    /**
     * Handle an exception in the case that an I/O error occured
     *
     * @param ex The exception
     */
    void handleException(IOException ex);

    /*
     * In the case that the request is not successful, the
     * request must handle the error parameters returned.
     * This is especially useful for sending messages.
     *
     * @return Whether or not to call the error handler
     * @see ResponseParameters
     */
    //boolean handleResponseParameters(ResponseParameters parameters);
}
