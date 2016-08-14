package com.github.giepe.messenger.database;

import com.github.giepe.messenger.model.Message;
import com.github.giepe.messenger.model.Profile;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Piotrek on 25.06.15.
 */
public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static LinkedHashMap<String, Profile> profiles = new LinkedHashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static LinkedHashMap<String, Profile> getProfiles() {
        return profiles;
    }
}
