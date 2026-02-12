package fr.simplon.exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Exercice 10: Opérations sur les ensembles
 * 
 * Objectif: Apprendre les opérations mathématiques sur les ensembles (union, intersection, différence)
 */
public class Exercise10SetOperations {
    
    /**
     * Vérifie si une valeur est présente dans un tableau (sur une portion)
     * @param array le tableau à parcourir
     * @param value la valeur recherchée
     * @return true si la valeur est trouvée dans les length premiers éléments
     */
    public boolean contains(int[] array, int value) {
        boolean c = false;
    
        for(int i : array){
            if(i == value){
                c = true;
                break;
            }
        }
        return c;
        

    }

    /**
     * Union de deux tableaux (tous les éléments uniques des deux tableaux)
     * @param array1 le premier tableau
     * @param array2 le second tableau
     * @return un tableau contenant tous les éléments uniques des deux tableaux
     */
    public int[] union(int[] array1, int[] array2) {
        Set<Integer> len = new HashSet<>() ;   
        
        for(int i : array1){
            len.add(i);
           
        }
        for( int i : array2){
            len.add(i);
           
        }
        int [] union = new int[len.size()];
        int count = 0;
        for (int i :len){
           union[count++]=i;

}
return union;
        
    }
    /**
     * Intersection de deux tableaux (éléments présents dans les deux tableaux)
     * @param array1 le premier tableau
     * @param array2 le second tableau
     * @return un tableau contenant les éléments présents dans les deux tableaux
     */
    public int[] intersection(int[] array1, int[] array2) {
        int [] tabP = new int [array1.length];
        int count = 0;
        for (int i : array1){
            if (contains(array2, i)){
                tabP[count++] = i;
            }
        }
        return Arrays.copyOf(tabP, count);
        

    }
    
    /**
     * Différence de deux tableaux (éléments de array1 qui ne sont pas dans array2)
     * @param array1 le premier tableau
     * @param array2 le second tableau
     * @return un tableau contenant les éléments de array1 absents de array2
     */
    public int[] difference(int[] array1, int[] array2) {
        Set<Integer> elementSet = new HashSet<>();

        
        for (int i : array1) {
            elementSet.add(i);
        }

        
        for (int i : array2) {
            elementSet.remove(i);
        }

       
        int[] difference = new int[elementSet.size()];
        int count = 0;
        for (int i : elementSet) {
            difference[count++] = i;
        }

        return difference;

    }
            
        

    /**
     * Différence symétrique (éléments présents dans un seul des deux tableaux)
     * @param array1 le premier tableau
     * @param array2 le second tableau
     * @return un tableau contenant les éléments présents dans un seul tableau
     */
    public int[] symmetricDifference(int[] array1, int[] array2) {
    int [] union = union(array1, array2);
    int [] intersection = intersection(array1, array2);

    return difference(union, intersection);

  }

    
    
    /**
     * Vérifie si array1 est un sous-ensemble de array2
     * @param array1 le premier tableau
     * @param array2 le second tableau
     * @return true si tous les éléments de array1 sont dans array2
     */
    public boolean isSubset(int[] array1, int[] array2) {
    
       
        for(int i : array1){
            if (!contains(array2, i)){

                return false;
            }
                 
        }
        
             return true;
            
        }
     


    /**
     * Supprime les doublons d'un tableau
     * @param array le tableau
     * @return un tableau contenant uniquement les éléments uniques
     */
    public int[] removeDuplicates(int[] array) {
        
        Set<Integer> seen = new HashSet<>();
        int[] tmp = new int[array.length];
        int count = 0;
        for (int v : array) {
            if (seen.add(v)) {
        tmp[count++] = v;
        }
        }
        return Arrays.copyOf(tmp, count);
        }


    
    /**
     * Compte le nombre d'éléments uniques dans un tableau
     * @param array le tableau
     * @return le nombre d'éléments uniques
     */
    public int countUnique(int[] array) {
        int [] uniqueElements = new int [array.length];
        int count = 0;
        for (int i : array){
            if (contains(uniqueElements, i)){
                continue;
            }
            uniqueElements[count++] = i;
        }
        return count;
        
    }



    }

