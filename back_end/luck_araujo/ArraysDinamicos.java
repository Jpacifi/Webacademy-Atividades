package back_end.luck_araujo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraysDinamicos 
{
    public static void main(String[] args) 
    {
        //Crie um array dinâmico de inteiros com o nome numeros, e valores 5, 2, 9, 7 e 1.
        List<Integer> numeros = new ArrayList<Integer>();
        Collections.addAll(numeros, 5, 2, 9, 7,1);

        //Imprima os elementos do array numeros utilizando um loop forou for-each.
        for(int luck: numeros)
        {
            System.out.println(luck);
        }

        /*Utilize o método sort() da classe java.util.Collections para ordenar o array numeros em ordem crescente e imprima 
        os elementos do array numeros.*/
        Collections.sort(numeros);
        System.out.println(numeros);

        /*Utilize o método binarySearch() da classe java.util.Collections para buscar o número 9 no array numeros e 
        imprima na tela o resultado da busca.*/
        int araujo = Collections.binarySearch(numeros, 9);
        System.out.println(araujo);
        
        //Crie um novo array dinâmico de inteiros chamado maiores.
        List<Integer> maiores = new ArrayList<Integer>();

        /*Utilize o método subList() para copiar os três maiores números do array numeros para o array maiores, e 
        imprima os elementos do array maiores.*/
        Collections.sort(numeros, Collections.reverseOrder()); //deixei a lista numeros em decrescente 
        maiores.addAll(numeros.subList(0, 3));
        System.out.println(maiores);
        
        //Utilize o método equals() para comparar os arrays numeros e maiores e imprima na tela o resultado da comparação.
        System.out.println(maiores.equals(numeros));

        //Imprima na tela os elementos do array numeros em ordem decrescente. 
        System.out.println(numeros);
        
    }
}