package com.task1;

import com.task1.IslandsCountInterviewExercise;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IslandsCountInterviewExerciseTest {

    private static Stream<Object[]> maps2dWithSingleIslandSource() {
        return Stream.of(
                new Object[] {
                        new int[][]{
                                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                        }
                },
                new Object[] {
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                        }
                },
                new Object[] {
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                        }
                },
                new Object[] {
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 1},
                        }
                },
                new Object[] {
                        new int[][]{
                                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1},
                                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 1, 1, 1},
                        }
                },
                new Object[] {
                        new int[][]{
                                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1},
                                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0},
                                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 1},
                                {1, 0, 0, 0, 1, 1, 0, 0},
                                {0, 0, 0, 0, 0, 1, 1},
                        }
                }
        );
    }


    private static Stream<Object[]> maps2dWithDoubleIslandSource() {
        return Stream.of(
                new Object[] {
                        new int[][]{
                                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 1},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                        }
                },
                new Object[] {
                        new int[][]{
                                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 1, 1, 0, 0, 0},
                                {0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                        }
                },
                new Object[] {
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 0, 0, 1, 1, 1},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                        }
                },
                new Object[] {
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0},
                                {0, 0, 0, 0, 0, 0, 0, 1, 1},
                                {0, 0, 0, 0, 0, 0, 0, 1},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 1, 1, 1},
                                {0, 0, 0, 0, 0, 1, 1},
                        }
                }
        );
    }

    @ParameterizedTest
    @MethodSource("maps2dWithSingleIslandSource")
    public void testIslandCounterWith1Island(int[][] map2d) {
        //given
        //when
        int actualIslandCount = IslandsCountInterviewExercise.countIslandsBfs(map2d);
        //then
        assertEquals(1, actualIslandCount);
    }

    @ParameterizedTest
    @MethodSource("maps2dWithDoubleIslandSource")
    public void testIslandCounterWith2Islands(int[][] map2d) {
        //given
        //when
        int actualIslandCount = IslandsCountInterviewExercise.countIslandsBfs(map2d);
        //then
        assertEquals(2, actualIslandCount);
    }

}