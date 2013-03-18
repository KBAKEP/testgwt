package ru.artezio.client;

import ru.artezio.shared.entity.Employee;
import ru.artezio.shared.services.EmployeeServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * GWT JUnit <b>integration</b> tests must extend GWTTestCase. Using
 * <code>"GwtTest*"</code> naming pattern exclude them from running with
 * surefire during the test phase.
 * 
 * If you run the tests using the Maven command line, you will have to navigate
 * with your browser to a specific url given by Maven. See
 * http://mojo.codehaus.org/gwt-maven-plugin/user-guide/testing.html for
 * details.
 */
public class GwtTesttestgwt extends GWTTestCase {

	private EmployeeServiceAsync employeeService;

	/**
	 * Must refer to a valid module that sources this class.
	 */
	public String getModuleName() {
		return "ru.artezio.testgwtJUnit";
	}

	/**
	 * This test will send a request to the server using the greetServer method
	 * in GreetingService and verify the response.
	 */
	public void testGreetingService() {
		employeeService = EmployeeServiceAsync.Util.getInstance();
		employeeService.hire("name", "Dep", new AsyncCallback<Employee>() {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				
			}

			@Override
			public void onSuccess(Employee result) {

			}

		});
		
		
	}
	// Create the service that we will test.

	// Since RPC calls are asynchronous, we will need to wait for a response
	// after this test method returns. This line tells the test runner to
	// wait
	// up to 10 seconds before timing out.
}
