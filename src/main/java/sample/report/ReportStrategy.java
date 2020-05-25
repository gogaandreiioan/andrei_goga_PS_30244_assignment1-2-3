package sample.report;

import sample.dto.PatientDto;

import java.io.IOException;
import java.util.List;


/**
 *
 * ReportStrategy.java
 * Interface class that has the following methods.
 * createReport with
 * @param patients a the list with all the patients
 * And using strategy it create a pdf file using PDFStrategy.java or a csv file using
 * CSVStrategy.java with all the specifications for all the patients
 * @author Goga Andrei
 * @since mm-dd-yyyy
 */

public interface ReportStrategy {
    void createReport(List<PatientDto> patients) throws IOException;
}
