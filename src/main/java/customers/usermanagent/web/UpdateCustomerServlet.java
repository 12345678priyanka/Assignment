package customers.usermanagent.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uuid=request.getParameter("uuid");
		String FirstName=request.getParameter("FirstName");
		String LastName=request.getParameter("LasttName");
		String Address=request.getParameter("Address");
		String City=request.getParameter("City");
		String State=request.getParameter("State");
		String Email=request.getParameter("Email");
		String Phone=request.getParameter("Phone");
		
		boolean updateSuccess=performUpdate(uuid,FirstName,LastName,Address,City,State,Email,Phone);
		if(updateSuccess) {
			response.sendRedirect("customerList.jsp");
		}else {
			response.sendRedirect("errorPage.jsp");
		}
	}
	private boolean performUpdate(String uuid,String FirstName,String LastName,String Address,String City,String State,String Email,String Phone) {
		return true;
	}

}
