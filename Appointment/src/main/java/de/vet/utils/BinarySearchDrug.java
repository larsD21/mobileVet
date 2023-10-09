package de.vet.utils;

import de.vet.entity.Drug;

import java.util.List;

//author Lars Diekmann
public class BinarySearchDrug {
    public static boolean isInList(long key, List<Drug> drugs){
        if(binarySearch(key, drugs) == -1){
            return false;
        }else {
            return true;
        }
    }

    //Nach Pseudocode von Prof. Gerald Timmer Vorlesung Alogirthmen und Datenstrukturen HSOS I&I
    private static int binarySearch(long key, List<Drug> drugs){
        int left = 0;
        int right = drugs.size()-1;
        drugs = InsertionSortDrug.insertionSort(drugs);

        while(left <=  right){
            int middle = (left+right)/2;
            if(key < drugs.get(middle).getDrugID()){
                right = middle-1;
            } else if( key > drugs.get(middle).getDrugID()){
                left = middle+1;
            }else {
                return middle;
            }
        }
        return -1;

    }
}
