package assignee.service.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import assignee.model.Assignee;
import assignee.service.AssigneeService;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Provides implementation for Assignee service interface.
 * 
 * @author Ajith venkadesh.
 * @version 1.0
 *
 */
public class AssigneeImplementation implements AssigneeService {
	public static final ArrayList<Assignee> ASSIGNEELIST = new ArrayList<Assignee>();
    private static final AtomicInteger ASSIGNEEID = new AtomicInteger(0);
	
	/**
	 * Generates assignee id automatically and in sequence.
	 * 
	 * @return Id of the assignee.
	 */
	public int generateAssigneeId() {
		return ASSIGNEEID.incrementAndGet();
	}	
	
	/**
	 * Creates new assignee by getting inputs from user.
	 * 
	 * @param assignee Object of class assignee.
	 * @return success or failure message.
	 */
	public String create(final Assignee assignee) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Assignee>> constraintViolations = validator.validate(assignee);

		for(ConstraintViolation constraintViolation : constraintViolations) {
			String fieldName = constraintViolation.getPropertyPath().toString();
			System.out.println(fieldName + " " + constraintViolation.getMessage());
		}
		ASSIGNEELIST.add(assignee);
		return "New assignee created successfully and id is" +  assignee.getAssigneeId();
	}
	
	/**
	 * Deletes a particular assignee by using assignee id.
	 * 
	 * @param assignee Id of the assignee.
	 * @return success or failure message.
	 */
	public String delete(final Assignee assignee) {
		final Iterator<Assignee> currentAssignee = ASSIGNEELIST.iterator();
								
		while (currentAssignee.hasNext()) {
			final Assignee assigneeToBeDeleted = currentAssignee.next();
			
			if (assigneeToBeDeleted.getAssigneeId() == assignee.getAssigneeId()) {
				currentAssignee.remove();
				return "Deleted successfully";
			} 
		}
		return "Record not found";
	}
	
	/**
	 * Updates a particular assignee by using assignee id.
	 * 
	 *
	 * @return success or failure message.
	 */
	public String update(final Assignee assignee){
		for (final Assignee assignee1 : ASSIGNEELIST) {
			if (assignee1.getAssigneeId() == assignee.getAssigneeId()) {
				if (!assignee.getAssigneeName().equals("no")) {
					assignee1.setAssigneeName(assignee.getAssigneeName());
					return "Assignee name updated";
				}
			} 
		}
		return "Assignee name not updated";
	}
	
	/**
	 * Searches a particular assignee by using assignee id.
	 * 
	 * @param id Id of the assignee.
	 * @return Required assignee record.
	 */
	public Assignee search(final int id) {
		for (final Assignee assignee : ASSIGNEELIST) {
			if (assignee.getAssigneeId() == id) {
				return assignee;
			}
		}
		return null;
	}
}
