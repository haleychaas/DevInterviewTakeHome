package collegecostapi.controller;

import collegecostapi.model.College;
import collegecostapi.service.CollegeCostService;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/college")
public class CollegeCostController {

    NumberFormat formatter = new DecimalFormat("#0.00");

    @Autowired
    public CollegeCostService collegeCostService;

    @GET
    public Response getCollegeCost(@QueryParam("collegeName") String collegeName,
            @DefaultValue("false") @QueryParam("roomAndBoard") Boolean roomAndBoard) throws EntityNotFoundException, Exception {
        if (collegeName == null || collegeName.isEmpty()) {
            throw new Exception("Error: College name is required");
        }

        if (roomAndBoard) {
            String response = "Tuition + room and board for " + collegeName
                    + " is $" + formatter.format(collegeCostService.getCollege(collegeName).getTuitionInState()
                            + collegeCostService.getCollege(collegeName).getRoomAndBoard());
            return Response.status(200).entity(response).build();
        } else {
            String response = "Tuition for " + collegeName + " is $"
                    + formatter.format(collegeCostService.getCollege(collegeName).getTuitionInState());
            return Response.status(200).entity(response).build();
        }
    }

}

//    @RequestMapping(value = "/college/{collegeName}")
//    public int getCollegeCost(@PathVariable String collegeName) {
//
//        return collegeCostService.getCollege(collegeName).getTuitionInState();
//    }
//    @RequestMapping(value = "/college/{collegeName}/{roomAndBoard}")
//    public int getCollegeCost(@PathVariable String collegeName, @PathVariable Boolean roomAndBoard) {
//        return collegeCostService.getCollege(collegeName).getTuitionInState()
//                + collegeCostService.getCollege(collegeName).getRoomAndBoard();
//    }

