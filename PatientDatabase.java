import java.util.HashMap;
import java.util.Map;

/**
 * Created by zemoso on 11/7/17.
 */

/**
 * This class holds the credential database of the patients. It stores their password in a Map.
 */
public class PatientDatabase {

    private Map<Patient, String> database;

    /**
     * Constructor. It initializes the HashMap.
     */
    public PatientDatabase() {
        database = new HashMap<>();
    }

    /**
     * This method checks the credentials of the patient. If the password matches with the stored password
     * it returns true
     * @param patient The Patient object
     * @param pass The password to check
     * @return true if the Patient exists in the database and the password provided matches with
     * the stored password, else false is returned.
     */
    public boolean checkCredentials(Patient patient, String pass) {
        if (database.containsKey(patient)) {
            String p = database.get(patient);
            if (p.equals(pass)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to add patient to the database. If the Patient is already present in the
     * database, this method does nothing.
     * @param patient The Patient object
     * @param pass The password to be stored in the database.
     */
    public void newPatient(Patient patient, String pass) {
        if (!database.containsKey(patient)) {
            database.put(patient, pass);
        }
    }
}
