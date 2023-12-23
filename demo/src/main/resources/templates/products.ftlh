<!DOCTYPE html>
<html>
<head>
	<title>DEMO</title>
</head>
<body>
<h1>DEMO</h1><hr>
<h4>Груминг-салон</h4>
<form action="/" method="get">
	Поиск по названию услуги: <input type = "text" name="title"><br>
	<input type="submit" value="Поиск"/>
</form>
<#list products as product>
	<div>
		<p><b>${product.title}</b>${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
	</div>
	<#else>
	<h3>Услуг нет</h3>
</#list> 
<hr>
<h3>Создать новую услугу</h3>
<form action="/product/create" method="post">
	Название услуги: <input type="text" name="title"/><br><br>
	Описание услуги: <input type="text" name="description"/><br><br>
	Цена услуги: <input type="number" name="price"/><br><br>
	<input type="submit" value="Добавить услугу"/>
</form>	
</body>
</html>
