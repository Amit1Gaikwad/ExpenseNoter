package servletproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewExpenseServlet")
public class ViewExpenseServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        // Get all expenses
        List<Expense> list = ExpenseDao.getAllExpense();

        // Link to add new expense
        out.print("<a href='expense.html'>Add New Expense</a>");
        out.print("<center><h1>List Of Expenses</h1></center>");

        // Expense table
        out.print("<table width='100%' border='1' cellpadding='8'>");
        out.print("<tr>"
                + "<th>Id</th>"
                + "<th>City</th>"
                + "<th>Date</th>"
                + "<th>Day</th>"
                + "<th>Product</th>"
                + "<th>Amount</th>"
                + "<th>Edit</th>"
                + "<th>Delete</th>"
                + "</tr>");

        // Loop through each expense and display
        for (Expense e : list) {
            out.print("<tr>"
                    + "<td>" + e.getId() + "</td>"
                    + "<td>" + e.getCity() + "</td>"
                    + "<td>" + e.getDate() + "</td>"
                    + "<td>" + e.getDay() + "</td>"
                    + "<td>" + e.getProduct() + "</td>"
                    + "<td>" + e.getAmount() + "</td>"
                    + "<td><a href='EditExpenseServlet1?id=" + e.getId() + "'>Edit</a></td>"
                    + "<td><a href='DeleteExpenseServlet?id=" + e.getId() + "'>Delete</a></td>"
                    + "</tr>");
        }

        out.print("</table>");
        out.close();
    }
}
