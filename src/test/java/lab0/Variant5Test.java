package lab0;
import lab0.Variant5;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Variant5Test {

    public static double EPS = 0.0000001;

    ////////////////////////////////////////////////

    @Test(dataProvider = "integer5Provider")
    public void testInteger5(int A, int B, int expected) {
        assertEquals(new Variant5().integer5(A, B), expected);
    }

    @DataProvider
    public Object[][] integer5Provider() {
        return new Object[][]{
                {10, 3, 1},  // A = 10, B = 3, A % B = 1
                {20, 7, 6},  // A = 20, B = 7, A % B = 6
                {15, 5, 0}   // A = 15, B = 5, A % B = 0
        };
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "if5Provider")
    public void testIf5(int a, int b, int c, int[] expected) {
        assertEquals(new Variant5().if5(a, b, c), expected);
    }

    @DataProvider
    public Object[][] if5Provider() {
        return new Object[][]{
                {1, 2, 3, new int[]{3, 0}},  // 3 positive, 0 negative
                {-1, -2, -3, new int[]{0, 3}},  // 0 positive, 3 negative
                {0, 0, 0, new int[]{0, 0}},  // 0 positive, 0 negative
                {1, -2, 3, new int[]{2, 1}}  // 2 positive, 1 negative
        };
    }
    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int a, int b, boolean expected) {
        boolean result = new Variant5().boolean5(a, b);
        assertEquals(result, expected);
    }

    @DataProvider(name = "booleanProvider")
    public Object[][] booleanProvider() {
        return new Object[][] {
                { 1, -3, true },   // Перевірка, коли обидва числа задовольняють умовам
                { 1, 0, true },    // Перевірка, коли тільки A задовольняє умовам
                { 0, -3, true },   // Перевірка, коли тільки B задовольняє умовам
                { 0, 0, false }    // Перевірка, коли жодна з умов не задовольняється
        };
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "for5Provider")
    public void testFor5(double price, double[] expected) {
        Variant5 variant5 = new Variant5();
        double[] result = variant5.for5(price);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(result[i], expected[i], 0.0001); // Порівняння з точністю до 4 знаків після коми
        }
    }

    @DataProvider
    public Object[][] for5Provider() {
        return new Object[][] {
                { 2.0, new double[] { 0.2, 0.4, 0.6, 0.8, 1.0, 1.2, 1.4, 1.6, 1.8, 2.0 } },
                { 1.5, new double[] { 0.15, 0.3, 0.45, 0.6, 0.75, 0.9, 1.05, 1.2, 1.35, 1.5 } },
                { 0.75, new double[] { 0.075, 0.15, 0.225, 0.3, 0.375, 0.45, 0.525, 0.6, 0.675, 0.75 } }
        };
    }

    //////////////////////////////////////////

    @Test(dataProvider = "while5Provider")
    public void while5Test(int n, int k) {
        assertEquals(new Variant5().while5Task(n), k);
    }

    @DataProvider
    public Object[][] while5Provider() {
        return new Object[][] { { 1, 0 }, { 2, 1 }, { 4, 2 }, { 8, 3 }, { 16, 4 } };
    }
    //////////////////////////////////////////

    @Test(dataProvider = "array5Provider")
    public void testArray5(int n, int[] expected) {
        assertEquals(new Variant5().array5(n), expected);
    }

    @DataProvider
    public Object[][] array5Provider() {
        return new Object[][]{
                {3, new int[]{1, 1, 2}},  // Перші 3 числа Фібоначчі
                {5, new int[]{1, 1, 2, 3, 5}},  // Перші 5 чисел Фібоначчі
                {8, new int[]{1, 1, 2, 3, 5, 8, 13, 21}},  // Перші 8 чисел Фібоначчі
        };
    }


    @Test(dataProvider = "case5Provider")
    public void testCase5(int n, double a, double b, double expected) {
        assertEquals(new Variant5().case5(n, a, b), expected);
    }

    @DataProvider
    public Object[][] case5Provider() {
        return new Object[][]{
                {1, 5.0, 3.0, 8.0},  // Сложение: 5.0 + 3.0 = 8.0
                {2, 10.0, 4.0, 6.0},  // Вычитание: 10.0 - 4.0 = 6.0
                {3, 6.0, 2.0, 12.0},  // Умножение: 6.0 * 2.0 = 12.0
                {4, 8.0, 2.0, 4.0},  // Деление: 8.0 / 2.0 = 4.0
        };
    }

//////////////////////////////////////////

    @Test(dataProvider = "matrix5Provider")
    public void matrix5Test(int M, int N, int D, int[] numbers, int[][] expectedMatrix) {
        int[][] resultMatrix = new Variant5().matrix5Task(M, N, D, numbers);
        assertEquals(resultMatrix, expectedMatrix);
    }

    @DataProvider
    public Object[][] matrix5Provider() {
        int[] numbers1 = {1, 2, 3};
        int[][] expectedMatrix1 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};

        int[] numbers2 = {0, 0, 0};
        int[][] expectedMatrix2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        return new Object[][] {
                {3, 3, 3, numbers1, expectedMatrix1},
                {3, 3, 0, numbers2, expectedMatrix2},
        };
    }


    @Test(dataProvider = "minmax5Provider")
    public void minmax5Test(int N, double[][] pairs, double[] expectedResult) {
        double[] result = new Variant5().minmax5Task(N, pairs);
        assertEquals(result, expectedResult);
    }

    @DataProvider
    public Object[][] minmax5Provider() {
        double[][] pairs1 = {{1.0, 2.0}, {2.0, 3.0}, {3.0, 4.0}};
        double[] expectedResult1 = {2, 0.75}; // Деталь 2 має найбільшу плотність

        double[][] pairs2 = {{5.0, 1.0}, {4.0, 2.0}, {3.0, 3.0}};
        double[] expectedResult2 = {0, 5.0}; // Деталь 0 має найбільшу плотність

        return new Object[][] {
                {3, pairs1, expectedResult1},
                {3, pairs2, expectedResult2}
        };
    }


}
