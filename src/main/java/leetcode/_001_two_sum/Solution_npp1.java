package leetcode._001_two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution_npp1 extends Solution {

//    public static void main(String[] args) {
//        String s = "a";
//        System.out.println(s.isEmpty());
//    }

//    Синтаксические ошибки
//    nums.length() -  length это поле а не метод. Хотя у string length(), а у Lists size()
//    for(int i:= 0; i < nums.length; i++){   нужно присваивание без двоеточия
//    int[] result = new int[2]{};              здесь угловые ковычки не нужны

//    Логические ошибки
//    1) Забыл break
//    result[1] = nums[secondNums.get(firstNum)];   нужно result[1] = secondNums.get(firstNum);


//    Сложность по времени
//    Сохранение и взятие из HashMap выполняется за константное время
//    На деле конечно в случае коллизий внутри мапы могут образовываться LinkedList или Tree
//    (у листа линейное время, у дерева логарифмическая) но при оценке все равно время считается константным
//    Поскольку два цикла здесь время O(2n) = O(n)

//    Сложность по памяти Я пока не трачу время на этот анализ.
//    Сложность по памяти оценивается реже

//    Boxing и Unboxing performance issues я не оцениваю. Нужно перечитать Effective Java


    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> secondNums = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            secondNums.put(nums[i], i);
        }

        int[] result = new int[2];

        for(int i= 0; i < nums.length; i++){
            Integer firstNum = target - nums[i];
            if(secondNums.containsKey(firstNum)) {
                result[1] = i;
                result[0] = secondNums.get(firstNum);
                break;
            }
        }

        return result;

    }
}
