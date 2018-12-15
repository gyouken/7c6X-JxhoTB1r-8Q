<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><%=(String) request.getAttribute("type")%> result</title>
</head>
<body>
<%
    String result = (String) request.getAttribute("results");
    String resultout;
    switch (result) {
        case "success":
            resultout = "Success!";
            break;
        case "failed":
            resultout = "Failed!";
            break;
        default:
            resultout = "Invalid request!";
    }
%>
<%=resultout%>
</body>
</html>
