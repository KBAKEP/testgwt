package ru.artezio.client;

import ru.artezio.shared.FieldVerifier;
import ru.artezio.shared.services.DepartmentServiceAsync;
import ru.artezio.shared.services.EmployeeServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class testgwt implements EntryPoint {
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again. The error is : ";

	/**
	 * Create a remote service proxy to talk to the server-side Employee
	 * service.
	 */
	private final EmployeeServiceAsync employeeService = EmployeeServiceAsync.Util
			.getInstance();

	private final DepartmentServiceAsync departmentService = DepartmentServiceAsync.Util
			.getInstance();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button saveOrUpdateButton = new Button("SaveOrUpdate");
		final Button retrieveButton = new Button("Retrieve");
		final TextBox employeeInfoField = new TextBox();
		employeeInfoField.setText("Employee Info");
		final TextBox employeeIdField = new TextBox();
		final Label errorLabel = new Label();

		RootPanel.get("updateEmployeeButtonContainer").add(saveOrUpdateButton);

	}
}
