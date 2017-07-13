import java.util.Calendar;

/**
 * Created by zemoso on 11/7/17.
 */

/**
 * The basic data storing class. It contains all the information regarding an appointment and provide
 * methods to get those information.
 */
public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private Calendar time;
    private int duration;

    /**
     * The constructor. It sets the values of all the fields.
     * @param patient The Patient
     * @param doctor The Doctor
     * @param time Time of appointment
     * @param duration duration of appointment
     */
    public Appointment(Patient patient, Doctor doctor, Calendar time, int duration) {
        this.patient = patient;
        this.time = time;
        this.duration = duration;
        this.doctor=doctor;
    }

    /**
     * Returns the Doctor object.
     * @return The Doctor object
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Returns the Patient object
     * @return The Patient object
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Returns the time of appointment
     * @return The time of the appointment
     */
    public Calendar getTime() {
        return time;
    }

    /**
     * Returns the duration of the appointment
     * @return The duration of the appointment
     */
    public int getDuration() {
        return duration;
    }

    /**
     * This method overrides the default equals method of object class.
     * @param obj The appointment object with which equality testing needs to carried out
     * @return true if both the object have same values, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        Appointment temp=(Appointment)obj;

        if(patient.equals(temp.getPatient()) && doctor.equals(temp.getDoctor())
                && time.getTimeInMillis()==temp.getTime().getTimeInMillis() && duration==temp.getDuration()){
            return true;
        }
        return false;
    }
}
