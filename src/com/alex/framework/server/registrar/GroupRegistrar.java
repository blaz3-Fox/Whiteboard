package com.alex.framework.server.registrar;

import java.util.HashMap;

import com.alex.framework.server.Group;
import com.alex.framework.server.exceptions.CouldNotCreateGroup;

/**
 * A class for managing access to the group store objects.
 * Can get groups by group name.
 * Replication of groups can occur across different servers.
 * Different replicated groups should be kept in sync through the javagroups library.
 * @author Alex
 *
 */
public class GroupRegistrar {
	private static HashMap<String, Group> groups;
	
	public static Group getGroup( String groupName ) throws CouldNotCreateGroup {
		// If the groups map doesn't exist, create it.
		if ( groups == null ) {
			groups = new HashMap<String,Group>();
		}
		
		// If the group we are after doesn't exist, create one.
		if ( groups.containsKey(groupName) ) {
			return groups.get(groupName);
		} else {
			Group newGroup;
			try {
				newGroup = new Group(groupName);
				groups.put(groupName, newGroup);
				return newGroup;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// If we got to here without returning anything, throw an exception.
		throw new CouldNotCreateGroup();
	}

	
}
