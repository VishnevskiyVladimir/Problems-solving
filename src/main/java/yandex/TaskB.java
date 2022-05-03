package yandex;

public class TaskB {
    //    Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.
    public long count(boolean[] sequence) {

        int count = 0;
        int maxCount = 0;

        int seqLength = sequence.length;
        for (boolean b : sequence) {
            if (b)
                count++;
            else {
                if (maxCount < count)
                    maxCount = count;
                count = 0;
            }
        }
        return maxCount;
    }
}
