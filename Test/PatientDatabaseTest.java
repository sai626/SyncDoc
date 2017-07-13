import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 12/7/17.
 */
public class PatientDatabaseTest {

    PatientDatabase database=new PatientDatabase();

    public PatientDatabaseTest(){
        database.newPatient(new Patient("ABC"),"123");
        database.newPatient(new Patient("DEF"),"456");
        database.newPatient(new Patient("GHI"),"789");
    }

    @Test
    public void checkCredentials() throws Exception {
        assertTrue(database.checkCredentials(new Patient("ABC"),"123"));
        assertFalse(database.checkCredentials(new Patient("DEF"),"123"));
        assertFalse(database.checkCredentials(new Patient("Abc"),"123"));
    }

}