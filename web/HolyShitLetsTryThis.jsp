<%-- 
    Document   : HolyShitLetsTryThis
    Created on : 19-Jan-2017, 21:16:09
    Author     : Sanox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>

<html>

    <head>
        <title> GooB </title>
        <link rel="stylesheet" type="text/css" href="cssSheet.css">
        <link rel="stylesheet" href="cssSheet.css" type="text/css"/>
        <link rel="stylesheet" href="cssSheet.css" type="text/css">
        <link rel="stylesheet" href="cssSheet.css" type="text/css"/>
        <link rel="stylesheet" href="cssSheet.css" type="text/css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
  <ul>
  <li><a class="active" href="Frontpage.html">Forside</a></li>
  <li><a class="active" href="Offers.html">Ugens tilbud</a></li>
  <li class="dropdown">
      <a href="javascript:void(0)" class="dropbtn">Katalog</a>
      <div class="dropdown-content"> 
          <a href="Apple.html">Apple</a>
          <a href="Samsung.html">Samsung</a>
          <a href="Sony.html">Sony</a>
      </div>
      </li>
  <li><a class="active" href="Contact.html">Kontakt os</a></li>
  <li><a class="active" href="AboutGooB.html">Om GooB</a></li>
    <div>
  <a target="_blank" href="Basket.html">
    <img src="Basket.png" alt="Cart" height="45px" width="45px">
  </a>
</div>
</ul>
        
        <div class="box"> <%=request.getAttribute("ServletOutput")%> </div>
    </body>
</html>
