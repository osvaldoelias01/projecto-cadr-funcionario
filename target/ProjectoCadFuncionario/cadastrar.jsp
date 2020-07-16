<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.FuncionarioModel"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Cadastrar Funcionario</h2>
<form action="FuncionarioController" method="post">
    <label >Nome:</label><br>
    <input type="text"  name="nome"><br>

    <label>Idade:</label><br>
    <input type="number" name="idade"><br>

    <label>Cargo:</label><br>
    <input type="text" name="cargo"><br>

    <label>Salario:</label><br>
    <input type="text" name="salario"><br>

    <input type="submit" value="Salvar">
    <button style="background-color: gray"><a href="index.jsp">Voltar</a></button>

</form>



</body>
</html>