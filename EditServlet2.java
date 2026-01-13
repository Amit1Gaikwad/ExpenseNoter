package servletcurdd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet{
@Override
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
{
	PrintWriter out = res.getWriter();
	res.setContentType("text/html");
	int id = Integer.parseInt(req.getParameter("id"));
	String name = req.getParameter("name");
	String pass = req.getParameter("pass");
	String email = req.getParameter("email");
	String country = req.getParameter("country");
	Emp e = new Emp(id, name, pass, email, country);
	int st = EmpDao.update(e);
	if(st > 0)
	{
		res.sendRedirect("ViewServlet");
	}
	else
	{
		out.print("<h1>Sorry unable to update record</h1>");
	}
}
}
