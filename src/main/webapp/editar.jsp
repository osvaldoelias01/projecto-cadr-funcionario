<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="model.FuncionarioModel"%>
<% FuncionarioModel funcionario = (FuncionarioModel)request.getAttribute("funcionarioModel"); %>
<html>
<body>
<h2>Editar Funcionario</h2>
<form action="FuncionarioController" method="post">
    <label >Id:</label><br>
    <input type="text"  name="id" value="<%= funcionario.getId() %>" /><br>
    <label >Nome:</label><br>
    <input type="text"  name="nome" value="<%= funcionario.getNome() %>" /><br>
    <label>Idade:</label><br>
    <input type="number" name="idade" value="<%= funcionario.getIdade() %>" /><br>
    <label>Cargo:</label><br>
    <input type="text" name="cargo" value="<%= funcionario.getCargo() %>" /><br>
    <label>Salario:</label><br>
    <input type="text" name="salario" value="<%= funcionario.getSalario() %>" /><br>
    <input type="submit" value="Salvar">
    <button style="background-color: gray"><a href="index.jsp">Voltar</a></button>



</form>



</body>
</html>