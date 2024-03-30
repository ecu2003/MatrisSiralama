package com.example;
import java.util.Random;

public class MatrisSiralama {
    public static void main(String[] args) {
        int[][] matris = generateRandomMatrix(5, 5); // Örnek olarak 5x5 boyutunda bir matris oluşturur.
        
        System.out.println("Orijinal Matris:");
        printMatrix(matris);
        
        sortMatrix(matris);
        
        System.out.println("\nSıralanmış Matris:");
        printMatrix(matris);
    }
    
    // Random değerlerle doldurulmuş bir matris oluşturur.
    public static int[][] generateRandomMatrix(int rows, int cols) {
        int[][] matris = new int[rows][cols];
        Random rand = new Random();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matris[i][j] = rand.nextInt(100); // 0 ile 99 arasında random değerlerle doldurma.
            }
        }
        
        return matris;
    }
    
    // Matrisi küçükten büyüğe doğru sıralama.
    public static void sortMatrix(int[][] matris) {
        int rows = matris.length;
        int cols = matris[0].length;
        
        int[] tempArray = new int[rows * cols]; // Tüm elemanlar için tek boyutlu bir geçici dizi oluşturma.
        
        // Matris elemanlarını tek boyutlu diziye kopyalama.
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tempArray[k++] = matris[i][j];
            }
        }
        
        // Tek boyutlu diziyi sıralama.
        for (int i = 0; i < tempArray.length - 1; i++) {
            for (int j = 0; j < tempArray.length - i - 1; j++) {
                if (tempArray[j] > tempArray[j + 1]) {
                    int temp = tempArray[j];
                    tempArray[j] = tempArray[j + 1];
                    tempArray[j + 1] = temp;
                }
            }
        }
        
        // Sıralanmış değerleri matrise geri yerleştirme.
        k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matris[i][j] = tempArray[k++];
            }
        }
    }
    
    // Matrisi ekrana yazdırma.
    public static void printMatrix(int[][] matris) {
        for (int[] row : matris) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
