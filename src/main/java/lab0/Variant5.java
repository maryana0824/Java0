package lab0;

public class Variant5 {

    /**
     * @param A довжина відрізка A (A > B)
     * @param B довжина відрізка B
     * @return довжина незанятого відрізка
     */
    public int integer5(int A, int B) {
        assert A > B : "A має бути більшим за B";
        return A % B;
    }

    /**
     * Перевіряє вираз "Справедливі нерівності A і 0 або B < -2".
     * @param a перше ціле число
     * @param b друге ціле число
     * @return true, якщо вираз справедливий, інакше false.
     */
    public boolean boolean5(int a, int b) {
        return a != 0 || b < -2;
    }

    /**
     * Знаходження кількості положитних і від'ємних чисел серед трьох цілих чисел.
     *
     * @param a перше ціле число
     * @param b друге ціле число
     * @param c третє ціле число
     * @return масив, де перший елемент - кількість положитних чисел, а другий - від'ємних чисел
     */
    public int[] if5(int a, int b, int c) {
        int positiveCount = 0;
        int negativeCount = 0;

        if (a > 0) {
            positiveCount++;
        } else if (a < 0) {
            negativeCount++;
        }

        if (b > 0) {
            positiveCount++;
        } else if (b < 0) {
            negativeCount++;
        }

        if (c > 0) {
            positiveCount++;
        } else if (c < 0) {
            negativeCount++;
        }

        return new int[]{positiveCount, negativeCount};
    }


    /**
     * Виконує арифметичну операцію над числами A і B залежно від номеру дії N.
     *
     * @param n номер дії (1 — сложение, 2 — вычитание, 3 — умножение, 4 — деление)
     * @param a перше веществене число
     * @param b друге веществене число (не дорівнює 0 для ділення)
     * @return результат арифметичної операції
     */
    public double case5(int n, double a, double b) {
        double result = 0;
        switch (n) {
            case 1:
                result = a + b;
                break;
            case 2:
                result = a - b;
                break;
            case 3:
                result = a * b;
                break;
            case 4:
                if (b != 0) {
                    result = a / b;
                } else {
                    throw new IllegalArgumentException("Ділення на нуль неможливе.");
                }
                break;
            default:
                throw new IllegalArgumentException("Невірний номер дії.");
        }
        return result;
    }


    /**
     * Розраховує та повертає вартість конфет для різної ваги від 0.1 до 1 кг.
     *
     * @param price ціна за 1 кг конфет
     * @return масив вартостей для ваги від 0.1 до 1 кг
     */
    public double[] for5(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною.");
        }

        int n = 10;  // Кількість значень від 0.1 до 1
        double[] costs = new double[n];

        for (int i = 0; i < n; i++) {
            double weight = (i + 1) * 0.1;  // Вага в кг
            costs[i] = weight * price;
        }

        return costs;
    }


    /**
     * Знаходження показника степеня числа 2
     * @param n ціле число N
     * @return показник степеня числа 2 або -1, якщо N не є степенем 2
     */
    public int while5Task(int n) {
        if (n <= 0 || (n & (n - 1)) != 0) {
            // Перевіряємо, чи n є невід'ємним числом і чи є степенем 2
            return -1; // Якщо не є, повертаємо -1
        }

        int k = 0;
        while (n > 1) {
            n /= 2;
            k++;
        }

        return k;
    }

    /**
     * Формує та повертає масив з перших N чисел Фібоначчі.
     *
     * @param n кількість чисел Фібоначчі для створення
     * @return масив з перших N чисел Фібоначчі
     */
    public int[] array5(int n) {
        if (n <= 2) {
            throw new IllegalArgumentException("N має бути більше за 2.");
        }

        int[] fibArray = new int[n];
        fibArray[0] = 1;
        fibArray[1] = 1;

        for (int i = 2; i < n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }

        return fibArray;
    }

    /**
     * Формування матриці за заданими параметрами
     * @param M кількість рядків матриці
     * @param N кількість стовбців матриці
     * @param D число, яке додається до кожного елементу стовбця
     * @param numbers набір чисел для першого стовбця матриці
     * @return сформована матриця
     */
    public int[][] matrix5Task(int M, int N, int D, int[] numbers) {
        if (M <= 0 || N <= 0 || numbers == null || numbers.length != M) {
            return null; // Перевіряємо некоректні вхідні дані
        }

        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    // Перший стовбець - копіюємо набір чисел
                    matrix[i][j] = numbers[i];
                } else {
                    // Інші стовбці - додаємо D до попереднього стовбця
                    matrix[i][j] = matrix[i][j - 1] + D;
                }
            }
        }
        return matrix;
    }

    /**
     * Знайти номер і плотність деталі з максимальною плотністю
     * @param N кількість деталей
     * @param pairs набір пар чисел (маса, об'єм)
     * @return масив, де перший елемент - номер деталі з максимальною плотністю,
     *         а другий елемент - величина максимальної плотності
     */
    public double[] minmax5Task(int N, double[][] pairs) {
        if (N <= 0 || pairs == null || pairs.length != N || pairs[0].length != 2) {
            return null; // Перевіряємо некоректні вхідні дані
        }

        int maxDensityIndex = -1;
        double maxDensity = Double.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            double mass = pairs[i][0];
            double volume = pairs[i][1];
            double density = mass / volume;

            if (density > maxDensity) {
                maxDensity = density;
                maxDensityIndex = i;
            }
        }

        return new double[]{maxDensityIndex, maxDensity};
    }
}
