package com.alex.framework.server.registrar;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alex.framework.server.ClientHandler;
import com.alex.framework.server.SimpleClientHandler;
import com.alex.framework.server.exceptions.NoSuchClientException;
import com.alex.logging.Logger;

public class ClientRegistrar {
	/**
	 * This is a map of all the currently connected clients.
	 * When a client is connected, 
	 */
	private Map<String, ClientHandler> clients;
	
	private static ClientRegistrar singleton;
	
	public static ClientRegistrar get() {
		if ( singleton == null ) {
			Logger.Log("Registrar: Initalising the Registrar for clients.");
			singleton = new ClientRegistrar();
		}
		return singleton;
	}
	
	
	public ClientRegistrar() {
		clients = new HashMap<String, ClientHandler>();
	}
	
	
	/**
	 * A method to register a client.
	 * Returns a guid to be used as an ID token by the client in the future.
	 * @return
	 */
	public String registerClient() {
		UUID uuid = UUID.randomUUID();
		
		// Create a new client handler to deal with this client,
		// store the client handler against this uuid in the map
		// and give the uuid as a string back to the client to use
		// to identify themselves in future.
		
		ClientHandler thisClientsHandler = new SimpleClientHandler();
		
		clients.put(uuid.toString(), thisClientsHandler);
		
		return uuid.toString();
	}
	
	
	public ClientHandler findClient( String clientIDToken ) throws NoSuchClientException {
		if ( clients.containsKey(clientIDToken) )
		{
			return clients.get(clientIDToken);
		} else {
			throw new NoSuchClientException();
		}
	}
}
