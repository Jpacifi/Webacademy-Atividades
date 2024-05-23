package back_end.joao_carlos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraysDinamicos 
{
    public static void main(String[] args) 
    {
        
        //Crie um array dinâmico de inteiros com o nome numeros, e valores 5, 2, 9, 7 e 1.
        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(5);
        numeros.add(2);
        numeros.add(9);
        numeros.add(7);
        numeros.add(1);
        System.out.println("Elementos do Array");
        //mprima os elementos do array numeros utilizando um loop forou for-each.
        for(int item : numeros){
            System.out.println(item);
        }
        //utilize o método sort() da classe java.util.Collections para ordenar o array numeros em ordem crescente e imprima os elementos do array numeros.
        System.out.println("Elementos em ordem Crescente:");
        Collections.sort(numeros);
        for(int item : numeros){
            System.out.println(item);
        }
        //Utilize o método binarySearch() da classe java.util.Collections para buscar o número 9 no array numeros e imprima na tela o resultado da busca.
        int index = Collections.binarySearch(numeros, 9);
        System.out.printf("Elemento encontrado na posição: "+index);
        //Crie um novo array dinâmico de inteiros chamado maiores
        List<Integer> maiores = new ArrayList<Integer>(numeros.subList(numeros.size() - 3, numeros.size()));
        System.out.printf("Elementos da Tabela Maiores:\n");
        for (int item : maiores) {
            System.out.println(item);
        }
        //Utilize o método equals() para comparar os arrays numeros e maiores e imprima na tela o resultado da comparação.
        boolean result = numeros.equals(maiores);
        if (result == true) {
            System.out.println("Eles são Iguais");
        }else{
            System.out.println("Eles são diferentes");
        }
        //Imprima na tela os elementos do array numeros em ordem decrescente.
        Collections.sort(numeros, Collections.reverseOrder());
        System.out.println("Elementos em ordem Decrecente:");
        for(int item : numeros){
            System.out.println(item);
        }
    }

}