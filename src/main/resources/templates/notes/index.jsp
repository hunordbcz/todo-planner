<a href="/">Home</a>
<hr>
<div th:switch="${notes}">
    <h2 th:case="null">No notes yet!</h2>
    <div th:case="*">
        <h3 style="margin: 0; padding: 0">Notes of the user:</h3>
        <h2 style="margin: 0; padding: 0; margin-bottom: 2rem;" th:text="${user.name}"></h2>
        <table>
            <thead>
            <tr>
                <th>Note</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <tr th:each="note : ${notes}">
                <td th:text="${note.content}"></td>
                <td><a th:href="@{/notes/edit/{id}(id=${note.id})}">Edit</a></td>
                <td><a th:href="@{/notes/delete/{id}(id=${note.id})}">Delete</a></td>
            </tr>
            </tbody>
        </table>
    </div>
    <p><a th:href="@{/notes/{id}/add/(id=${user.id})}">Add a new note</a></p>
</div>