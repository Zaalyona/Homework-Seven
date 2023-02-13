import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //седьмая домашка
        //задача первая
        checkLeapYear(2023);

        //вторая
        int currentYear = LocalDate.now().getYear();
        checkOSAndYearPhone(false, currentYear);

        //третья
        System.out.println("Потребуется дней: " + calculateDeliveryDays(35));

        //четвёртая
        String str = "aabccddefgghiijjkk";
        checkDuplicateSymbol(str);

        //пятая
        int[] arrNumbers = {3, 2, 1, 6, 5};
        reverseArray(arrNumbers);
        printArray(arrNumbers);

        //шестая
        int[] arrExpenses = generateRandomArray();
        printArray(arrExpenses);
        float averageExpense = calculateAverageExpense(arrExpenses);
        System.out.println("Средняя сумма трат за месяц составила " + String.format("%.2f", averageExpense) + " рублей");
    }

    //метод определения високосного года
    public static void checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " - високосный год");
        }
        else {
            System.out.println(year + " - не високосный год");
        }
    }

    //метод проверки версии ОС на телефоне
    public static void checkOSAndYearPhone (boolean isAndroid, int year) {
        if (!isAndroid && year >= 2015) {
            System.out.println("Установите версию для iOS по ссылке");
        }
        else if (!isAndroid && year < 2015) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        }
        if (isAndroid && year >= 2015) {
            System.out.println("Установите версию для Android по ссылке");
        }
        else if (isAndroid && year < 2015) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        }
    }

    //метод определения дней доставки
    public static byte calculateDeliveryDays(int deliveryDistance) {
        byte deliveryTime = 0;
        if ((deliveryDistance <= 0) || (deliveryDistance >= 100)) {
            System.out.println("Куда доставляем-то?");
        }
        else {
            deliveryTime++;
            if (deliveryDistance > 20) {
                deliveryTime++;
                if (deliveryDistance > 60) {
                    deliveryTime++;
                }
            }
        }
        return deliveryTime;
    }

    //метод поиска дублированного символа
    public static void checkDuplicateSymbol(String str) {
        char[] repeatChars = str.toCharArray();
        for (int i = 0; i < repeatChars.length - 1; i++) {
            if (repeatChars[i] == repeatChars[i + 1]) {
                System.out.println("В строке " + str + " первый повторяющийся символ - " + repeatChars[i]);
                return;
            }
        }
        System.out.println("В строке " + str + " нет одинаковых символов");
    }

    //метод перемещения элементов массива к лесу - передом, ко мне - задом
    public static void reverseArray(int[] arr) {
        int firstElement;
        int pastElement;
        int tempIndex;
        for (int i = 0; i < arr.length/2; i++) {
            tempIndex = arr.length - 1 - i;
            firstElement = arr[tempIndex];
            pastElement = arr[i];
            arr[i] = firstElement;
            arr[tempIndex] = pastElement;
        }
    }

    //метод генерации значений массива выплат
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    //метод вычисления среднего значения выплат за месяц
    public static float calculateAverageExpense(int[] arr) {
        int summaryExpenses = sumExpenses(arr);
        float averageExpense = (float) summaryExpenses / arr.length;
//        averageExpense.
        return averageExpense;
    }

    //метод суммирования всех выплат
    public static int sumExpenses(int[] arr) {
        int sumExpenses = 0;
        for (int i = 0; i < arr.length; i++) {
            sumExpenses = sumExpenses + arr[i];
        }
        return sumExpenses;
    }

    //метод вывода на экран всех элементов массива
    public static void printArray(int[] arr) {
        System.out.println("Массив чисел:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("===================");
    }
}