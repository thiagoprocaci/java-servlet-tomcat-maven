# Aplicação Java Web com Servlet

## Classes


### Liquor

```
package com.tbp.repository;

import java.util.ArrayList;
import java.util.List;

public class Liquor {

    String type;
    List<String> brandList;

    public Liquor(String type) {
        this.type = type;
        this.brandList = new ArrayList<String>();
    }


    public String getType() {
        return type;
    }

    public List<String> getBrandList() {
        return brandList;
    }
}


```


### LiquorRepository

```
package com.tbp.repository;

import java.util.ArrayList;
import java.util.List;

public class LiquorRepository {

    private static List<Liquor> liquorList;

    static {
        Liquor wine = new Liquor("WINE");
        wine.getBrandList().add("Adrianna Vineyard");
        wine.getBrandList().add("J. P. Chenet");

        Liquor whisky = new Liquor("WHISKY");
        whisky.getBrandList().add("Glenfiddich");
        whisky.getBrandList().add("Johnnie Walker");

        Liquor beer = new Liquor("BEER");
        beer.getBrandList().add("Corona");

        liquorList = new ArrayList<Liquor>();
        liquorList.add(wine);
        liquorList.add(whisky);
        liquorList.add(beer);
    }


    public Liquor findByType(String type) {
        for(Liquor l : liquorList) {
            if(l.type.equals(type)) {
                return l;
            }
        }
        return null;
    }

    public List<Liquor> findAll() {
        return liquorList;
    }

    public void save(String type, String brand) {
        Liquor liquor = new Liquor(type);
        liquor.getBrandList().add(brand);
        liquorList.add(liquor);
    }


}

```

### LiquorService

```
package com.tbp.service;

import com.tbp.repository.Liquor;
import com.tbp.repository.LiquorRepository;

import java.util.ArrayList;
import java.util.List;

public class LiquorService {

    public List<String> getAvaliableBrands(String type) {
        LiquorRepository liquorRepository = new LiquorRepository();
        Liquor liquor = liquorRepository.findByType(type);
        if(liquor != null) {
            return liquor.getBrandList();
        }
        return new ArrayList<String>();
    }

    public List<String> getTypes() {
        LiquorRepository liquorRepository = new LiquorRepository();
        List<Liquor> all = liquorRepository.findAll();
        ArrayList<String> typeList = new ArrayList<String>();
        for(Liquor l : all) {
            typeList.add(l.getType());
        }
        return typeList;
    }

    public void saveLiquor(String type, String brand) {
        LiquorRepository liquorRepository = new LiquorRepository();
        liquorRepository.save(type, brand);
    }

}

```

### HelloServlet

```
package com.tbp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "hello-servlet",
        urlPatterns = "/hello"
)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Hello Servlet");
        out.println("</body>");
        out.println("</html>");
    }
}

```

### SaveLiquorServlet

```
package com.tbp.servlet;

import com.tbp.service.LiquorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        name = "save-liquor-servlet",
        urlPatterns = "/liquor/SaveLiquor"
)
public class SaveLiquorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/liquor/save.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("newType");
        String brand = req.getParameter("newBrand");
        LiquorService liquorService = new LiquorService();
        liquorService.saveLiquor(type, brand);
        req.setAttribute("successMessage", "Type " + type + " saved!" );
        req.getRequestDispatcher("/liquor/save.jsp").forward(req, resp);
    }
}

```

### SelectLiquorServlet

```
package com.tbp.servlet;

import com.tbp.service.LiquorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "select-liquor-servlet",
        urlPatterns = "/liquor/SelectLiquor"
)
public class SelectLiquorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LiquorService liquorService = new LiquorService();
        List<String> types = liquorService.getTypes();
        req.setAttribute("types", types);
        req.getRequestDispatcher("/liquor/select.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String liquorType = req.getParameter("Type");
        LiquorService liquorService = new LiquorService();
        List<String> liquorBrands = liquorService.getAvaliableBrands(liquorType);
        req.setAttribute("brands", liquorBrands);
        RequestDispatcher view = req.getRequestDispatcher("/liquor/list.jsp");
        view.forward(req, resp);
    }


}


```

## JSP

### index.jsp

```
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        Meu index.jsp!
        <br>
        <a href="<%=request.getContextPath()%>/liquor/SelectLiquor">Select Liquor</a>
         <br>
         <a href="<%=request.getContextPath()%>/liquor/SaveLiquor">Save Liquor</a>
    </body>
</html>

```

### select.jsp

```
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liquor Store</title>
</head>
<body>
<center>
    <h1>
        Select the type of Liquor
    </h1>
    <form method="post" action="<%=request.getContextPath()%>/liquor/SelectLiquor">
       <br>
        <select name="Type" size="1">
          <%
           List<String> result = (List<String>) request.getAttribute("types");
           for(String type : result) {
             out.println("<option>" + type + "</option>");
           }

           %>

        </select>
        <br><br>
        <input type="submit">
    </form>
</center>


</body>
</html>

```

### list.jsp

```
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Available Brands
</h1>
    <%
    List result= (List) request.getAttribute("brands");
    Iterator it = result.iterator();
    out.println("<br>We have <br><br>");
    while(it.hasNext()){
        out.println(it.next()+"<br>");
    }
    %>
</body>
</html>

```

### save.jsp

```
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liquor Store</title>
</head>
<body>
<center>
    <h1>
        Inserting New Liquor
    </h1>
      <%
           String message = (String) request.getAttribute("successMessage");
           if(message != null) {
            out.println("<h2>" + message + "</h2>");
           }
       %>

    <form method="post" action="<%=request.getContextPath()%>/liquor/SaveLiquor">
        <br>
        Type:
        <input type="text" name="newType" >
        <br> <br>
        Brand:
        <input type="text" name="newBrand" >
        <br><br>
        <input type="submit">
    </form>
    <br><br>
     <a href="<%=request.getContextPath()%>/liquor/SelectLiquor">Select Liquor</a>
</center>


</body>
</html>

```