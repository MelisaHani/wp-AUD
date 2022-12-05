package mk.ukim.finki.wpaud.web.servlet;

import mk.ukim.finki.wpaud.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "category-servlet", urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {

    private final CategoryService categoryService;

    public CategoryServlet(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ipAddress = req.getRemoteAddr();
        String client = req.getHeader("user-Agent");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h3>User Info</h3>");
        writer.format("IP Address is: %s <br/>", ipAddress);
        writer.format("Client agent is: %s ", client);
        writer.println("<h3>Category List</h3>");
        writer.println("<ul>");
        categoryService.listAllCategories().stream().forEach(r ->
                writer.format("<li> %s %s</li>", r.getName(), r.getDescription()));
        writer.println("</ul>");
        writer.println("<h3>Add Category Name</h3>");
        writer.println("<form method='POST' action='/servlet/category'>\n" +
                "\t<label for='name'>Name:</label>\n" +
                "\t<input id='name' type='text' name='name' />\n" +
                "\t<input type='submit' />\n" +
                "\t<label for='description'>Description:</label>\n" +
                "\t<input id='description' type='text' name='description' />\n" +
                "\t<input type='submit' />\n" +
                "</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("name");
        String categoryDescription = req.getParameter("description");
        categoryService.create(categoryName, categoryDescription);
        resp.sendRedirect("/servlet/category");
    }

}




