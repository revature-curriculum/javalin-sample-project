@import java.util.*
@import objects.Item
@param ArrayList<Item> todoList

<html lang="en">

<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/light.min.css">
</head>
<body>

  <h3> Welcome to the Javalin Todo List! </h3> <br>

    <table>
    <tr> 
      <th> Task </th>
      <th> Mark Completed </th>
    </tr>
    @for(Item item : todoList)
      @if(!item.getStatus())
        <tr>
        <td>${item.getTask()}</td>
        <td> 
          <form method="post" action="/complete">
            <input type="hidden" id="task" name="task" value="${item.getTask()}">
            <input type="submit" value="&#10004;" style="height:40px;">
          </form>
        </td>
        </tr>
      @endif
    @endfor
    </table>
  <br> <br>

  <h3> Add Todo Item </h3>

  <form method="post" action="/postTask">
      <label>Todo Item:</label><br>
      <input type="text" id="task" name="task" placeholder="Learn Programming!"><br>
      <input type="submit" value="Submit">
    </form>

  <a href="/completedList">See Completed Tasks</a> <br>

</body>
</html>