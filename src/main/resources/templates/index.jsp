<div th:switch="${users}">
    <h2 th:case="null">No users yet!</h2>
    <div th:case="*">
        <h2>Users</h2>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <tr th:each="user : ${users}">
                <td th:text="${user.name}"></td>
                <td th:text="${user.email}"></td>
                <td><a th:href="@{/edit/{id}(id=${user.id})}">Edit</a></td>
                <td><a th:href="@{/delete/{id}(id=${user.id})}">Delete</a></td>
            </tr>
            </tbody>
        </table>
    </div>
    <p><a href="/signup">Add a new user</a></p>
</div>