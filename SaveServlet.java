/*package servletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveExpense")
public class SaveServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Get multiple values from form
        String[] city = req.getParameterValues("city");
        String[] date = req.getParameterValues("date");
        String[] day = req.getParameterValues("day");
        String[] product = req.getParameterValues("product");
        String[] amount = req.getParameterValues("amount");

        int status = 0;

        // Loop to save multiple products
        for (int i = 0; i < product.length; i++) {

            Expense e = new Expense();
            e.setCity(city[i]);
            e.setDate(date[i]);
            e.setDay(day[i]);
            e.setProduct(product[i]);
            e.setAmount(Integer.parseInt(amount[i]));

            status = ExpenseDao.save(e);
        }

        if (status > 0) {
            out.print("<h1>Record Saved Successfully</h1>");
            req.getRequestDispatcher("expense.html").include(req, res);
        } else {
            out.print("Sorry unable to store record");
        }

        out.close();
    }
}
*/

package servletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveExpense")
public class SaveServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String[] city = req.getParameterValues("city");
        String[] date = req.getParameterValues("date");
        String[] day = req.getParameterValues("day");
        String[] product = req.getParameterValues("product");
        String[] amount = req.getParameterValues("amount");

        // ✅ NULL CHECK (VERY IMPORTANT)
        if (product == null) {
            out.println("<h3>No product data received</h3>");
            return;
        }

        int status = 0;

        for (int i = 0; i < product.length; i++) {
            Expense e = new Expense();
            e.setCity(city[i]);
            e.setDate(date[i]);
            e.setDay(day[i]);
            e.setProduct(product[i]);
            e.setAmount(Integer.parseInt(amount[i]));

            status = ExpenseDao.save(e);
        }

        if (status > 0) {
            out.println("<h2>Record Saved Successfully</h2>");
        } else {
            out.println("<h2>Error while saving</h2>");
        }

        out.close();
    }
}
