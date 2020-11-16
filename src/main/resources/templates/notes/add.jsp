<a href="/">Home</a>
<hr>
<form action="#" th:action="@{/notes/{id}/add/(id=${user.id})}" th:object="${note}" method="post">
    <input type="hidden" th:field="*{user}" th:value="${$user}" placeholder="Name">
    <label for="content">Content</label>
    <input type="text" th:field="*{content}" id="content" placeholder="Enter your note here"><br>
    <span style="color: red" th:if="${#fields.hasErrors('content')}" th:errors="*{content}"></span>
    <br>
    <input type="submit" value="Add Note">
</form>