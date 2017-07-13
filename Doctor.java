import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by zemoso on 11/7/17.
 */

/**
 * The doctor class handles all the work related to doctor. It stores doctor's name and a list of his
 * appointments. One can check if the doctor is free at a particular time and also book an appointment.
 */
public class Doctor {

    private String name;
    private List<Appointment> appointments;

    /**
     * Constructor which sets the doctor's name. It also initializes the List of appointments.
     * @param name Name of the doctor.
     */
    public Doctor(String name) {
        this.name = name;
        appointments = new ArrayList<>();
    }

    /**
     * Returns the name of the doctor
     * @return The name of the doctor
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the doctor is free for booking at the specified time for specified duration
     * @param time A calendar object denoting the time of appointment
     * @param duration Duration of appointment
     * @return true if the doctor can book the appointment without clashing with previous bookings,
     * false otherwise
     */
    public boolean isFree(Calendar time, int duration) {
        if (appointments.size()>0) {

            for (Appointment details : appointments) {
                long appointmentStart = details.getTime().getTimeInMillis();
                long appointmentEnd = details.getTime().getTimeInMillis()+details.getDuration()*60*1000;

                long scheduleStart=time.getTimeInMillis();
                long scheduleEnd=time.getTimeInMillis()+duration*60*1000;

                if ((scheduleStart>=appointmentStart && scheduleStart<appointmentEnd) ||
                        (scheduleEnd>appointmentStart && scheduleEnd<=appointmentEnd) ||
                        (scheduleStart<=appointmentStart && scheduleEnd>=appointmentEnd)){
                    return false;
                }
            }
            return true;
        }else {
            return true;
        }
    }

    /**
     * Book an appointment to the doctor. The isFree() method must be called before this, and only call this
     * method if and only if the isFree() method returns true. Otherwise appointments may clash.
     * @param patient The patient object
     * @param time Time of appointment
     * @param duration Duration of appointment
     * @return An object of Appointment class which contains all the details of the appointment.
     */
    public Appointment add(Patient patient, Calendar time, int duration) {
        Appointment book = new Appointment(patient, this,(Calendar) time.clone(), duration);
        appointments.add(book);
        return book;
    }

    /**
     * This method overrides the default equals method of object class.
     * @param obj The doctor object with which equality testing needs to carried out
     * @return true if both the object have same name, otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        return name.equals(((Doctor)obj).getName());
    }
}
