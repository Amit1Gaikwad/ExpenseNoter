package servletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteExpenseServlet")
public class DeleteExpenseServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        try {
            // Get expense id from request
            int id = Integer.parseInt(req.getParameter("id"));

            // Delete expense from DB
            int st = ExpenseDao.delete(id);

            if (st > 0) {
                // Redirect to view all expenses
                res.sendRedirect("ViewExpenseServlet");
            } else {
                out.print("<h1>Sorry, unable to delete expense record</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<h1>Error occurred while deleting</h1>");
        }

        out.close();
    }
}
