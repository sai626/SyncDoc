import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 12/7/17.
 */
public class DoctorTest {
    Doctor doctor =new Doctor("ABC");

    @Test
    public void getName() throws Exception {
        assertEquals("ABC",doctor.getName());
    }

    @Test
    public void isFree() throws Exception {
        assertTrue(doctor.isFree(Calendar.getInstance(),10));
    }

    @Test
    public void add() throws Exception {
        Patient patient =new Patient("XYZ");
        Calendar cal=Calendar.getInstance();
        Appointment appointment=new Appointment(patient, doctor,cal,20);

        assertEquals(appointment,doctor.add(patient,cal,20));
    }

}