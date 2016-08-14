package com.github.giepe.messenger.resources;

import com.github.giepe.messenger.model.Profile;
import com.github.giepe.messenger.services.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Piotrek on 28.06.15.
 */
@Path("/profiles")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ProfileResource {
    ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getProfiles() {
        return profileService.getAllProfiles();
    }

    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return profileService.getProfile(profileName);
    }

    @POST
    public String addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }

    @PUT
    public String updateProfile(Profile profile) {
        return profileService.updateProfile(profile);
    }

    @DELETE
    public String deleteProfile(Profile profile) {
        return profileService.deleteProfile(profile.getProfileName());
    }
}
