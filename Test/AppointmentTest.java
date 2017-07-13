
import org.testng.annotations.Test;

import java.util.Calendar;
import static org.junit.Assert.*;

/**
 * Created by zemoso on 12/7/17.
 */
public class AppointmentTest {

    Patient patient =new Patient("XYZ");
    Doctor doctor =new Doctor("ABC");
    Calendar cal=Calendar.getInstance();
    Appointment appointment;

    public AppointmentTest(){
        cal.set(2017,Calendar.APRIL,1,00,00);
        appointment=new Appointment(patient, doctor,cal,20);
    }


    @Test
    public void getDoctor() throws Exception {

        assertEquals(new Doctor("ABC"),appointment.getDoctor());
    }

    @Test
    public void getPatient() throws Exception {
        assertEquals(new Patient("XYZ"),appointment.getPatient());
    }

    @Test
    public void getTime() throws Exception {
        assertEquals(cal,appointment.getTime());
    }

    @Test
    public void getDuration() throws Exception {
        assertEquals(20,appointment.getDuration());
    }

}