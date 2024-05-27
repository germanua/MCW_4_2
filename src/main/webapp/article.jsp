<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple Blog</title>
</head>
<body>
<h1>Articles</h1>
<ul>
    <c:forEach var="article" items="${articles}">
        <li>
            <h2>${article.title}</h2>
            <p>${article.content}</p>
            <p>Published on: ${article.publicationDate}</p>
        </li>
    </c:forEach>
</ul>
<hr>
<h2>Add New Article</h2>
<form action="article.jsp" method="post">
    <label for="title">Title:</label><br>
    <input type="text" id="title" name="title"><br>
    <label for="content">Content:</label><br>
    <textarea id="content" name="content"></textarea><br>
    <label for="publicationDate">Publication Date (YYYY-MM-DD):</label><br>
    <input type="text" id="publicationDate" name="publicationDate"><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
