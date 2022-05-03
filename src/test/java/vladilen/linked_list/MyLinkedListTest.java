package vladilen.linked_list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MyLinkedListTest {

    private MyLinkedList<Integer> list = null;
    private final Random random = new Random();

    private final int testRepetitions = 3;

    @Nested
    @DisplayName("list size tests")
    class SizeTests {

        @Test
        public void sizeEqualsZeroWhenListIsEmpty() {
            list = new MyLinkedList<>();
            assertEquals(0, list.getSize());
        }

        @RepeatedTest(testRepetitions)
        public void sizeIncreasesByOneEachAddLast() {
            int size = random.nextInt(9) + 1;
            list = generateListByAddLast(size);
            assertEquals(size, list.getSize());
        }

        @RepeatedTest(testRepetitions)
        public void sizeIncreasesByOneEachAddFirst() {
            int size = random.nextInt(9) + 1;
            list = generateListByAddFirst(size);
            assertEquals(size, list.getSize());
        }

        @RepeatedTest(testRepetitions)
        public void sizeDecreasesByOneEachRemoveLast() {
            int size = 10;
            int repetitions = random.nextInt(9) + 1;
            list = generateListByAddLast(size);
            for (int i = 0; i < repetitions; i++)
                list.removeLast();

            assertEquals(size - repetitions, list.getSize());
        }

        @RepeatedTest(testRepetitions)
        public void sizeDecreasesByOneEachRemoveFirst() {
            int size = 10;
            int repetitions = random.nextInt(9) + 1;
            list = generateListByAddLast(size);
            for (int i = 0; i < repetitions; i++)
                list.removeFirst();

            assertEquals(size - repetitions, list.getSize());
        }
    }

    @Nested
    @DisplayName("list additions tests")
    class AdditionsTests {

        @RepeatedTest(testRepetitions)
        void addFirstSeveralTimes() {
            int randomNumber = random.nextInt(100) + 10;
            list = generateListByAddFirst(2);
            list.addFirst(randomNumber);

            assertEquals(randomNumber, list.getFirst());
        }

        @RepeatedTest(testRepetitions)
        void addLastSeveralTimes() {
            int randomNumber = random.nextInt(100) + 10;
            list = generateListByAddLast(2);
            list.addLast(randomNumber);

            assertEquals(randomNumber, list.getLast());
        }

        @Test
        void addFirstWhenSizeIsZero() {
            int randomNumber = random.nextInt(100) + 10;
            list = generateListByAddLast(0);
            list.addFirst(randomNumber);

            assertEquals(randomNumber, list.getLast());
        }
    }

    @Nested
    @DisplayName("list removing tests")
    class RemovingTests {

        @Test
        void removeFirstWhenListHasSizeZeroShouldThrowException() {
            list = generateListByAddFirst(0);

            assertThrows(NoSuchElementException.class, () -> list.removeFirst());
        }

        @Test
        void removeLastWhenListHasSizeZeroShouldThrowException() {
            list = generateListByAddLast(0);

            assertThrows(NoSuchElementException.class, () -> list.removeLast());
        }

        @Test
        void removeFirstWhenListHasSizeOne() {
            list = generateListByAddFirst(1);
            list.removeFirst();
            assertEquals(0, list.getSize());
        }

        @Test
        void removeLastWhenListHasOne() {
            list = generateListByAddLast(1);
            list.removeLast();
            assertEquals(0, list.getSize());
        }
    }

    @Nested
    @DisplayName("get elements tests")
    class GetElementsTests {

        @RepeatedTest(testRepetitions)
        void getFirstWhenListIsNotEmpty() {
            list = generateListByAddFirst(2);
            int newElement = random.nextInt(100) + 10;
            list.addFirst(newElement);

            assertEquals(newElement, list.getFirst());
        }

        @Test
        void getWhenListIsNotEmptyAndIndexInLeftPart() {
            int size = 6;
            list = generateListByAddLast(size);
            int index = size / 2 - 1;
            assertEquals(index, list.get(index));
        }

        @Test
        void getWhenListIsNotEmptyAndIndexInRightPart() {
            int size = 6;
            list = generateListByAddLast(size);
            int index = size / 2 + 1;
            assertEquals(index, list.get(index));
        }

        @RepeatedTest(testRepetitions)
        void getLastWhenListIsNotEmpty() {
            list = generateListByAddFirst(2);
            int newElement = random.nextInt(100) + 10;
            list.addLast(newElement);

            assertEquals(newElement, list.getLast());
        }

        @RepeatedTest(testRepetitions)
        void getFirstWhenListIsEmptyShouldThrowException() {
            list = new MyLinkedList<>();

            assertThrows(NoSuchElementException.class, () -> list.getFirst());
        }

        @RepeatedTest(testRepetitions)
        void getLastWhenListIsEmptyShouldThrowException() {
            list = new MyLinkedList<>();

            assertThrows(NoSuchElementException.class, () -> list.getLast());
        }


    }


    private MyLinkedList<Integer> generateListByAddLast(int size) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = 0; i < size; i++)
            list.addLast(i);

        return list;
    }

    private MyLinkedList<Integer> generateListByAddFirst(int size) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        for (int i = size - 1; i >= 0; i--)
            list.addLast(i);

        return list;
    }
}