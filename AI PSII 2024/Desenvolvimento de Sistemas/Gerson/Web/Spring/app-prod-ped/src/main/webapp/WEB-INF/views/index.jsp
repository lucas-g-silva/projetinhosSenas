<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Cadastro de Produtos e Pedidos</title>
            <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link
                href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
                rel="stylesheet">
        </head>

        <body>
            <main>
                <h1>Cadastro de Produtos</h1>
                <form action="/produto" method="post">

                    <label>Descrição:</label>
                    <input type="text" name="descricao" required class="input">

                    <label>Preço:</label>
                    <input type="number" step="0.01" name="preco" required class="input">

                    <input type="submit" class="button" value="Cadastrar Produto">
                </form>

                <h2>Produtos Cadastrados</h2>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Descrição</th>
                        <th>Preço</th>
                    </tr>
                    <c:forEach items="${produtos}" var="produto">
                        <tr>
                            <td>${produto.id}</td>
                            <td>${produto.descricao}</td>
                            <td>${produto.preco}</td>
                        </tr>
                    </c:forEach>
                </table>
            </main>
            <main>

                <h1>Cadastro de Pedidos</h1>
                <form action="/pedido" method="post">

                    <label>Data do Pedido:</label>
                    <input type="date" name="dataPedido" required class="input">

                    <label>ID do Produto:</label>
                    <input type="number" name="produto.id" required class="input">

                    <input type="submit" class="button" value="Cadastrar Pedido">
                </form>

                <h2>Pedidos Cadastrados</h2>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Data do Pedido</th>
                        <th>ID Produto</th>
                    </tr>
                    <c:forEach items="${pedidos}" var="pedido">
                        <tr>
                            <td>${pedido.id}</td>
                            <td>${pedido.dataPedido}</td>
                            <td>${pedido.produto.id}</td>
                        </tr>
                    </c:forEach>
                </table>
            </main>
        </body>

        </html>