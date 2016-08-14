package com.github.giepe.messenger.database;

import com.github.giepe.messenger.model.Message;
import com.github.giepe.messenger.model.Profile;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Piotrek on 2016-08-14.
 */
public class DatabaseClassTest {
    private Map<Long, Message> messages;
    private LinkedHashMap<String, Profile> profiles;

    @Before
    public void setUp() {
        messages = DatabaseClass.getMessages();
        profiles = DatabaseClass.getProfiles();
    }

    @Test
    public void getMessages() throws Exception {
        Message message1 = new Message(1, "message 1", "author 1", new Date());
        Message message2 = new Message(2, "message 2", "author 2", new Date());

        messages.put(1L, message1);
        messages.put(2L, message2);

        assertEquals("Invalid number of messages", 2, messages.size());
        assertEquals("Messages should be equal, but is not", message1.getMessage(), messages.get(1L).getMessage());
        assertEquals("Messages should be equal, but is not", message2.getMessage(), messages.get(2L).getMessage());
    }

    @Test
    public void getProfiles() throws Exception {
        Profile profile1 = new Profile(1L, "profile 1", "John", "Doe");
        Profile profile2 = new Profile(2L, "profile 2", "Adam", "Smith");

        profiles.put("first", profile1);
        profiles.put("second", profile2);

        assertEquals("Invalid number of profiles", 2, profiles.size());
        assertEquals("Profiles name should be equal, but is not", profile1.getProfileName(), profiles.get("first").getProfileName());
        assertEquals("Profiles name should be equal, but is not", profile2.getProfileName(), profiles.get("second").getProfileName());
    }

}