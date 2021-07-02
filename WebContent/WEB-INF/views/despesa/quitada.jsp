<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<td>${despesa.id}</td>
<td>${despesa.descricao}</td>
<td>Pago</td>
<td><fmt:formatDate value="${despesa.dataPagamento.time}" pattern="dd/MM/yyyy" /></td>
<td><a class="remover" href="#" id="${despesa.id}">Remover</a></td>
<td><a href="mostraDespesa?id=${despesa.id}">Alterar</a></td>
