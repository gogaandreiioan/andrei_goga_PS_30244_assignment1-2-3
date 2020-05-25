package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sample.entity.Consultation;
import sample.entity.Patient;
import sample.entity.User;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


/**
 *
 * ConsultationRepository.java
 * Interface class that has the following methods.
 * updateDescription change the current description for the Consultation that has the id = @Param("id")
 * with a value = @Param("newDescription")
 *
 * @author Goga Andrei
 * @since 23-05-2020
 */
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Consultation findByDateOfConsultationAndDoctorAndPatient(Date dateOfConsultation, User doctor, Patient patient);
    List<Consultation> findByPatientAndDateOfConsultationBefore(Patient patient, Date date);
    @Transactional
    @Modifying
    @Query("UPDATE Consultation c SET c.description = :newDescription WHERE c.id = :id")
    void updateDescription(@Param("newDescription") String newDescription, @Param("id") Long id);
}
