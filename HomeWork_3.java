
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomeWork_3 {

    public static void main(String[] args) {
        // Выполнение задачи 1
        System.out.println("TASK No 1");
        List<Integer> list_1 = createListInt();
        System.out.println("  List before deletion:");
        System.out.println(list_1);
        System.out.println("  List after deletion:");
        task1(list_1);
        System.out.println();

        // Выполнение задачи 2
        System.out.println("TASK No 2");
        List<Integer> list_2 = createListInt();
        task2(list_2);
        System.out.println();

        // Выполнение задачи 3
        System.out.println("TASK No 3");
        List<Integer> list_3 = createListInt();
        System.out.println("  List before sorting:");
        System.out.println(list_3);
        System.out.println("  List after sorting:");
        list_3 = sort(list_3);
        System.out.println(list_3);
               
    }

    static List<Integer> createListInt(){
        List<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        int n = rnd.nextInt(7, 10); 
        for(int i=0; i<n; i++)
            list.add(rnd.nextInt(10, 99));
        return list;
    }

    // Task 1
    /*
        Пусть дан произвольный список целых чисел,
        удалить из него четные числа
    */
    static void task1(List<Integer> list){
        for (int i = 0; i < list.size(); ) {
            if (list.get(i) % 2 == 0){
                    list.remove(i);
                }
            else i++;                
        }
        System.out.println(list);
    }    

    // Task 2
    /*
        Задан целочисленный список ArrayList. 
        Найти минимальное, максимальное и среднее арифметическое из этого списка
    */
    static void task2(List<Integer> list){
        // конечно, можно воспользоваться Collections.max(list) и Collections.min(list),
        // но для подсчёта среднего значения я не нашла ничего типа 
        // Collections.average(list) или Collections.sum(list)
        // поэтому все величины я буду искать вручную в списке,
        // иначе для вычисления среднего я пройдусь по списку,
        // а вызовом его методов подсчёта максимального и минимального
        // он снова будет проходиться по списку - лучше найду всё за один проход

        int maxValue = list.get(0);
        int minValue = list.get(0);
        double averageValue = 0; 
        for(int i=0; i < list.size();i++){
            int value = list.get(i);
            if(value > maxValue) maxValue = value;
            if(value < minValue) minValue = value;
            averageValue += value;      
        }
        averageValue /= list.size();
        
        System.out.println(list);
        System.out.println("  Maximum value = " + maxValue);
        System.out.println("  Minimum value = " + minValue);
        System.out.println("  Average value = " + averageValue);
    }
    
    // Task 3
    /*
        Реализовать алгоритм сортировки слиянием 
    */
    static List<Integer> sort(List<Integer> list){
        if (list == null)
            return null;

        if(list.size() == 1)
            return list;
        
        List<Integer> left = new ArrayList<>();  // list.size() / 2;
        List<Integer> right = new ArrayList<>(); // list.size() - list.size() / 2;

        int n = list.size() / 2;
        // копирую левую часть от начала до середины
        //System.arraycopy(list, 0, left, 0, list.size() / 2);
        for (int i = 0; i < n; i++)
            left.add(list.get(i));

        // копирую правую часть от середины до конца массива
        //System.arraycopy(list, list.size() / 2, right, 0, list.size() - list.size() / 2);
        for (int i = 0; i < list.size() - n; i++)
            right.add(list.get(n + i));

        // рекурсией от поделенных обеих частей вызываю метод sort, 
        // пока не дойдет до одного элемента в массиве
        left = sort(left); 
        right = sort(right);

        // и затем рекурсивно слияю два отсортированных массива
        return mergeSort(left, right);
    }

    static List<Integer> mergeSort(List<Integer> left, List<Integer> right){
        List<Integer> mergelist = new ArrayList<>();
        int l = 0;  // счетчики длины левого массив
        int r = 0;  // счетчики длины правого массив
        int length = left.size() + right.size();
        for (int i = 0; i < length; i++){
           if (r == right.size()){
                mergelist.add(left.get(l));
               l++;
              }
          else if (l < left.size() && left.get(l) < right.get(r)){
                    mergelist.add(left.get(l));
                  l++;
                }
               else{
                    mergelist.add(right.get(r));
                   r++;
                }
        }
        return mergelist;
    }

}

    
