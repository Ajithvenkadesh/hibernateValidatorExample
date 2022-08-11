package assignee.controller;

import assignee.model.Assignee;
import assignee.service.AssigneeService;
import assignee.service.implementation.AssigneeImplementation;
import com.validation.Validator;
import javax.ws.rs.*;
import java.util.ArrayList;

/**
 * Invokes the Services available for Assignee.
 * 
 * @author Ajith venkadesh
 * @version 1.0
 */
public class AssigneeController {
	private final static AssigneeService ASSIGNEESERVICE = new AssigneeImplementation();
	private final static Validator VALIDATOR = new Validator();
		
	/**
	 * Creates new assignee record.
	 * 
	 * @param assignee Model of assignee.
	 * @return Success or failure message.
	 */
	@Path("/")
	@Consumes("application/json")
	@POST
	public String createAssignee(final Assignee assignee) {
		if (!VALIDATOR.validateName(assignee.getAssigneeName())) {
			return "invalid details";
		} else {
			return ASSIGNEESERVICE.create(assignee);
		}
	}

	/**
	 *Deletes an existing assignee record.
	 * 
	 * @param assignee Model of the assignee.
	 * @return Success or failure message.
	 */
	@Path("/")
	@Consumes("application/json")
	@DELETE
	public String deleteAssignee(final Assignee assignee) {
		if (VALIDATOR.validateAssigneeId(assignee.getAssigneeId())) {
			return ASSIGNEESERVICE.delete(assignee);
		} else {
			return "invalid details";
		}
	}
	
	/**
	 * Updates an existing assignee record.
	 * 
	 * @param assignee Model of the assignee.
	 * @return Success or failure message.
	 */
	@Path("/")
	@Consumes("application/json")
	@PUT
	public String updateAssignee(final Assignee assignee) {
		if (VALIDATOR.validateAssigneeId(assignee.getAssigneeId())) {
			return ASSIGNEESERVICE.update(assignee);
		} else {
			return "invalid details";
		}
	}
	
	/**
	 * Search a particular assignee record.
	 * 
	 * @param id Id of the assignee.
	 * @return Required assignee record.
	 */
	@Path("/{id}")
	@Produces("application/json")
	@GET
	public Assignee get(@PathParam("id") final int id) {
		return ASSIGNEESERVICE.search(id);
	}


}
