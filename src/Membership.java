import java.util.ArrayList;

public class Membership {
	public static ArrayList<Membership> members = new ArrayList<>();//Membership array. Membership details (email, memberID)
	static int running = 1;
	int memberID;
	String email;
	Membership(String email){
		this.memberID = running++; //Member ID is generated
		this.email = email;
	}
	Membership(){
		this.memberID = running++;
	}
	public void addMember() 		//Add members to the array
	{
		members.add(this);
	}
	public static boolean isMember(int memberID) {//Is member construct, if the memberID matches to the one in the array, return true.
		for (Membership i : members)
			if (i.memberID == memberID)
				return true;
		return false;
	}
}
