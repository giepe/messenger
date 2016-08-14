package messenger.services;

import messenger.database.DatabaseClass;
import messenger.model.Profile;
import java.util.*;

/**
 * Created by Piotrek on 28.06.15.
 */
public class ProfileService {
    private LinkedHashMap<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
//        profiles.put("profile1", new Profile(1L, "profile1", "firstName1", "lastName1"));
//        profiles.put("profile2", new Profile(2L, "profile2", "firstName2", "lastName2"));
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<Profile>(profiles.values());
    }

    public String addProfile(Profile profile) {
        StringBuffer message = new StringBuffer();
        message.append("<responseMessage>");
        message.append("<description>");

        long id = profiles.size();
        if (id == 0) {
            id = 1;
        } else {
            id = new LinkedList<Profile>(profiles.values()).getLast().getId() + 1;
        }

        try {
            if (profiles.get(profile.getProfileName()) == null){
                profile.setId(id);
                profiles.put(profile.getProfileName(), profile);
                message.append("Profile id=" + String.valueOf(id) + " added.");
            } else {
                message.append("Profile name=" + profile.getProfileName() + " already exists.");
            }
        } catch (Exception e) {
            message.append("Adding profile failed. " + e.getMessage());
        }
        message.append("</description>");
        message.append("</responseMessage>");
        return message.toString();
    }

    public Profile getProfile(String profileNameOrId) {
        Profile profile = null;
        if (profileNameOrId.equals("")) {
            return null;
        } else if (profileNameOrId.length() > 7 && profileNameOrId.substring(0, 7).equals("profile")) {
                profile = profiles.get(profileNameOrId);
        } else {
            try {
                long profileId = Long.parseLong(profileNameOrId);
                LinkedList<Profile> profilesList = new LinkedList<Profile>(profiles.values());
                for (int i = 0; i < profilesList.size(); i++) {
                    Profile p = profilesList.get(i);
                    if (p.getId() == profileId) {
                        profile = p;
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                profile = profiles.get(profileNameOrId);
            }
        }
        return profile != null ? profile : new Profile();
    }

    public String updateProfile(Profile profile) {
        StringBuffer message = new StringBuffer();
        message.append("<responseMessage>");
        message.append("<description>");

        if (profile == null) {
            message.append("Profile is missing.");
        }
        else if (profile.getProfileName().isEmpty()) {
            message.append("Profile does not exist.");
        }
        else if (profiles.get(profile.getProfileName()) == null) {
            message.append("Profile does not exist.");
        } else {
            long profileId = profiles.get(profile.getProfileName()).getId();
            profile.setId(profileId);
            profiles.put(profile.getProfileName(), profile);
            message.append("Profile id=" + String.valueOf(profileId) + " changed.");
        }
        message.append("</description>");
        message.append("</responseMessage>");
        return message.toString();
    }

    public String deleteProfile(String profileName) {
        StringBuffer message = new StringBuffer();
        message.append("<responseMessage>");
        message.append("<description>");

        Profile profile = this.profiles.get(profileName);
        if (profile != null) {
            profiles.remove(profileName);
            message.append("Profile has been deleted.");
        } else {
            message.append("Profile does not exist.");
        }
        message.append("</description>");
        message.append("</responseMessage>");
        return message.toString();
    }



}
