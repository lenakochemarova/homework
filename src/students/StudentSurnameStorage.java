package students;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StudentSurnameStorage {
    private TreeMap<String, Set<Long>> surnameTreeMap = new TreeMap<String, Set<Long>>();

    public void studentCreated(Long id, String surname) {
        Set<Long> existingIds = surnameTreeMap.getOrDefault(surname, new HashSet<>());
        existingIds.add(id);
        surnameTreeMap.put(surname, existingIds);
    }

    public void studentDeleted(Long id, String surname) {
        surnameTreeMap.get(surname).remove(id);
    }

    public void studentUpdated(Long id, String oldSurname, String newSurname) {
        studentDeleted(id, oldSurname);
        studentCreated(id, newSurname);
    }

    public Set<Long> getStudentBySurnameLessOrEqualThan(String surname) {
        return surnameTreeMap.headMap(surname, true)
                .values()
                .stream()
                .flatMap(longs -> longs.stream())
                .collect(Collectors.toSet());
    }

    public Set<Long> getStudentBetweenSurnames(String s1, String s2) {
        return surnameTreeMap.subMap(s1, true, s2, true)
                .values()
                .stream()
                .flatMap(longs -> longs.stream())
                .collect(Collectors.toSet());
    }
}
