package twitter.lld.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum AccountType {

	GUEST(Permission.VIEW),
	USER(Permission.VIEW, Permission.POST),
	//CELEBRITY(Permission.VIEW, Permission.POST),
	TECHOPS(Permission.VIEW, Permission.POST, Permission.MODIFY, Permission.DELETE);
	
	List<Permission> permissions;

	private AccountType(Permission... permissions) {
		this.permissions = new ArrayList<>(Arrays.asList(permissions));
	}

	public boolean hasPermission(Permission p) {
		return permissions.contains(p);
	}
	
	
}
