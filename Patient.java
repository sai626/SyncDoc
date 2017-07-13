/**
 * Created by zemoso on 11/7/17.
 */

/**
 * This class is the basic Patient class. It contains the patient's name and a getter to get the name.
 */
public class Patient {

    private String name;

    /**
     * Contructor. It sets the patients name
     * @param name The name of the patient
     */
    public Patient(String name) {
        this.name = name;
    }

    /**
     * Returns the Patient's name
     * @return The patient's name
     */
    public String getName() {
        return name;
    }

    /**
     * This method overrides the default equals method of object class.
     * @param obj The patient object with which equality testing needs to carried out
     * @return true if both the object have same name, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        return name.equals(((Patient)obj).getName());
    }

    /**
     * This method overrides the defalut hashCode method of object class. It is overridden so that
     * patients with same name produce same hashcode. This is done to provide consistency to hash map
     * so that different object with same patient name have only one password.
     * @return
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
