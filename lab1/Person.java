package labs.lab1;

/** 
 * Represents a person and their list of friends
 */
public class Person {
    
    // ADD INSTANCE VARIABLES HERE
    private String pname;
    private String friends;
    
    /** 
     * Creates a person with a given name and no friends in their list.
     * 
     * @param name the first name of the person of interest
     */
    public Person(String name) {
        pname = name;
        friends = "";
    }
    
    
    /** 
     * Retrieves the names of all of a person's friends.
     * 
     * @return a string containing all of the names of a person's friends
     */
    public String getFriendNames() {
        return friends; // FIX ME
    }
    
    
    /** 
     * Adds a person to the list of friends of this person.
     * 
     * @param p the person whose name is to be added to the friend list
     */
    public void befriend(Person p) {
        int count = friends.length();

        if (count == 0) {
        	friends += p.pname;
        } else {
        	friends += " " + p.pname;
        }
    }
    
    
    /** 
     * Removes a person from the list of friends of this person.
     * 
     * @param p the person whose name is to be removed from the friend list
     */
    public void unfriend(Person p) {
        friends = friends.replaceAll(p.pname, "");
    }
    
    
    /** 
     * Returns the number of friends a person currently has.
     * 
     * @return a count of the number of friends the person has
     */
    public int getFriendCount() {
    	String[] strarr = friends.split(" ");

        return strarr.length; // FIX ME
    }
}
