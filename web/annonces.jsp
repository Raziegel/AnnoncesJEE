<%@page import="fr.projet.ProjetLBC.beans.Annonce"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Mes annonces</title>
</head>
<body>

<table>
    <th>
        TITRE
    </th>
    <th>
        DETAILS
    </th>
    <%
        List<Annonce> myAnnonces = (List)request.getAttribute("ANNONCES");
        for (Annonce annonce : myAnnonces) {
            out.println("<tr>");
            out.println("<td>");
            out.println(annonce.getTitre());
            out.println("</td>");
            out.println("<td>");
            out.println("<a href='localhost:8080/fr.epsi.myEpsi/Annonce?id="+annonce.getId()+"' >Details de l'annonce</a>");
            out.println("</td>");
            out.println("<td>");
            out.println(annonce.getVendeur().getNom());
            out.println("</td>");
            out.println("<td>");
            out.println(annonce.getCreation().toString());
            out.println("</td>");
            out.println("</tr>");
        }
    %>
</table>
</body>
</html>
