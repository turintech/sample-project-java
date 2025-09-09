# Component Dependency and Data Flow Analysis

## Project Architecture Overview

This Java project follows a **hub-and-spoke architecture** with `App.java` serving as the central orchestrator that coordinates all components without any business logic of its own.

## Component Structure

### 1. **App (run/java/App.java)** - Central Orchestrator
- **Role**: Main entry point and demonstration orchestrator
- **Dependencies**: Imports all major components
- **Business Logic**: None - pure coordination
- **Methods**: 5 demonstration methods + main()

### 2. **Algorithms Package** - Computational Operations
- **Primes.java**: Prime number operations
- **Sort.java**: Sorting and selection algorithms

### 3. **Control Package** - Loop-based Computations  
- **Double.java**: Double-loop algorithms
- **Single.java**: Single-loop algorithms

### 4. **DataStructures Package** - Data Manipulation
- **DsVector.java**: Vector operations and transformations
- **DsLinkedList.java**: LinkedList utilities

### 5. **Generator Package** - Data Creation
- **GenVector.java**: Random vector generation

### 6. **Strings Package** - Text Processing
- **Strops.java**: String operations (unused in main flow)

## Dependency Matrix

| Component | External Dependencies | Internal Dependencies |
|-----------|----------------------|----------------------|
| App | All packages | algorithms.*, control.*, datastructures.DsVector, generator.GenVector |
| algorithms.Primes | java.util.Vector | None |
| algorithms.Sort | java.util.Collections, PriorityQueue, Vector | None |
| control.Double | None | None |
| control.Single | java.util.Vector | None |
| datastructures.DsVector | java.util.Vector | None |
| datastructures.DsLinkedList | java.util.ArrayList, Collections, LinkedList | None |
| generator.GenVector | java.util.ArrayList, Random, Vector | None |
| strings.Strops | None | None |

## Inter-Component Method Calls

All inter-component calls originate from `App.java`:

### App → Control Components
```
App.single() calls:
  - Single.sumRange(int)
  - Single.maxArray(int[])
  - Single.sumModulus(int, int)

App.double_() calls:
  - Double.sumSquare(int)
  - Double.sumTriangle(int)
  - Double.countPairs(int[])
  - Double.countDuplicates(int[], int[])
```

### App → Generator Component
```
App.vector() calls:
  - GenVector.generateVector(int, int) [2x]

App.sort() calls:
  - GenVector.generateVector(int, int) [1x]
```

### App → DataStructures Component
```
App.vector() calls:
  - DsVector.modifyVector(Vector<Integer>)
  - DsVector.searchVector(Vector<Integer>, int)
  - DsVector.sortVector(Vector<Integer>)
  - DsVector.reverseVector(Vector<Integer>)
  - DsVector.rotateVector(Vector<Integer>, int)
  - DsVector.mergeVectors(Vector<Integer>, Vector<Integer>)
```

### App → Algorithms Component
```
App.primes() calls:
  - Primes.IsPrime(int)
  - Primes.SumPrimes(int)
  - Primes.PrimeFactors(int)

App.sort() calls:
  - Sort.SortVector(Vector<Integer>)
  - Sort.DutchFlagPartition(Vector<Integer>, int)
  - Sort.MaxN(Vector<Integer>, int)
```

## Object Instantiation Patterns

### Primary Data Containers
- **Vector<Integer>**: Main data exchange format
  - Created by GenVector.generateVector()
  - Passed between generator → datastructures → algorithms
  - Used as return type for complex operations

### Instantiation Points
1. **GenVector.generateVector()**: Creates random Vector<Integer>
2. **App.vector()**: Creates copies via `new Vector<Integer>(inputVec)`
3. **App.sort()**: Creates copies via `new Vector<Integer>(initialVec)`
4. **DsVector methods**: Create new Vector<Integer> for transformations
5. **Algorithm methods**: Create Vector<Integer> for results

## Data Flow Analysis

### Primary Flow: Generator → DataStructures → Algorithms
```
GenVector.generateVector() 
    ↓ Vector<Integer>
DsVector.* operations
    ↓ Vector<Integer>
Sort.* algorithms
    ↓ Vector<Integer> results
```

### Secondary Flows
```
Generator → Algorithms (Direct):
GenVector.generateVector() → Sort.* methods

Control Components (Independent):
Primitive types (int, int[]) → Control.* → primitive results

Strings (Isolated):
String inputs → Strops.* → String outputs (unused in main)
```

## Component Boundaries and Responsibilities

### Clear Separation of Concerns

| Component | Primary Responsibility | Data Types | Coupling |
|-----------|------------------------|------------|-----------|
| **App** | Orchestration & Demo | Mixed | High (imports all) |
| **Generator** | Data Creation | Vector<Integer> | Low (JDK only) |
| **DataStructures** | Data Manipulation | Vector<Integer>, LinkedList<Integer> | Low (JDK only) |
| **Algorithms** | Complex Computations | Vector<Integer> | Low (JDK only) |
| **Control** | Basic Computations | Primitives (int, int[]) | Low (JDK only) |
| **Strings** | Text Processing | String | Low (JDK only) |

### Integration Architecture
- **Hub-and-Spoke**: All integration through App.java
- **No Cross-Component Dependencies**: Components don't directly call each other
- **Data-Driven Integration**: Vector<Integer> as common data format
- **Loose Coupling**: Each component can function independently

## Component Relationship Summary

### Active Integrations (used in main flow)
1. **App ↔ Control**: Direct method calls with primitive data
2. **App ↔ Generator**: Vector creation requests
3. **App ↔ DataStructures**: Vector manipulation operations  
4. **App ↔ Algorithms**: Complex computational operations

### Data Exchange Patterns
- **Generator → DataStructures**: Vector<Integer> instances
- **DataStructures → Algorithms**: Processed Vector<Integer> instances
- **Generator → Algorithms**: Direct Vector<Integer> exchange (bypassing DataStructures)

### Isolated Components
- **Strings**: No integration with main application flow
- **DsLinkedList**: Present but not used in App orchestration

This architecture enables clean separation of concerns while maintaining simplicity through centralized orchestration in App.java.
