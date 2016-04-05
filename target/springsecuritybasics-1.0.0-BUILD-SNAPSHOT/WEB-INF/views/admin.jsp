<%-- 
    Document   : admin
    Created on : 30.03.2016, 15:08:05
    Author     : Abbas
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>Admin page</title>
    </head>
    <body>
         <form id="Form" name="Form">
                <input type="submit" value="Table essence" id="somebutton" onclick="callServlet('GET'); return false" >
                
         </form>
         <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            var r;
            function callServlet(methodType) {
                    var result;            
                    $.ajax({
                        type: "GET",
                        url: "/springsecuritybasics/testServlet",
                        success: function(list){                            
                            result =  JSON.parse(list);
                            for(var p in result) {                         
                                var h = document.createElement("H2");
                                var t = document.createTextNode("id="+result[p].id+", login="+result[p].login +" "+ result[p].value1+ " "+result[p].operation+" "+ result[p].value2+" = " + result[p].result+" "+ result[p].date);
                                h.appendChild(t);
                                document.body.appendChild(h);
                            }                            
                        }
                    });
            }         
        </script>
    </body>
</html>
