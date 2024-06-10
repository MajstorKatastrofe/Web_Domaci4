package com.example.chooseyourfood.strane;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "chooseYourFood", value = "/choose-your-food")
public class ChooseYourFood extends HttpServlet {

    private static List<Map<String, Integer>> ponedeljak;
    private static List<Map<String, Integer>> utorak;
    private static List<Map<String, Integer>> sreda;
    private static List<Map<String, Integer>> cetvrtak;
    private static List<Map<String, Integer>> petak;
    private static String lozinka = "";
    private static boolean zavrsen = false;

    @Override
    public void init() {
        ponedeljak = new CopyOnWriteArrayList<>();
        utorak = new CopyOnWriteArrayList<>();
        sreda = new CopyOnWriteArrayList<>();
        cetvrtak = new CopyOnWriteArrayList<>();
        petak = new CopyOnWriteArrayList<>();

        ucitajJela(ponedeljak, "ponedeljak.txt");
        ucitajJela(utorak, "utorak.txt");
        ucitajJela(sreda, "sreda.txt");
        ucitajJela(cetvrtak, "cetvrtak.txt");
        ucitajJela(petak, "petak.txt");

        ucitajLozinku();
    }

    private void ucitajLozinku(){

        String path = "/Users/pc/4/chooseYourFood/src/main/java/com/example/chooseyourfood/password.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            lozinka = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.err.println("Greska prilikom citanja fajla: " + e.getMessage());
        }
    }

    private void ucitajJela(List<Map<String, Integer>> dan, String d){

        String path = "/Users/pc/4/chooseYourFood/src/main/java/com/example/chooseyourfood/jela/" + d;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                Map<String, Integer> m = new HashMap<>();
                m.put(line, 0);
                dan.add(m);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Greska prilikom citanja fajla: " + e.getMessage());
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        if (!zavrsen) {
            out.println("<h1>Choose your food</h1>");
            out.println("<h2>Odaberite vas rucak:</h2>");

            out.println("<form method=\"POST\" action=\"/choose-your-food\">");
            out.println("<h3>Ponedeljak</h3>");
            out.println("<select name=\"izborPon\">");
            Map<String, Integer> map = ponedeljak.get(0);
            for(String s : map.keySet()){
                out.println("<option value=\"0\" selected>" + s + "</option>");
            }
            map = ponedeljak.get(1);
            for(String s : map.keySet()){
                out.println("<option value=\"1\">" + s + "</option>");
            }
            map = ponedeljak.get(2);
            for(String s : map.keySet()){
                out.println("<option value=\"2\">" + s + "</option>");
            }
            out.println("</select><br>");


            out.println("<h3>Utorak</h3>");
            out.println("<select name=\"izborUto\">");
            map = utorak.get(0);
            for(String s : map.keySet()){
                out.println("<option value=\"0\" selected>" + s + "</option>");
            }
            map = utorak.get(1);
            for(String s : map.keySet()){
                out.println("<option value=\"1\">" + s + "</option>");
            }
            map = utorak.get(2);
            for(String s : map.keySet()){
                out.println("<option value=\"2\">" + s + "</option>");
            }
            out.println("</select><br>");


            out.println("<h3>Sreda</h3>");
            out.println("<select name=\"izborSre\">");
            map = sreda.get(0);
            for(String s : map.keySet()){
                out.println("<option value=\"0\" selected>" + s + "</option>");
            }
            map = sreda.get(1);
            for(String s : map.keySet()){
                out.println("<option value=\"1\">" + s + "</option>");
            }
            map = sreda.get(2);
            for(String s : map.keySet()){
                out.println("<option value=\"2\">" + s + "</option>");
            }
            out.println("</select><br>");


            out.println("<h3>Cetvrtak</h3>");
            out.println("<select name=\"izborCet\">");
            map = cetvrtak.get(0);
            for(String s : map.keySet()){
                out.println("<option value=\"0\" selected>" + s + "</option>");
            }
            map = cetvrtak.get(1);
            for(String s : map.keySet()){
                out.println("<option value=\"1\">" + s + "</option>");
            }
            map = cetvrtak.get(2);
            for(String s : map.keySet()){
                out.println("<option value=\"2\">" + s + "</option>");
            }
            out.println("</select><br>");


            out.println("<h3>Petak</h3>");
            out.println("<select name=\"izborPet\">");
            map = petak.get(0);
            for(String s : map.keySet()){
                out.println("<option value=\"0\" selected>" + s + "</option>");
            }
            map = petak.get(1);
            for(String s : map.keySet()){
                out.println("<option value=\"1\">" + s + "</option>");
            }
            map = petak.get(2);
            for(String s : map.keySet()){
                out.println("<option value=\"2\">" + s + "</option>");
            }
            out.println("</select><br><br>");

            out.println("<input type=\"submit\" name=\"submit\"value=\"Potvrdite unos\"></form>");

        }else{
            out.println("<style type=\"text/css\">table,th,td{border: 1px solid black;} </style>");
            out.println("<h1>Vec ste odabrali svoje obroke za ovu nedelju.</h1>");
            out.println("<h2>Ovo je vasa porudzbina:</h2>");


            out.println("<table><thead><tr>");
            out.println("<th>Ponedeljak</th>");
            out.println("<th>Utorak</th>");
            out.println("<th>Sreda</th>");
            out.println("<th>Cetvrtak</th>");
            out.println("<th>Petak</th>");
            out.println("</tr></thead>");
            out.println("<tr>");
            for(Map<String, Integer> map : ponedeljak){
                for(String s : map.keySet()){
                    if(map.get(s) == 1){
                        out.println("<td>" + s + "</td>");
                    }
                }
            }
            for(Map<String, Integer> map : utorak){
                for(String s : map.keySet()){
                    if(map.get(s) == 1){
                        out.println("<td>" + s + "</td>");
                    }
                }
            }
            for(Map<String, Integer> map : sreda){
                for(String s : map.keySet()){
                    if(map.get(s) == 1){
                        out.println("<td>" + s + "</td>");
                    }
                }
            }
            for(Map<String, Integer> map : cetvrtak){
                for(String s : map.keySet()){
                    if(map.get(s) == 1){
                        out.println("<td>" + s + "</td>");
                    }
                }
            }
            for(Map<String, Integer> map : petak){
                for(String s : map.keySet()){
                    if(map.get(s) == 1){
                        out.println("<td>" + s + "</td>");
                    }
                }
            }
            out.println("</tr></table>");
        }
        out.println("</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String izborPon = request.getParameter("izborPon");
        String izborUto = request.getParameter("izborUto");
        String izborSre = request.getParameter("izborSre");
        String izborCet = request.getParameter("izborCet");
        String izborPet = request.getParameter("izborPet");

        System.out.println("IzborPon: " + izborPon);
        System.out.println("IzborUto: " + izborUto);
        System.out.println("IzborSre: " + izborSre);
        System.out.println("IzborCet: " + izborCet);
        System.out.println("IzborPet: " + izborPet);

        povecajVrednostIzabraneOpcije(ponedeljak, izborPon);
        povecajVrednostIzabraneOpcije(utorak, izborUto);
        povecajVrednostIzabraneOpcije(sreda, izborSre);
        povecajVrednostIzabraneOpcije(cetvrtak, izborCet);
        povecajVrednostIzabraneOpcije(petak, izborPet);

        response.sendRedirect("/successful");
    }

    private void povecajVrednostIzabraneOpcije(List<Map<String, Integer>> dan, String izbor) {
        int index = Integer.parseInt(izbor);
        Map<String, Integer> map = dan.get(index);
        for (String s : map.keySet()) {
            int vrednost = map.get(s);
            map.put(s, vrednost + 1);
        }
    }


    //Ako treba
    public void destroy() {
    }

    public static String getLozinka() {
        return lozinka;
    }

    public static void promeni(){
        zavrsen = !zavrsen;
    }

    public static void ocisti(){
        for(Map<String, Integer> map : ponedeljak){
            for(String s : map.keySet()){
                map.put(s, 0);
            }
        }
        for(Map<String, Integer> map : utorak){
            for(String s : map.keySet()){
                map.put(s, 0);
            }
        }
        for(Map<String, Integer> map : sreda){
            for(String s : map.keySet()){
                map.put(s, 0);
            }
        }
        for(Map<String, Integer> map : cetvrtak){
            for(String s : map.keySet()){
                map.put(s, 0);
            }
        }
        for(Map<String, Integer> map : petak){
            for(String s : map.keySet()){
                map.put(s, 0);
            }
        }
    }

    public static List<Map<String, Integer>> getPonedeljak() {
        return ponedeljak;
    }

    public static List<Map<String, Integer>> getUtorak() {
        return utorak;
    }

    public static List<Map<String, Integer>> getSreda() {
        return sreda;
    }

    public static List<Map<String, Integer>> getCetvrtak() {
        return cetvrtak;
    }

    public static List<Map<String, Integer>> getPetak() {
        return petak;
    }
}
