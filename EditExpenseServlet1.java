package servletproject;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditExpenseServlet1")
public class EditExpenseServlet1 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            PrintWriter out = res.getWriter();
            res.setContentType("text/html");

            // Get expense id from request
            int id = Integer.parseInt(req.getParameter("id"));
            Expense e = ExpenseDao.getExpense(id);

            out.print("<h1>Update Expense</h1>");
            out.print("<form action='EditExpenseServlet2' method='post'>"); // Servlet to handle update
            out.print("<table>");

            // Hidden field for id
            out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'></td></tr>");

            out.print("<tr><td>City</td><td><input type='text' name='city' value='" + e.getCity() + "' required></td></tr>");
            out.print("<tr><td>Date</td><td><input type='date' name='date' value='" + e.getDate() + "' required></td></tr>");
            out.print("<tr><td>Day</td><td><input type='text' name='day' value='" + e.getDay() + "' required></td></tr>");
            out.print("<tr><td>Product</td><td><input type='text' name='product' value='" + e.getProduct() + "' required></td></tr>");
            out.print("<tr><td>Amount</td><td><input type='number' name='amount' value='" + e.getAmount() + "' required></td></tr>");

            out.print("<tr><td colspan='2'><input type='submit' value='Update Expense'></td></tr>");
            out.print("</table>");
            out.print("</form>");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
