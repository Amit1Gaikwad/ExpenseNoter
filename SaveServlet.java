package servletcurdd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveData")
public class SaveServlet extends HttpServlet{
	static int id = 1;
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String name= req.getParameter("name");
		String pass = req.getParameter("pass");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		id++;
		Emp e = new Emp();
		e.setName(name);
		e.setEmail(email);
		e.setCountry(country);
		e.setPassword(pass);
		int st =EmpDao.save(e);
		if(st>0)
		{
			out.print("<h1>Record Saved Successfully</h1>");
			req.getRequestDispatcher("Index.html").include(req, res);
		}
		else
		{
			out.print("Sorry unable to store record");
		}
		out.close();
	}
}




/*

/*
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet
{
	static int id = 1;
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		id++;
		Emp e = new Emp();
		e.setName(name);
		e.setEmail(email);
		e.setCountry(country);
		e.setPassword(pass);
		int st = EmpDao.save(e);
		if(st>0)
		{
			out.print("<h1>Record Saved Successfully</h1>");
			req.getRequestDispatcher("index.html").include(req, res);
		}
		else
		{
			out.print("sorry enalble to store");
		}
		out.close();
	}
}

/*
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveData")
public class SaveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        Emp e = new Emp();
        e.setName(name);
        e.setEmail(email);
        e.setCountry(country);
        e.setPassword(pass);

        int status = EmpDao.save(e);

        if (status > 0) {
            out.print("<h2>Record Saved Successfully</h2>");
            res.sendRedirect("Index.html");
        } else {
            out.print("<h2>Error: Unable to save record</h2>");
        }
    }
}
*/