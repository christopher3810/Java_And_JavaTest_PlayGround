package com.javafeature.demo.vectorAPIDemo;


import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class vectorDemo {

    public static void main(String[] args) {

        // Define a vector species for 4 float elements
        VectorSpecies<Float> species = FloatVector.SPECIES_64;

        // Define two float vectors with the same species
        float[] arr1 = {1.0f, 2.0f, 3.0f, 4.0f};
        float[] arr2 = {5.0f, 6.0f, 7.0f, 8.0f};

        FloatVector vec1 = FloatVector.fromArray(species, arr1, 0);
        FloatVector vec2 = FloatVector.fromArray(species, arr2, 0);

        // Add the two vectors and store the result in a new vector
        float[] vectorResult = vec1.add(vec2).toArray();
        for (float v : vectorResult) {
            log.info("float number + " + v);
        }
    }

}
