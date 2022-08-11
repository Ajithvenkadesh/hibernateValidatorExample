package assignee.service;

import assignee.model.Assignee;
import java.util.ArrayList;

/**
 * Provides the services available for assignee.
 *  
 * @author Ajith venkadesh
 * @version 1.0
 */
public interface AssigneeService {
	
	/**
	 * Creates new assignee.
	 * 
	 *
	 * @return Id of the newly created assignee.
	 */
	String create(final Assignee assignee);
			
	/**
	 * Deletes a particular assignee by using assignee id.
	 * 
	 * @param assignee Model of the assignee.
	 * @return Success or failure message.
	 */
	String delete(final Assignee assignee);
	
	/**
	 * Updates a particular assignee by using assignee id.
	 * 
	 * @param assignee Model of assignee.
	 * @return Success or failure message.
	 */
	String update(final Assignee assignee);
	
	/**
	 * Searches a particular assignee by using assignee id.
	 * 
	 * @param id Id of the assignee.
	 * @return Required assignee record.
	 */
	Assignee search(final int id);


}
