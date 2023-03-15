<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
        <ul>
            <li>
                <label for="nome">Nome:</label>
                <input id="nome" name="nome" type="text">
            </li>
            <li>
                <label for="dataNascimento">Data de Nascimento</label>
                <input id="dataNascimento" name="cpf" type="date">
            </li>
            <li>
                <label for="precoCrianca">Preço por Criança:</label>
                <input id="precoCrianca" name="precoCrianca" type="text">
            </li>
            <li>
                <p>contato_id_contato</p>
            </li>
            <li>
                <p>endereco_id_endereco</p>
            </li>
            <li>
                <p>reserva_id_reserva</p>
            </li>
        </ul>
        <input type="submit" value="salvar">
    </form>
	
</body>
</html>