package servletcurdd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet1 extends HttpServlet{
@Override
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
{

	try
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));
		Emp e = EmpDao.getEmployee(id);
		out.print("<h1>Update Employee</h1>");
		out.print("<form action='EditServlet2'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'></td></tr>");
		out.print("<tr><td>Name</td><td><input type='text' name='name' value="+e.getName()+"></td></tr>");
		out.print("<tr><td>Password</td><td><input type='password' name='pass' value="+e.getPassword()+"></td></tr>");
		out.print("<tr><td>Email</td><td><input type='email' name='email' value="+e.getEmail()+"></td></tr>");
		out.print("<tr><td>Country</td><td>");
		out.print("<select name='country' style='width:150px' value="+e.getCountry()+">");
		out.print("<option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>UK</option>");
		out.print("<option>Other</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit'></td></tr>");
		out.print("</table>");
		out.print("</form>");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
