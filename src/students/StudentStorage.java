package students;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentStorage {
    private Map<Long, Student> studentStorageMap = new HashMap<>();
    private StudentSurnameStorage studentSurnameStorage = new StudentSurnameStorage();
    private Long currentId = 0L;

    public Long createStudent(Student student) {
        Long nextId = getNextId();
        studentStorageMap.put(nextId, student);
        studentSurnameStorage.studentCreated(nextId, student.getSurname());
        return nextId;
    }

    public boolean updateStudent(Long id, Student student) {
        if (!studentStorageMap.containsKey(id))
            return false;
        else {
            studentSurnameStorage.studentUpdated(id, studentStorageMap.get(id).getSurname(), student.getSurname());
            studentStorageMap.put(id, student);
            return true;
        }
    }

    public boolean deleteStudent(Long id) {
        Student removed = studentStorageMap.remove(id);
        if (removed != null) {
            String surname = removed.getSurname();
            studentSurnameStorage.studentDeleted(id, surname);
        }
        return removed != null;
    }

    public Long getNextId() {
        currentId++;
        return currentId;
    }

    public void printAll() {
        System.out.println(studentStorageMap);
    }

    public void printMap(Map<String, Long> data) {
        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());
        });
    }

    public Map<String, Long> getCountByCourse() {
        return studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        s -> s.getCourse(),
                        s -> 1L,
                        (c1, c2) -> c1 + c2
                ));
    }

    public void search(String surname) {
        String[] strings = surname.split(",");
        if (strings.length == 1 && !strings[0].equals("")) {
            String name = strings[0];
            System.out.println(studentStorageMap.values().stream()
                    .filter(student -> student.getSurname().equals(name))
                    .collect(Collectors.toSet()));
        } else if (strings.length == 2) {
            String str1 = strings[0];
            String str2 = strings[1];
            Set<Long> students;
            if (str1.compareTo(str2) < 0) {
                students = studentSurnameStorage.getStudentBetweenSurnames(str1, str2);
            } else
                students = studentSurnameStorage.getStudentBetweenSurnames(str2, str1);
            for (Long studentId : students) {
                Student student = studentStorageMap.get(studentId);
                System.out.println(student);
            }
        } else if (strings[0].equals("")) {
            printAll();
        } else {
            System.out.println("Ошибка ввода");
        }
    }

    public Map<String, Long> getCountByCity() {
        return studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        student -> student.getCity(),
                        student -> 1L,
                        (c1, c2) -> c1 + c2
                ));
    }
}

