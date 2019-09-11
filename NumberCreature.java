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

import java.util.Random;
import java.util.function.Supplier;



/**
 * Example for the evolution package.
 * This example creature has a single "gene" named x.
 * This gene determines the creature's fitness in it's enviroment.
 * The enviroment can be a complex simulation are as in this case a simple
 * function. In this case is f(x)=-x^2. So the genes of the creatures should
 * approach 0.
 * 
 * @author Sebastian Gössl
 * @version 1.0 19.1.2019
 */
public class NumberCreature implements Creature {
    
    /**
     * Gene of this creature.
     */
    private final double x;
    /**
     * The fitness of this creature is calculated at is construction because
     * the environment that determines it is not changing and therefore
     * a constant function.
     */
    private final double fitness;
    
    
    
    /**
     * Constructs a new NumberCreature with the given gene.
     * 
     * @param x only gene of this creature
     */
    public NumberCreature(double x) {
        this.x = x;
        
        fitness = calculateFitness();
    }
    
    
    
    /**
     * Calculates this creature's fitness.
     * 
     * @return fitness of this creature
     */
    private double calculateFitness() {
        return -x * x;
    }
    
    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public double getFitness() {
        return fitness;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Creature evolve(double factor) {
        final double change = factor * new Random().nextGaussian();
        
        return new NumberCreature(x + change);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "NumberCreature{x = " + x + ", fitness = " + fitness + "}";
    }
    
    
    
    
    public static void main(String[] args) {
        final Random rand = new Random();
        final Supplier<Creature> supplier =
                () -> (new NumberCreature(rand.nextGaussian()));
        final Evolution evo = new Evolution(10, supplier);
        
        
        while(evo.getGeneration() < 20) {
            System.out.println("Generation: " + evo.getGeneration()
                    + ", Fittest: " + evo.getFittest());
            
            final double factor = Math.exp(-evo.getGeneration());
            evo.evolve(factor);
        }
    }
}
