<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
    <head>
        <title>Calculator</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form id="Form" name="Form">
            <input type="text" id="inputValue">
            <select id="operation" name="operation">
                <option>+</option>
                <option>-</option>
                <option>*</option>
                <option>/</option>
              </select>
            <input type="text" id="inputValue2" >
            <input type="submit" value="GO" id="somebutton" onclick="callServlet('POST'); return false" >
            
            <div id="somediv"></div>
            <p>           
                <a class="btn btn-primary" href="/springsecuritybasics/j_spring_security_logout">Exit</a>
            </p>
             <p>           
                <a class="btn btn-primary" href="/springsecuritybasics/admin">Admin page</a>
            </p>
        </form>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            var r;
            function callServlet(methodType) {
                var bool = true;
                var patt = /\-?\d+(\.\d{0,})?/;
                document.getElementById("inputValue").style.borderColor = "green";
                document.getElementById("inputValue2").style.borderColor = "green";
                if(document.getElementById("inputValue").value.replace(patt , '')!==''){
                     bool = false;
                     document.getElementById("inputValue").value='';
                     document.getElementById("inputValue").style.borderColor = "red";
                }
                if(document.getElementById("inputValue2").value.replace(patt , '')!==''){
                     bool = false;
                     document.getElementById("inputValue2").value='';
                     document.getElementById("inputValue2").style.borderColor = "red";                     
                }
                else
                {
                    if(document.getElementById("operation").value == "/" & document.getElementById("inputValue2").value==0)
                    {
                        bool = false;
                        document.getElementById("inputValue2").value='';
                        document.getElementById("inputValue2").style.borderColor = "red";               
                    }
                }
                if(bool) {
                    document.getElementById("Form").action = "testServlet";
                    document.getElementById("Form").method = methodType;
                    document.getElementById("Form").innerHTML;
                    var result;
                    var form = $('#Form');                
                    $.ajax({
                        type: "POST",
                        url: "/springsecuritybasics/testServlet",
                        data:{val1:document.getElementById("inputValue").value,val2:document.getElementById("inputValue2").value, operation:document.getElementById("operation").value},
                        success: function(res){                            
                            result =  JSON.parse(res);                            
                            document.getElementById("somediv").innerText = result.result;
                        }
                    });
                }
            }            
        </script>
    </body>
</html>