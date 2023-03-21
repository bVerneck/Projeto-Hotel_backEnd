<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel</title>
</head>
<body>
	<form action="/hotel/cadastraHotel" method="post">
		<ul>
			<li><label for="nome">Nome:</label> <input id="nome" name="nome"
				type="text"></li>
			<li><label for="telefone_principal">Telefone principal:</label>
				<input id="telefone_principal" name="telefone_principal" type="text">
			</li>
			<li><label for="telefone_auxiliar">Telefone auxiliar:</label> <input
				id="telefone_auxiliar" name="telefone_auxiliar" type="text">
			</li>
			<li><label for="email">Email:</label> <input id="email"
				name="email" type="text"></li>
				
				
				<li>
				<label for="tipo_logradouro">Tipo logradouro:</label> 
				<select name="tipo_logradouro" id="tipo_logradouro">
					<c:forEach items="${tipoLogradouros}" var="tipoLogradouro">
						<option value="${tipoLogradouro.descricao}"> ${tipoLogradouro.descricao}</option>
					</c:forEach>
				</select>
			</li>
				

		            <li>
                <label for="logradouro">Logradouro:</label>
                <input id="logradouro" name="logradouro" type="text">
            </li>
            <li>
                <label for="numero_residencia">Numero resid�ncia:</label>
                <input id="numero_residencia" name="numero_residencia" type="text">
            </li>
            <li>
                <label for="complemento">Complemento:</label>
                <input id="complemento" name="complemento" type="text">
            </li>
            <li>
                <label for="cep">CEP:</label>
                <input id="cep" name="cep" type="text">
            </li>
             <li>
                <label for="bairro">Bairro:</label>
                <input id="bairro" name="bairro" type="text">
            </li>
            <li>
                <label for="cidade">Cidade:</label>
                <input id="cidade" name="cidade" type="text">
            </li>
            
            
            <li>
				<label for="estado">Estado:</label>
				<select name="estado" id="estado">
					<c:forEach items="${estados}" var="estado">
						<option value="${estado.nome}"> ${estado.nome}</option>
					</c:forEach>
				</select>
			</li>
            
            <li>
                <label for="pais">Pa�s:</label>
                <input id="pais" name="pais" type="text">
            </li>
         </ul>
        <input type="submit" value="salvar">
    </form>
    
</body>
</html>