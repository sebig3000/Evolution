# Evolution

Package used for evolutionary optimization.

## Usage

The object that should be optimized has to implement the Creature interface.
The interface includes teo methods, getFitness & evolve.
getFitness returns the fitness of the creature, that is a measurement of how
well a creature performes with it's specific genes.
evolve takes a mutation factor as argument and returns a newborn offspring.
The offspring gene's difference to the parent gene's is proportional to the
mutation factor.

For the optimization a Evolution is needed. It's construction needs an initial
generation of creatures. This pool of creatures should have random genes that
are still in proximity of the expected values.
Then, by calling evolve the weaker half of creature gets replaced by the
fitter half's offsprings by calling their evolve method with the given
mutation factor.
This step is repeated many times with a decreasing mutation factor until the
fittest creature's is within the wanted fitness.

The class NumberCreature is an example creature with a main method that shows
the usage of this package.

## Getting Started

Simply download this repository and add it to your project as a new package!
Done!

## TODO

 - [ ] Automatic mutation factor
 - [ ] Gene combining reproduction
 - [x] Documentation

## License (MIT)

MIT License

Copyright (c) 2019 Sebastian Gössl

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
