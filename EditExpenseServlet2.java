package servletproject;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditExpenseServlet2")
public class EditExpenseServlet2 extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        try {
            // Get updated expense values from form
            int id = Integer.parseInt(req.getParameter("id"));
            String city = req.getParameter("city");
            String date = req.getParameter("date");
            String day = req.getParameter("day");
            String product = req.getParameter("product");
            int amount = Integer.parseInt(req.getParameter("amount"));

            // Create Expense object
            Expense e = new Expense();
            e.setId(id);
            e.setCity(city);
            e.setDate(date);
            e.setDay(day);
            e.setProduct(product);
            e.setAmount(amount);

            // Update in DB
            int st = ExpenseDao.update(e);

            if (st > 0) {
                // Redirect to view all expenses
                res.sendRedirect("ViewExpenseServlet");
            } else {
                out.print("<h1>Sorry, unable to update expense record</h1>");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            out.print("<h1>Error occurred while updating</h1>");
        }

        out.close();
    }
}
