
package collegecostapi.service;

import collegecostapi.model.College;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CollegeCostService {

    List<College> colleges = readCollegesFromCSV("C:\\Users\\User\\Documents\\NetBeansProjects\\CollegeCostAPI\\src\\main\\java\\collegecostapi\\data\\college_costs.csv");

    public College getCollege(String collegeName) {

        for (College college : colleges) {
            if (college.getCollegeName().equals(collegeName)) {
                return college;
            }
        }
        return null;
    }

    public List<College> readCollegesFromCSV(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");

                College college = createCollege(attributes);

                colleges.add(college);

                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return colleges;
    }

    private static College createCollege(String[] metadata) {
        String collegeName = metadata[0];
        int tuitionInState;
        int tuitionOutOfState;
        int roomAndBoard;

        if (metadata[1] == null) {
            tuitionInState = 0;
        } else {
            tuitionInState = Integer.parseInt(metadata[1]);
        }

        if (metadata[2] == null) {
            tuitionOutOfState = 0;
        } else {
            tuitionOutOfState = Integer.parseInt(metadata[2]);
        }
        if (metadata[3] == null) {
            roomAndBoard = 0;
        } else {
            roomAndBoard = Integer.parseInt(metadata[3]);
        }

        return new College(collegeName, tuitionInState, tuitionOutOfState, roomAndBoard);
    }

}
