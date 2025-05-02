package students;

import java.util.Map;

public class StudentCommandHandler {

    private StudentStorage studentStorage = new StudentStorage();

    public void processCommand(Command command) {
        Action action = command.getAction();
        System.out.println("Обработка команды. Действие: " + command.getAction().name() + ", данные: " + command.getData());
        switch (action) {
            case CREATE -> processCreateCommand(command);
            case UPDATE -> processUpdateCommand(command);
            case DELETE -> processDeleteCommand(command);
            case STATS_BY_COURSE -> processStatsByCourseCommand(command);
            case STATS_BY_CITY -> processStatsByCityCommand(command);
            case SEARCH -> processSearchCommand(command);
            default -> System.out.println("Действие не поддерживается");
        }

    }

    public void processCreateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");
        Student student = new Student();
        try {
            student.setSurname(dataArray[0]);
            student.setName(dataArray[1]);
            student.setCourse(dataArray[2]);
            student.setCity(dataArray[3]);
            student.setAge(Integer.parseInt(dataArray[4]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введено недостаточно данных для создания студента.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Введены символы там, где ожидалось число.");
            return;
        } catch (Exception e) {
            System.out.println("Ошибка в введенных данных");
            return;
        }

        studentStorage.createStudent(student);
        studentStorage.printAll();
    }

    public void processUpdateCommand(Command command) {

        String data = command.getData();
        String[] dataArray = data.split(",");
        Long id;
        Student student;
        try {
            id = Long.valueOf(dataArray[0]);
            student = new Student();
            student.setSurname(dataArray[1]);
            student.setName(dataArray[2]);
            student.setCourse(dataArray[3]);
            student.setCity(dataArray[4]);
            student.setAge(Integer.parseInt(dataArray[5]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введено недостаточно данных для обновления студента.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Введены символы там, где ожидалось число.");
            return;
        } catch (Exception e) {
            System.out.println("Ошибка в введенных данных");
            return;
        }
        studentStorage.updateStudent(id, student);
        studentStorage.printAll();
    }

    public void processDeleteCommand(Command command) {
        Long id;
        try {
            id = Long.valueOf(command.getData());
        } catch (Exception e) {
            System.out.println("Необходимо ввести число - id студета");
            return;
        }
        studentStorage.deleteStudent(id);
        studentStorage.printAll();
    }

    public void processStatsByCourseCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
    }

    public void processSearchCommand(Command command) {
        studentStorage.search(command.getData());
    }

    public void processStatsByCityCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCity();
        studentStorage.printMap(data);
    }
}
