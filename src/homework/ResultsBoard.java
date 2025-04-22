package homework;

import java.util.*;

public class ResultsBoard {
    Map<Float, String> students;

    public ResultsBoard(){
        students = new TreeMap<>();
    }
    void addStudent(String name, Float score) {
        students.put(score,name);
    }

    List<String> top3 () {
        Map<Float,String> set = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Float,String> s : students.entrySet()){
            set.put(s.getKey(),s.getValue());
        }
        List<String> res = new ArrayList<>(3);
        for (String s : set.values()) {
            if (res.size() == 3) break;
            res.add(s);
        }
        return res;
    }

    @Override
    public String toString() {
        return "ResultsBoard{" +
                "students= " + students +
                '}';
    }

    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("Lena",4.7f);
        resultsBoard.addStudent("Leonid",3.9f);
        resultsBoard.addStudent("Rita",4.1f);
        resultsBoard.addStudent("Alex",3.5f);
        System.out.println(resultsBoard);
        System.out.println(resultsBoard.top3());
    }
}
