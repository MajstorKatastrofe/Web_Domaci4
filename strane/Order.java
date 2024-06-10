package com.example.chooseyourfood.strane;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "order", value = "/order")
public class Order extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<style type=\"text/css\">table,th,td{border: 1px solid black;}</style>" +
                "<body>");
        if(request.getParameter("lozinka").equals(ChooseYourFood.getLozinka())){
            out.println("<h1>Odabrana jela</h1>");
            out.println("<form method=\"POST\" action=\"/order\">" +
                    "<input type=\"submit\" name=\"submit\" value=\"Ocisti\"><br>");
            out.println("<h3>Ponedeljak</h3>");
            out.println("<table><thead><tr>");
            out.println("<th>#</th>");
            out.println("<th>Jelo</th>");
            out.println("<th>Kolicina</th>");
            out.println("</tr></thead>");

            out.println("<tr>");
            out.println("<td>1</td>");
            Map<String, Integer> map = ChooseYourFood.getPonedeljak().get(0);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>2</td>");
            map = ChooseYourFood.getPonedeljak().get(1);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>3</td>");
            map = ChooseYourFood.getPonedeljak().get(2);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr></table>");


            out.println("<br><h3>Utorak</h3>");
            out.println("<table><thead><tr>");
            out.println("<th>#</th>");
            out.println("<th>Jelo</th>");
            out.println("<th>Kolicina</th>");
            out.println("</tr></thead>");
            out.println("<tr>");
            out.println("<td>1</td>");
            map = ChooseYourFood.getUtorak().get(0);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>2</td>");
            map = ChooseYourFood.getUtorak().get(1);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>3</td>");
            map = ChooseYourFood.getUtorak().get(2);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr></table>");


            out.println("<br><h3>Sreda</h3>");
            out.println("<table><thead><tr>");
            out.println("<th>#</th>");
            out.println("<th>Jelo</th>");
            out.println("<th>Kolicina</th>");
            out.println("</tr></thead>");
            out.println("<tr>");
            out.println("<td>1</td>");
            map = ChooseYourFood.getSreda().get(0);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>2</td>");
            map = ChooseYourFood.getSreda().get(1);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>3</td>");
            map = ChooseYourFood.getSreda().get(2);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr></table>");




            out.println("<br><h3>Cetvrtak</h3>");
            out.println("<table><thead><tr>");
            out.println("<th>#</th>");
            out.println("<th>Jelo</th>");
            out.println("<th>Kolicina</th>");
            out.println("</tr></thead>");
            out.println("<tr>");
            out.println("<td>1</td>");
            map = ChooseYourFood.getCetvrtak().get(0);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>2</td>");
            map = ChooseYourFood.getCetvrtak().get(1);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>3</td>");
            map = ChooseYourFood.getCetvrtak().get(2);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr></table>");




            out.println("<br><h3>Petak</h3>");
            out.println("<table><thead><tr>");
            out.println("<th>#</th>");
            out.println("<th>Jelo</th>");
            out.println("<th>Kolicina</th>");
            out.println("</tr></thead>");
            out.println("<tr>");
            out.println("<td>1</td>");
            map = ChooseYourFood.getPetak().get(0);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>2</td>");
            map = ChooseYourFood.getPetak().get(1);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>3</td>");
            map = ChooseYourFood.getPetak().get(2);
            for(String s : map.keySet()){
                out.println("<td>" + s + "</td>");
                out.println("<td>" + map.get(s) + "</td>");
            }
            out.println("</tr></table>");

            out.println("</form>");
        }else{
            out.println("<h1>Niste ovlasceni da pristupite ovoj stranici.</h1>");
        }
        out.println("</body></html>");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        ChooseYourFood.promeni();
        ChooseYourFood.ocisti();

        response.sendRedirect("/order?lozinka=" + ChooseYourFood.getLozinka());
    }

}
