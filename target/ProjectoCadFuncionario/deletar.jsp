
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.FuncionarioModel"%>
<% ArrayList<FuncionarioModel> lista = (ArrayList<FuncionarioModel>)request.getAttribute("funcionarioModel"); %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
<script src="resources/js/datatable.js"></script>
<head>
    <title>Lista de Produtos</title>
</head>
<body>
<fieldset>
    <legend style="text-align: center;font-family: 'Times New Roman'"><strong><i class="fas fa-users"></i>Lista de Funcionario</strong></legend></legend>
    <div style="padding-right: 20px;padding-left: 20px">
        <table id="example" class="table table-striped table-bordered" align="center">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Idade</th>
                <th>Cargo</th>
                <th>Salario</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <% for (int i = 0; i < lista.size(); i++){ %>
            <tr>
                <td><%= lista.get(i).getId() %></td>
                <td><%= lista.get(i).getNome() %></td>
                <td><%= lista.get(i).getIdade() %></td>
                <td><%= lista.get(i).getCargo() %></td>
                <td><%= lista.get(i).getSalario() %></td>
                <td>
                    <a href="FuncionarioController?action=editar&id=<%= lista.get(i).getId() %>"><i class="fas fa-pen"></i></a>
                    <a href="FuncionarioController?action=deletar&id=<%= lista.get(i).getId() %>"onclick="return confirm('Are you sure you want to Delete?');"><i class="fas fa-trash"></i></a>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</fieldset>
</body>
</html>
