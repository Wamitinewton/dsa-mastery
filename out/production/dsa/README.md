# DSA Project Structure

This repository contains implementations of various Data Structures and Algorithms organized by patterns and concepts.

## Project Structure

```
dsa/
├── patterns/           # Algorithm patterns and problem-solving techniques
│   ├── arrays_hashing/    # Array and HashMap based problems
│   ├── two_pointers/      # Two pointer technique problems
│   ├── sliding_window/    # Sliding window problems
│   ├── linkedlist/        # Linked list problems
│   ├── stack/             # Stack-based problems
│   ├── binary_search/     # Binary search problems
│   ├── trees/             # Tree problems
│   ├── graphs/            # Graph problems
│   ├── heap/              # Heap/Priority Queue problems
│   ├── trie/              # Trie problems
│   ├── backtracking/      # Backtracking problems
│   ├── dp/                # Dynamic Programming problems
│   ├── greedy/            # Greedy algorithm problems
│   ├── intervals/         # Interval problems
│   ├── bit/               # Bit manipulation problems
│   └── math/              # Mathematical problems
├── structures/         # Data structure implementations
├── utils/             # Utility classes and helper functions
└── playground/        # Testing and experimentation area
```

## How to Use

### Patterns Directory
Contains problem solutions organized by algorithmic patterns. Each subdirectory focuses on a specific pattern or technique commonly used in competitive programming and technical interviews.

### Structures Directory
Contains implementations of fundamental data structures from scratch.

### Utils Directory
Contains reusable utility classes like sorting algorithms, string manipulation utilities, etc.

### Playground Directory
A space for testing, experimenting with code, and trying out new concepts.

## Running the Code

To run any Java file:
```bash
javac <package>/<FileName>.java
java <package>.<FileName>
```

For example:
```bash
javac patterns/arrays_hashing/HashingRehashing.java
java patterns.arrays_hashing.HashingRehashing
```

## Contributing

When adding new code:
1. Place it in the appropriate pattern directory
2. Use proper package naming
3. Include comments and documentation
4. Add examples in the main method

