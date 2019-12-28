package com.jtelegram.api.requests.framework;

import com.google.gson.*;
import com.jtelegram.api.TelegramBotRegistry;
import com.jtelegram.api.ex.InvalidResponseException;
import com.jtelegram.api.ex.NetworkException;
import com.jtelegram.api.ex.TelegramException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractTelegramRequest<T> implements TelegramRequest<T> {
    // utility field
    protected transient static Gson gson = TelegramBotRegistry.GSON;
    private transient final String endPoint;
    protected transient final Consumer<TelegramException> errorHandler;

    protected T getBody(HttpResponse<T> response) throws IOException {
        return response == null ? null : response.body();
    }

    protected JsonElement validate(String response) throws IOException {
        JsonParser parser = new JsonParser();
        JsonElement jsonResponse;

        try {
            jsonResponse = parser.parse(response);
        } catch (JsonSyntaxException ex) {
            if (errorHandler != null) {
                errorHandler.accept(new InvalidResponseException());
            }

            return null;
        }

        if (jsonResponse.isJsonObject()) {
            JsonObject object = jsonResponse.getAsJsonObject();

            if (!object.get("ok").getAsBoolean()) {
                // todo convert to good exceptions
                if (errorHandler != null) {
                    errorHandler.accept(gson.fromJson(response, TelegramException.class));
                }
                return null;
            }

            return object.get("result");
        }

        return null;
    }

    @Override
    public String getEndPoint() {
        return endPoint;
    }

    @Override
    public String serialize() {
        return gson.toJson(this);
    }

    @Override
    public void handleException(IOException ex) {
        if (errorHandler != null) {
            errorHandler.accept(new NetworkException(ex));
        }
    }
}
