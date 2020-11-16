<a href="/">Home</a>
<hr>
<form action="#"
      th:action="@{/users/add}"
      th:object="${user}"
      method="post">
    <label for="name">Name</label>
    <input type="text" th:field="*{name}" id="name" placeholder="Name"><br>
    <span style="color: red" th:if="${#fields.hasErrors('name')}" th:errors="*{name}"></span>
    <br>
    <label for="email">Email</label>
    <input type="text" th:field="*{email}" id="email" placeholder="Email"><br>
    <span style="color: red" th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></span>
    <br>
    <input type="submit" value="Add User">
</form>