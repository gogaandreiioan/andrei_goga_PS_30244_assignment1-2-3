package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import sample.entity.Patient;


/** PatientRepository.java
 * Interface class that has the following methods.
 * updatePatientAddress change the current address for a patien that has the personalNumber = @Param("personalNumber")
 * with a value = @Param("newAddress")
 *
 *
 * @author Goga Andrei
 * @since 23-05-2020
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByPersonalNumber(Long personalNumber);
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.address = :newAddress WHERE p.personalNumber = :personalNumber")
    void updatePatientAddress(@Param("newAddress") String newAddress, @Param("personalNumber") Long personalNumber);


}
