
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Task1();
        //Task2();
        //Task3();
        //Task4();
        Task5();
    }


    //Задание № 1
    //Организовать ввод с клавиатуры даты рождения человека,
    // программа должна вывести знак зодиака и
    // название года по японскому календарю. Предполагаем,
    //что пользователь всегда корректно вводит данные.

    public static void Task1(){
        System.out.println("Задание № 1");
        Scanner scanner = new Scanner(System.in);

        Zodiac[] zodiacs = new Zodiac[] {
                new Zodiac("Овен", new int[] {21, 3}, new int[] {20, 4} ),
                new Zodiac("Телец", new int[] {21, 4}, new int[] {20, 5} ),
                new Zodiac("Близнецы", new int[] {21, 5}, new int[] {21, 6} ),
                new Zodiac("Рак", new int[] {22, 6}, new int[] {22, 7} ),
                new Zodiac("Лев", new int[] {23, 7}, new int[] {22, 8} ),
                new Zodiac("Дева", new int[] {23, 8}, new int[] {23, 9} ),
                new Zodiac("Весы", new int[] {24, 9}, new int[] {23, 10} ),
                new Zodiac("Скорпион", new int[] {24, 10}, new int[] {22, 11} ),
                new Zodiac("Стрелец", new int[] {23, 11}, new int[] {21, 12} ),
                new Zodiac("Козерог", new int[] {22, 12}, new int[] {20, 1} ),
                new Zodiac("Водолей", new int[] {21, 1}, new int[] {18, 2} ),
                new Zodiac("Рыбы", new int[] {19, 2}, new int[] {20, 3} )
        };

        String[] nameYear = new String[]{
                "Крыса","Бык","Тигр","Кролик","Дракон","Змея","Лошадь",
                "Овца","Обезьяна","Петух","Собака","Свинья"
        };

        System.out.println("Введите дату рождения! Сначала день: ");
        int day = scanner.nextInt();
        System.out.println("Теперь месяц: ");
        int month = scanner.nextInt();
        System.out.println("Теперь год: ");
        int year = scanner.nextInt();

        String resultNameZodiac = "";

        for (int i = 0; i < zodiacs.length; i++) {
            if (day >= zodiacs[i].minDate[0] && month == zodiacs[i].minDate[1] ||
                    day <= zodiacs[i].maxDate[0] && month == zodiacs[i].maxDate[1])
            {
                resultNameZodiac = zodiacs[i].nameZodiac;
                break;
            }
        }

        int result = year - 2020;
        String resultYear = "";

        for (int i = 0; i < nameYear.length; i++) {
            if ((result - i) % 12 == 0){
                resultYear = nameYear[i];
                break;
            }
        }

        System.out.println("Знак: " + resultNameZodiac + " Год: " + resultYear);
    }


    //Задание №2
    //Программа запрашивает шестизначное число, после
    //ввода определяет будет ли являтся счастливым билет
    //с таким номером (сумма первых трех цифр совпадает
    //с сумой трех последних).

    public static void Task2(){
        System.out.println("Задание № 2");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите шестизначное число");

        String number = scanner.next();

        String[]  numbers = number.split("");

        if (Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]) + Integer.parseInt(numbers[2]) ==
                Integer.parseInt(numbers[3]) + Integer.parseInt(numbers[4]) + Integer.parseInt(numbers[5])){
            System.out.println("Да");
        }
        else {
            System.out.println("Нет");
        }
    }


    //Задание №3
    //Необходимо нарисовать ёлочку символом звёздочки.
    //Каждый новый ярус должен быть шире предыдущего.
    //С клавиатуры вводится количество ярусов, и высота
    //первого (верхнего) яруса ёлочки. Ёлочка должна быть симметричная.

    public static void Task3(){
        System.out.println("Задание № 3");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число ярусов и высоту через пробел:");

        String date = scanner.nextLine();
        String[] strSplit = date.split(" ");
        int tier = Integer.parseInt(strSplit[0]);
        int height = Integer.parseInt(strSplit[1]);

        int countSpace = tier;

        for (int a= 0 ; a < tier; a++){
            int count = 1;
            int space = height + countSpace;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < space; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < count; j++) {
                    System.out.print("*");
                }
                System.out.println();
                count += 2;
                space --;
            }
            height++;
            countSpace --;
        }
    }

    //Задание №4
    // Сформируйте массив из 10 элементов, заполнив его
    //целыми случайными числами от –10 до 10. Определите
    //среднее арифметическое элементов массива. Сформируйте новый массив, переписав в него элементы
    //исходного массива, меньшие среднего.
    //Выполните сортировку исходного массива по возрастанию элементов.

    public static void Task4() {
        System.out.println("Задание № 4");

        Random random = new Random();

        int[] array = new int[10];

        int avarage = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(30);
            if (array[i] > 10){
                array[i] -= 20;
            }
            System.out.print(array[i] + " ");
            avarage += array[i];
        }

        avarage = avarage / 10;
        int[] newArray = new int[10];

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < avarage){
                newArray[i] = array[i];
            }
            else newArray[i] = 0;
            System.out.print(newArray[i] + " ");
        }

        Arrays.sort(array);
        System.out.println("Сортировка массива");
        for (int value: array) {
            System.out.print(value + " ");
        }
    }

    //Задание №5
    //  Сформируйте двумерный целочисленный массив.
    //Число строк и столбцов нужно запросить у пользователя.
    // Заполните массив случайными числами от 0
    //до 10 и выведите его на консоль. Удалите из массива
    //одну строку (номер строки запросите у пользователя).
    //Распечатайте полученный массив. Используйте статические
    // методы для реализации каждого действия
    //(инициализация массива, вывод на консоль, удаление
    //строки).

    public static void Task5() {
        System.out.println("Задание № 5");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число строк");
        int str = scanner.nextInt();

        System.out.println("Введите число столбцов");
        int column = scanner.nextInt();

        int[][] matrix = initialMatrix(str, column);

        DisplayInfo(matrix);

        System.out.println("Введите номер строки для удаления");
        int strDelete = scanner.nextInt();

        int[][] newMatrix = initialDeleteStrMatrix(strDelete, matrix);

        DisplayInfo(newMatrix);


    }

    public static int[][] initialMatrix(int str, int column) {
        int[][] matrix = new int[str][column];

        Random random = new Random();

        for (int i = 0; i < str; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }

        return matrix;
    }

    public static int[][] initialDeleteStrMatrix(int strDelete, int[][] matrix) {

        int[][] newMatrix = new int[matrix.length - 1][matrix[0].length];

        for (int i = 0; i < newMatrix.length; i++) {
            if (strDelete == matrix.length && strDelete == i){
                break;
            }
            if (i >= strDelete) {
                for (int j = 0; j < newMatrix[0].length; j++) {
                    newMatrix[i][j] = matrix[i+1][j];
                }
            }
            else{
            for (int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
            }
        }
        return newMatrix;
    }

    public static void DisplayInfo(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}