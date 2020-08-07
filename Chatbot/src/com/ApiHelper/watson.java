package com.ApiHelper;

import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.RuntimeResponseGeneric;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.RuntimeIntent;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import java.util.List;
import java.util.logging.LogManager;

public class watson {
    public static Authenticator authenticator;
    public static Assistant service;
    public static String assistantId;
    public static  CreateSessionOptions createSessionOptions;
    public static SessionResponse session;
    public static String sessionId;

  public watson()  {

    // Suppress log messages in stdout.
    LogManager.getLogManager().reset();

    // Set up Assistant service.
    authenticator = new IamAuthenticator("YJITEf0TJLwL-d_GPeJuKlSMEkRzN6RQlitTEirI4MsT"); // replace with API key
    service = new Assistant("2019-02-28", authenticator);
    assistantId = "8d21672c-de0b-4fac-9c7f-065755153b8d"; // replace with assistant ID
    service.setServiceUrl(" https://api.au-syd.assistant.watson.cloud.ibm.com/instances/6dd0c11c-238d-4c27-a964-2af89054a00e/");
    // Create session.
    createSessionOptions = new CreateSessionOptions.Builder(assistantId).build();
    session = service.createSession(createSessionOptions).execute().getResult();
    sessionId = session.getSessionId();

    // Initialize with empty message to start the conversation.
    MessageInput input = new MessageInput.Builder()
      .messageType("text")
      .text("")
      .build();
    
      MessageOptions messageOptions = new MessageOptions.Builder(assistantId, sessionId)
        .input(input)
        .build();
      MessageResponse response = service.message(messageOptions).execute().getResult();

      // If an intent was detected, print it to the console.
      List<RuntimeIntent> responseIntents = response.getOutput().getIntents();
      if(responseIntents.size() > 0) {
        System.out.println("Detected intent: #" + responseIntents.get(0).intent());
      }

      // Print the output from dialog, if any. Assumes a single text response.
      List<RuntimeResponseGeneric> responseGeneric = response.getOutput().getGeneric();
      if(responseGeneric.size() > 0) {
        if(responseGeneric.get(0).responseType().equals("text")) {
         String ans=responseGeneric.get(0).text();
        }
      }

  }
  public String getMessage(String userInput){
	  String ans=" ";
	    MessageInput input = new MessageInput.Builder()
	    	      .messageType("text")
	    	      .text(userInput)
	    	      .build();		
	  MessageOptions messageOptions = new MessageOptions.Builder(assistantId, sessionId)
    	        .input(input)
    	        .build();
    	      MessageResponse response = service.message(messageOptions).execute().getResult();

    	      // If an intent was detected, print it to the console.
    	      List<RuntimeIntent> responseIntents = response.getOutput().getIntents();
    	      if(responseIntents.size() > 0) {
    	        System.out.println("Detected intent: #" + responseIntents.get(0).intent());
    	      }

    	      // Print the output from dialog, if any. Assumes a single text response.
    	      List<RuntimeResponseGeneric> responseGeneric = response.getOutput().getGeneric();
    	      if(responseGeneric.size() > 0) {
    	        if(responseGeneric.get(0).responseType().equals("text")) {
    	          ans=responseGeneric.get(0).text();
    	        }
    	      }
    	 return ans;
  }
  public void deleteSession(){
	    DeleteSessionOptions deleteSessionOptions = new DeleteSessionOptions.Builder(assistantId, sessionId).build();
	    service.deleteSession(deleteSessionOptions).execute();
  }
}
