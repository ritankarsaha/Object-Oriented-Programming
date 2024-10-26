package hospitall;
import java.util.*;
class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;
  

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
   
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

   

    public void viewDoctors() {
        System.out.println("Doctors at " + name + " Hospital:");
        for (Doctor doctor : doctors) {
            System.out.println("- Dr. " + doctor.getName() + " (" + doctor.getSpecialization() + ")");
        }
    }

    public void viewPatients() {
        System.out.println("Patients at " + name + " Hospital:");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getName() + ", Ailment: " + patient.getIllness());
        }
    }

    public Patient findPatientByName(String patientName) throws PatientNotFoundException {
        for (Patient patient : patients) {
            if (patient.getName().equals(patientName)) {
                return patient;
            }
        }
        throw new PatientNotFoundException("Patient " + patientName + " not found.");
    }
}
