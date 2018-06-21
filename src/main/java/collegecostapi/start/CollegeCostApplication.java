
package collegecostapi.start;

import collegecostapi.model.College;
import collegecostapi.service.CollegeCostService;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("collegecostapi")
@SpringBootApplication
public class CollegeCostApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeCostApplication.class, args);
//                CollegeCostService service = new CollegeCostService();
//                List<College> colleges = service.readCollegesFromCSV("C:\\Users\\User\\Documents\\NetBeansProjects\\CollegeCostAPI\\src\\main\\java\\collegecostapi\\data\\college_costs.csv");
//                System.out.println(colleges.get(45).getCollegeName());
//                System.out.println(colleges.get(0).getCollegeName());
	}
}

