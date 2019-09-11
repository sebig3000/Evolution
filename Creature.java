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



/**
 * Creature interface for evolutionary optimization.
 * 
 * @author Sebastian Gössl
 * @version 1.0 19.1.2019
 */
public interface Creature extends Comparable<Creature> {
    
    /**
     * Returns the fitness of the creature.
     * 
     * @return fitness of the creature
     */
    public double getFitness();
    
    /**
     * Returns an offspring of this creature, with a given mutation factor.
     * 
     * @param factor mutation factor
     * @return offspring of this creature
     */
    public Creature evolve(double factor);
    
    
    
    /**
     * Compares this creature's fitness with the given creature's fitness
     * {@see Double.compareTo}.
     * 
     * @param o other creature this one should be compared to
     * @return comparison between this creature's fitness and the given
     * creature's fitness
     */
    @Override
    public default int compareTo(Creature o) {
        return Double.compare(getFitness(), o.getFitness());
    }
}
