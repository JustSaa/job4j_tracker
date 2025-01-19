package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sumOfScore = 0;
        int quantitySubject = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumOfScore += subject.score();
                quantitySubject++;
            }
        }
        return (double) sumOfScore / quantitySubject;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sumOfScore = 0;
            int quantitySubject = 0;
            for (Subject subject : pupil.subjects()) {
                sumOfScore += subject.score();
                quantitySubject++;
            }
            Label label = new Label(pupil.name(), (double) sumOfScore / quantitySubject);
            labelList.add(label);
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> totalScores = new LinkedHashMap<>();
        Map<String, Integer> subjectCount = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScores.put(subject.name(), totalScores.getOrDefault(subject.name(), 0)
                        + subject.score());
                subjectCount.put(subject.name(), subjectCount.getOrDefault(subject.name(), 0) + 1);
            }
        }

        List<Label> labels = new ArrayList<>();
        for (String subjectName : totalScores.keySet()) {
            double averageScore = (double) totalScores.get(subjectName) / subjectCount.get(subjectName);
            labels.add(new Label(subjectName, averageScore));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sumOfScore = 0;
            for (Subject subject : pupil.subjects()) {
                sumOfScore += subject.score();
            }
            Label label = new Label(pupil.name(), sumOfScore);
            labelList.add(label);
        }
        labelList.sort(Comparator.naturalOrder());

        return labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(subject.name(), subjectScores.getOrDefault(subject.name(), 0)
                        + subject.score());
            }
        }

        List<Label> labelList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            labelList.add(new Label(entry.getKey(), entry.getValue()));
        }

        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}