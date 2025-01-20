package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByNameAsc() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Ab", 0));
        jobs.add(new Job("Deadline", 1));
        jobs.add(new Job("Best", 5));
        List<Job> expected = List.of(
                new Job("Ab", 0),
                new Job("Best", 5),
                new Job("Deadline", 1)
        );
        Collections.sort(jobs, new JobAscByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByNameDesc() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Ab", 0));
        jobs.add(new Job("Deadline", 1));
        jobs.add(new Job("Best", 5));
        List<Job> expected = List.of(
                new Job("Deadline", 1),
                new Job("Best", 5),
                new Job("Ab", 0)
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}