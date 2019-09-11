/*
 * MIT License
 * 
 * Copyright (c) 2019 Sebastian Gössl
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */



package evolution;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Supplier;



/**
 * Evolutionary optimization algorithm.
 * 
 * @author Sebastian Gössl
 * @version 1.0 19.1.2019
 */
public class Evolution {
    
    /**
     * Current generation.
     */
    private int generation = 0;
    /**
     * All the creatures that are currently alive.
     */
    private final Creature[] creatures;
    
    
    
    /**
     * Constructs a new evolution.
     * The creature pool is created to the given size and filled with the
     * given supplier.
     * 
     * @param numberOfCreatures number of creatures per generation
     * @param supplier random creature supplier for the initial generation
     */
    public Evolution(int numberOfCreatures, Supplier<Creature> supplier) {
        creatures = new Creature[numberOfCreatures];
        Arrays.setAll(creatures, (i) -> supplier.get());
    }
    
    /**
     * Constructs a new evolution.
     * The given creatures will be the initial generation.
     * 
     * @param creatures creatures to be the initital generation
     */
    public Evolution(Creature[] creatures) {
        this.creatures = creatures;
    }
    
    
    
    /**
     * Returns the number or of the current generation.
     * 
     * @return number of the current generation
     */
    public int getGeneration() {
        return generation;
    }
    
    /**
     * Returns an array with the creatures of the current generation.
     * 
     * @return array with the creatures of the current generation
     */
    public Creature[] getCreatures() {
        return Arrays.copyOf(creatures, creatures.length);
    }
    
    /**
     * Returns the currently fittest creature.
     * 
     * @return currently fittest creature
     */
    public Creature getFittest() {
        return Collections.max(Arrays.asList(creatures));
    }
    
    
    
    /**
     * Sorts the creatures based on their fitness into ascending order.
     */
    public void sort() {
        Arrays.sort(creatures);
    }
    
    /**
     * Replaces the weaker half of the generation with offsprings of the
     * fitter half.
     * 
     * @param factor mutation factor for the evolution of the creatures
     */
    public void evolve(double factor) {
        sort();
        
        for(int i=0; i<creatures.length/2; i++) {
          creatures[i] = creatures[i + creatures.length/2].evolve(factor);
        }
        
        generation++;
    }
}
