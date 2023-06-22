import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTest {

    @Test
    public void shouldSearchOneTask() {

        SimpleTask simpleTask = new SimpleTask(7, "Дача встреча");
        SimpleTask simpleTask2 = new SimpleTask(8, "Дача ремонт");
        SimpleTask simpleTask3 = new SimpleTask(9, "Дача яблоки");

        String[] subtasks = {"Дача окна", "Командировка", "Родители"};
        Epic epic = new Epic(42, subtasks);

        Meeting meeting = new Meeting(
                323,
                "Дача друзья",
                "Встреча с друзьями",
                "В воскресенье после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(epic);
        todos.add(meeting);

        //todos.findAll();

        Task[] expected = {epic};
        Task[] actual = todos.search("Дача окна");
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldSearchSeveralTasks() {

        SimpleTask simpleTask = new SimpleTask(7, "Дача встреча");
        SimpleTask simpleTask2 = new SimpleTask(8, "Дача ремонт");
        SimpleTask simpleTask3 = new SimpleTask(9, "Дача яблоки");

        String[] subtasks = {"Дача окна", "Командировка", "Родители"};
        Epic epic = new Epic(42, subtasks);

        Meeting meeting = new Meeting(
                323,
                "Дача друзья",
                "Встреча с друзьями",
                "В воскресенье после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(epic);
        todos.add(meeting);

        //todos.findAll();

        Task[] expected = {simpleTask, simpleTask2, simpleTask3, epic, meeting};
        Task[] actual = todos.search("Дача");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotSearchTasks() {

        SimpleTask simpleTask = new SimpleTask(7, "Дача встреча");
        SimpleTask simpleTask2 = new SimpleTask(8, "Дача ремонт");
        SimpleTask simpleTask3 = new SimpleTask(9, "Дача яблоки");

        String[] subtasks = {"Дача окна", "Командировка", "Родители"};
        Epic epic = new Epic(42, subtasks);

        Meeting meeting = new Meeting(
                323,
                "Дача друзья",
                "Встреча с друзьями",
                "В воскресенье после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(epic);
        todos.add(meeting);

        //todos.findAll();

        Task[] expected = {};
        Task[] actual = todos.search("Дача с друзьями");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родимтелям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQuery() {
        Todos todos = new Todos();

        Task[] expected = {};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldCheckSearchIfTaskIsExist() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.search("Позвонить родителям");

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldCheckSearchIfTaskIsExist2() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.search("Молоко");

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldCheckSearchIfTaskIsExist3() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.search("Приложение НетоБанка");

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение НетоБанка");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindQueryIfTaskIsNotExist() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.search("Кошка");

        Task[] expected = {};
        Task[] actual = todos.search("Кошка");
        Assertions.assertArrayEquals(expected, actual);

    }
}

