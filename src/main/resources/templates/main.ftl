<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form method="post">
        <input type="text" name="text" placeholder="Bведите сообщение">
        <input type="text" name="tag" placeholder="Bведите тэг">
        <button type="submit">Добавить запись</button>
    </form>
</div>
<div>Список сообщений</div>
<div>
    <form method="post" action="filter">
        <input type="text" name="filter">
        <button type="submit">Найти</button>
    </form>
</div>
<#list messages as message>
<div>
    <b>${message.id}   </b>
    <span>${message.text}   </span>
    <i>${message.tag}   </i>
</div>
</#list>
</body>
</html>