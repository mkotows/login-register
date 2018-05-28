<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">
    <a href="/">For All</a> |
    <a href="/welcome">Home</a> |
    <a href="/addNewEmployee">Add Employee</a> |
    <a href="/getEmployees">Show Employees</a> |

    <%--<u><h2 style="color: red;"> <a onclick="document.forms['logoutForm'].submit()"><button>Logout</button> </a> </h2></u>--%>
    <br><br>
    <%--<a onclick="document.forms['logoutForm'].submit()"><button--%>
            <%--style="background-color: red; font-size: x-large; font-weight: bold">Logout</button> </a>--%>
    <form id="logoutForm" method="POST"  action="/logout">
        <input type="submit" value="Logout" style="background-color: red; font-size: x-large; font-weight: bold">
    </form>


</div>