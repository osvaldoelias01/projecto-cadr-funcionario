<html>
<head>
    <meta name="viewport" content="width">
    <style>
        body{
            margin: 0;
        }
        .vertical-menu ul{
            background-color: black;

        }
        .vertical-menu ul li{
            display: inline;

        }
        .vertical-menu ul li a{
            padding: 10px 10px;
            display: inline-block;

            color: white;
            text-decoration: none;

        }
        .vertical-menu ul li a:hover{
            color: #004d00;
        }

    </style>
</head>
<body>

<h1>MENU FUNCIONARIO</h1>
<div class="vertical-menu">
    <ul>
        <li><a href="cadastrar.jsp">Cadastrar</a></li>
        <li><a href="FuncionarioController?action=listar">Listar</a></li>
    </ul>
</div>


</body>
</html>
