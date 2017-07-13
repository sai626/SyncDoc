import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by zemoso on 11/7/17.
 */
public class Main {

    public static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy hh:mm a");

    public static void main(String args[]){

        BookingPortal portal=new BookingPortal(10);
        Patient[] patients=new Patient[5];
        Appointment[] appointments=new Appointment[10];
        Calendar cal=Calendar.getInstance();

        patients[0]=portal.createNewPatient("Abc","123");
        patients[1]=portal.createNewPatient("Def","456");
        patients[2]=portal.createNewPatient("Ghi","789");
        //patients[3]=portal.createNewPatient("Jkl","100");


        cal.set(2017,Calendar.AUGUST,1,10,0);
        appointments[0]=portal.bookAppointment(patients[0],"123",cal,15);

        cal.set(2017,Calendar.AUGUST,1,10,0);
        appointments[1]=portal.bookAppointment(patients[1],"456",cal,30);

        cal.set(2017,Calendar.AUGUST,1,11,0);
        appointments[2]=portal.bookAppointment(patients[0],"123",cal,15);

        cal.set(2017,Calendar.AUGUST,1,11,0);
        appointments[3]=portal.bookAppointment(patients[2],"123",cal,15);

        cal.set(2017,Calendar.AUGUST,1,10,15);
        appointments[4]=portal.bookAppointment(patients[2],"789",cal,15);

        cal.set(2017,Calendar.AUGUST,1,10,15);
        appointments[5]=portal.bookAppointment(patients[3],"100",cal,45);

        cal.set(2017,Calendar.AUGUST,1,10,10);
        appointments[6]=portal.bookAppointment(patients[2],"789",cal,60);


        for (Appointment appointment:appointments){
            if (appointment!=null){
                printAppointment(appointment);
            }
        }
    }

    public static void printAppointment(Appointment appointment){
        System.out.println("--------------------------------------------------");
        System.out.println("Patient Name : "+ appointment.getPatient().getName());
        System.out.println("Doctor       : "+ appointment.getDoctor().getName());
        System.out.println("Time         : "+ simpleDateFormat.format(appointment.getTime().getTime()));
        System.out.println("Duration     : "+ appointment.getDuration()+" min");
        System.out.println("--------------------------------------------------\n");
    }
}
