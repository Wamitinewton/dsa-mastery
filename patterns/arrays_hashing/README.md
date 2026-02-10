# Arrays & Hashing Pattern

This directory contains solutions to problems that primarily use arrays and hash maps/hash tables.

## Problems Included

### 1. HashingRehashing.java
- Custom HashMap implementation with rehashing
- Demonstrates load factor calculation and dynamic resizing
- Separate chaining for collision resolution

### 2. ValidAnagramsHashMap.java
- Determines if two strings are anagrams using HashMap
- Time Complexity: O(n)
- Space Complexity: O(n)

### 3. ValidAnagramsSorting.java
- Determines if two strings are anagrams using Arrays.sort()
- Time Complexity: O(n log n)
- Space Complexity: O(n)

### 4. ValidAnagramsBubbleSorting.java
- Determines if two strings are anagrams using Bubble Sort
- Time Complexity: O(n²)
- Space Complexity: O(n)

## Key Concepts

- Hash functions and collision resolution
- Load factor and rehashing
- Frequency counting with HashMaps
- String to character array conversion
- Anagram detection techniques

## Common Patterns

1. **Frequency Counting**: Use HashMap to count occurrences
2. **Two-Pass Solutions**: First pass to build data structure, second to check conditions
3. **Hash-based Lookups**: O(1) average lookup time

