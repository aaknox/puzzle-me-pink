package com.azhya.utilities;

import com.azhya.models.ClientMessage;

public class ClientMessageUtil {

	public static final ClientMessage LOGIN_SUCCESSFUL = new ClientMessage("Login successful for given username/password combination.");
	public static final ClientMessage LOGIN_FAILED = new ClientMessage("Sorry, invalid username and/or password.");
	public static final ClientMessage REGISTATION_SUCCESSFUL = new ClientMessage("Success! Your player profile is now complete!");
	public static final ClientMessage REGISTATION_FAILED = new ClientMessage("Something went wrong during registration.");
	public static final ClientMessage CREATION_SUCCESSFUL = new ClientMessage("Creation was successful!");
	public static final ClientMessage CREATION_FAILED = new ClientMessage("Something went wrong during creation.");
	public static final ClientMessage UPDATE_SUCCESSFUL = new ClientMessage("Update was successful!");
	public static final ClientMessage UPDATE_FAILED = new ClientMessage("Something went wrong during update.");
	public static final ClientMessage DELETION_SUCCESSFUL = new ClientMessage("Deletion was successful!");
	public static final ClientMessage DELETION_FAILED = new ClientMessage("Something went wrong during deletion.");
	public static final ClientMessage VERIFICATION_SUCCESSFUL = new ClientMessage("Verification was successful!");
	public static final ClientMessage VERIFICATION_FAILED = new ClientMessage("Something went wrong while verifying the player's email.");
}
