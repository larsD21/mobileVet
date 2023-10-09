package de.vet.utils;

import de.vet.entity.Drug;

import java.util.List;

//author Lars Diekmann
public class InsertionSortDrug {
    protected static List<Drug> insertionSort(List<Drug> drugs){
        for(int i = 1; i<drugs.size(); i++){
            Drug key = drugs.get(i);
            int j = i - 1;

            while(j>=0 && drugs.get(j).getDrugID() > key.getDrugID()){
                drugs.set(j+1, drugs.get(j));
                j--;
            }
            drugs.set(j+1, key);
        }
        return drugs;
    }
}
