package my.examples.firstweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Start", urlPatterns = "/Start")
public class Start extends HttpServlet {
    public Start(){
        System.out.println("HelloServlet()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String favorite[] = req.getParameterValues("favorite");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        
        out.println("<html>");
        out.println("   <head><title>hello</title></head>");
        out.println("   <body>");
        out.println("   <h3>아이디 : "+id+"</h3>");
        out.println("   <h3>이름 : "+name+"</h3>");
        out.println("   <h3>이메일 : "+email+"</h3>");
        out.println("   <h3>성별 : "+gender+"</h3>");
        out.println("   <h3>도시 : "+city+"</h3>");
        out.println("   <h3>나라 : "+country+"</h3>");
        out.println("   <p style='font-size:15px;'><b>취미</b>");
        for(String food:favorite)
            out.println("<b>"+food+" </b>");
        out.println("   </p>");
        out.println("   </body>");
        out.println("</html>");
    }

    @Override
    public void destroy() {
        System.out.println("----- destroy -----");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("----- init -----");
    }
}