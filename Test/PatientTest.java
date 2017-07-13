import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 12/7/17.
 */
public class PatientTest {
    @Test
    public void getName() throws Exception {
        Patient patient=new Patient("XYZ");

        assertEquals("XYZ",patient.getName());
    }

}