import java.util.Calendar;

/**
 * Created by zemoso on 11/7/17.
 */

/**
 * This is the main interface of the Facade Design Pattern. It abstracts and delegates most of the job
 * to appropriate objects and only handles the high level management of the work.
 */
public class BookingPortal {

    private PatientDatabase database;
    private Doctor[] doctors;

    /**
     * Constructor. It specifies the number of doctors to create and initializes them.
     * @param noOfDoctors The number of Doctors to create for the booking portal.
     */
    public BookingPortal(int noOfDoctors) {
        database = new PatientDatabase();
        doctors = new Doctor[noOfDoctors];

        for (int i = 0; i < noOfDoctors; i++) {
            doctors[i] = new Doctor("Doctor" + (i + 1));
        }
    }

    /**
     * This method books an appointment. The doctor under whom the booking is done is the first doctor
     * who is free for the specified duration at specified time. It validates the credentials of the patient
     * and attempts to book an appointment.
     * @param patient The Patient object
     * @param pass Password of the Patient.
     * @param time The time of the appointment
     * @param durationInMinutes Duration of the appointment
     * @return An Appointment object containing all the details of the appointment if the appointment was
     * successfully booked, else returns null.
     */
    public Appointment bookAppointment(Patient patient, String pass, Calendar time, int durationInMinutes) {
        Appointment appointment = null;
        if (database.checkCredentials(patient, pass)) {
            for (Doctor doc : doctors) {
                if (doc.isFree(time, durationInMinutes)) {
                    appointment = doc.add(patient, time, durationInMinutes);
                    break;
                }
            }
        }

        return appointment;
    }

    /**
     * This method creates a new Patient object with specified name and stores his password in the database.
     * @param patientName The name of the patient
     * @param pass The password of the patient to be stored
     * @return A reference of the Patient object created
     */
    public Patient createNewPatient(String patientName, String pass) {
        Patient patient = new Patient(patientName);
        database.newPatient(patient, pass);

        return patient;
    }
}
