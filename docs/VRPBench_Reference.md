# VRPBench: A Vehicle Routing Benchmark Tool

**Authors:** Guilherme A. Zeni, Mauro Menzori, P. S. Martins, Luis A. A. Meira
**Institution:** School of Technology, University of Campinas, Limeira – SP – Brazil
**Date:** October 19, 2016
**Source:** arXiv:1610.05402v1 [cs.AI]

---

## Abstract

The number of optimization techniques in the combinatorial domain is large and diversified. Nevertheless, there is still a lack of real benchmarks to validate optimization algorithms. In this work we introduce VRPBench, a tool to create instances and visualize solutions to the Vehicle Routing Problem (VRP) in a planar graph embedded in the Euclidean 2D space. We use VRPBench to model a real-world mail delivery case of the city of Artur Nogueira. Such scenarios were characterized as a multi-objective optimization of the VRP. We extracted a weighted graph from a digital map of the city to create a challenging benchmark for the VRP. Each instance models one generic day of mail delivery with hundreds to thousands of delivery points, thus allowing both the comparison and validation of optimization algorithms for routing problems.

**Keywords:** Benchmark, VRP, Graphs and Combinatorial Optimisation, Free Software Tool.

---

## 1. Introduction

Benchmarks are found in various fields of science, such as geology, economy, climatology, among other areas. Specifically in computer science, benchmarks play a central role, e.g. in image processing, hardware performance and optimization.

In the context of optimization, David S. Johnson divided algorithm analysis in three approaches: the worst-case, the average-case, and the experimental analysis. Relative to experimental papers, he identifies four situations:

1. To solve a real problem
2. To provide evidence that an algorithm is superior than the others
3. To better understand a problem
4. To study the average-case

He suggests the use of well-established benchmarks to provide evidence of the superiority of an algorithm (item ii). Such papers are called *horse race papers*.

Johnson highlights that **reproducibility** and **comparability** are essential aspects present in any experimental paper. He also advocates the use of instances that lead to general conclusions.

### 1.1 History of VRP

One of the first references to the VRP dates back to 1959 under the name *Truck Dispatching Problem*, a generalization of the Traveling Salesman Problem (TSP).

The term VRP was first seen in the paper by Christophides, in 1976. Christophides defines VRP as a generic name, given to a class of problems that involves the visit of "customers" using vehicles.

### 1.2 VRP Variants

Real world aspects may impose variants of the problem:

| Variant | Description |
|---------|-------------|
| **CVRP** (Capacitated-VRP) | Considers a limit to the vehicle capacity |
| **VRPTW** (VRP with Time Windows) | Accounts for delivery time windows |
| **MDVRP** (Multi-Depot VRP) | Extends the number of depots |

### 1.3 Existing Benchmarks

#### TSPLib (Reinelt, 1991)
- Created a benchmark for the TSP
- Repository (TSPLIB95) has instances for TSP/aTSP and related problems
- Number of instances: 113 (TSP), 19 (aTSP), 16 (CVRP), 41 (SOP), 9 (HCP)
- Number of vertices varies from 14 to 85,900 for the TSP
- The optimum of all TSPLib instances was finally achieved in 2007

#### Solomon Benchmark (1987)
- Created for VRPTW
- Composed of 56 instances partitioned in 6 sets
- Number of customers: 100 in all instances
- Vehicle has a fixed capacity and customers have demand/weight
- Number of vehicles is not fixed (derives from capacity limit)
- Problem is multi-objective: minimize route AND number of vehicles
- First optimum solution published in 1999
- In July 2015 (28 years after launch), Jawarneh and Abdullah published 11 new best results

#### ABEFMP Benchmark (CVRP)
- Augerat proposed classes A, B, P in 1995
- Classes E, F, M proposed in 1969, 1994, and 1979 respectively
- Number of customers: 13 to 200
- Number of vehicles: 2 to 17
- Last unsolved instance (M-n151-k12) solved in 2014, 35 years after presentation

#### Golden et al. (1998)
- 20 instances for CVRP
- Customers: 240 to 483
- Most instances have no optimum established yet

#### Li, Golden and Wasil (2005)
- Customers: 560 to 1200
- No optimum defined for any instance

#### CVRPLib (Uchoa et al., 2014)
- Consolidated CVRP instances from previous works
- Generated new instances with 100-1000 customers
- Points out the lack of well-established challenging benchmarks for VRP

### 1.4 Contribution

In this work, we propose the VRPBench tool for the mail delivery Problem. We propose instances for the VRP involving a real situation: the delivery of correspondence by the postmen in the Artur Nogueira road network.

- **Location:** Artur Nogueira, Brazil (22°34'22"S 47°10'22"W)
- **Daily volume:** Thousands of letters
- **Workforce:** 20-25 postmen (walking delivery)

The problem is modeled as VRP:
- Each **postman** = vehicle
- Each **delivery point** = customer
- Streets/avenues abstracted as **weighted undirected graph**
- Street corners and delivery points = **vertices**
- Streets = **edges**
- Edge weight = proportional to travel time

**Two objectives detected:**
1. Minimize average route length
2. Minimize injustice (unbalancing weight between postmen)

**Capacity constraints:**
- Postmen can carry 10kg (man) or 8kg (woman)
- Car support supplies load (unlimited capacity in practice)
- Route capacity: ~6h per day working limit

> According to our knowledge, this is one of the first benchmarks for the VRP with thousands of customers and that models a real-life situation in a road network.

---

## 2. Notation and Definition

### 2.1 Graph Definition

Consider a weighted (directed or undirected) graph **G(V, E)** where:
- **π ∈ V** is a special vertex called the *depot*
- **w': E → Q⁺** is a cost function

The set of customers is defined by:
```
C = V \ {π}
```

The number of customers is denoted by **n**, where `C = {c₁, ..., cₙ}`.

The number of vehicles in the fleet is represented by **k ∈ ℕ**.

### 2.2 Shortest Path Cost

Let **w(u, v, G)** be the shortest path cost between vertices u and v in the graph G.

We use `w(u, v)` to represent `w(u, v, G)` whenever G is known within context.

### 2.3 Solution Representation

We represent a solution as a sequence of vertices:

```
S(C, k) = (c₁, ..., cₙ, π, ..., π)
```

This sequence is created as follows:
1. All customers are inserted in S
2. The depot vertex is inserted k − 1 times

**Each permutation of S(C, k) represents a solution to the VRP.**

### 2.4 Example

Consider a graph with 13 customers and k = 3 vehicles:

```
S(C, 3) = (c₁, ..., c₁₃, π, π)
```

Example permutation (solution):
```
S' = (c₃, c₅, c₄, c₁, c₂, π, c₆, c₁₀, c₁₁, c₁₂, π, c₇, c₈, c₉, c₁₃)
```

This represents a partition of customers into 3 routes:
- **R₁** = (c₃, c₅, c₄, c₁, c₂)
- **R₂** = (c₆, c₁₀, c₁₁, c₁₂)
- **R₃** = (c₇, c₈, c₉, c₁₃)

All routes begin and end at the depot.

### 2.5 Partition Function

```
Partition(S) = (R₁, ..., Rₖ)
```

where the sequence is split at each k − 1 occurrence of π.

### 2.6 Route Length

The length of a route **R = (r₁, ..., rₘ)** is given by:

```
W(R) = w(π, r₁) + w(rₘ, π) + Σᵢ₌₁ᵐ⁻¹ w(rᵢ, rᵢ₊₁)
```

### 2.7 Solution Length

The length of a solution **S = (s₁, ..., sₘ)** is calculated as:

```
W(S) = w(π, s₁) + w(sₘ, π) + Σᵢ₌₁ᵐ⁻¹ w(sᵢ, sᵢ₊₁)
```

### 2.8 Objective Functions

**Traditional single objective** (minimize solution length):
```
f(S) = W(S)
```

**Multi-objective** (minimize length AND number of vehicles):
```
f₁(S) = W(S)
f₂(S) = k
```

**Fairness objective** (for mailman routes):
- Minimize variance of route lengths
- Routes should not unfairly penalize one worker over another

### 2.9 Problem Constraints

#### No Empty Routes
For each route Rᵢ ∈ Partition(S): `|Rᵢ| > 0`

#### Capacity Constraint (CVRP)
Each customer c ∈ C has a demand **d(c)**. Each vehicle v has capacity **c(v)**.

A route Rᵥ = (r₁ᵛ, ..., rₘᵛ) must satisfy:
```
Σᵢ₌₁ᵐ d(rᵢᵛ) ≤ c(v), ∀v ∈ {1, ..., k}
```

#### Route Length Constraint
For vehicles that need to refuel at depot (e.g., helicopter) or labor law constraints:

Let v be a vehicle with maximum route **Rmax(v)**. Any route Rᵥ must satisfy:
```
W(Rᵥ) ≤ Rmax(v), ∀v ∈ {1, ..., k}
```

#### Time Windows (VRPTW)
A visit to a vertex must be carried out within a pre-defined lower and upper time limit.

Examples:
- Scheduled deliveries (e.g., SEDEX 10 - delivery by 10 AM)
- Residential technical support with scheduled time frames

### 2.10 Handling Infeasible Solutions

A simple way to deal with unfeasible solutions is to assign an arbitrary high cost:
```
If solution is unfeasible: f(S) ← ∞
```

### 2.11 Formal Problem Definition

**Definition 1 (Single-objective VRP):**

Given:
- A weighted graph G(V, E)
- A constant k
- A special vertex π ∈ V
- An objective function f

Let C ← V \ {π}. Consider the sequence S(C, k) and let P be the set of all permutations of S(C, k).

**Find** the permutation S* ∈ P so that f(S*) is minimum.

---

## 3. Methodology

The instances were not generated from actual post-office application data. Nevertheless, the first author applied domain expertise (having worked for four years at a post office in Artur Nogueira) to make instances as realistic as possible.

### 3.1 Graph Construction

**Starting point:** Map of Artur Nogueira city

**Process:**
1. Line segments representing streets were drawn on top of the map
2. Each corner was automatically identified by calculating intersections
3. Result: weighted graph where edge weight = length of segment

**Note:** Postmen deliver by foot (not vehicle), so one-way street directions were not considered.

**Reasons for manual graph creation:**
1. Path by foot may differ from vehicle-prioritized maps
2. Number of streets (~400) allows manual creation
3. Public maps (e.g., OpenStreetMap) are incomplete

**Final Graph:**
- |V| = 2,111 vertices
- |E| = 3,225 edges
- Each edge associated with a pixel/line segment
- Each street has a name and set of collinear line segments
- Edge cost proportional to line segment length

### 3.2 Street Density of Probability

A non-uniform distribution is more realistic (main streets in downtown receive more deliveries per unit length than side streets).

A relative density **D** parameter was applied to each street.

#### Attributes and Penalties

**Region (Rg):**

| Region | central | peripheral | distant | isolated |
|--------|---------|------------|---------|----------|
| Penalty | 1.0 | 0.75 | 0.4 | 0.2 |

*An isolated street receives 80% less deliveries than a central street per unit length.*

**Type (T):**

| Type | Avenue | Street | Alameda | Highway |
|------|--------|--------|---------|---------|
| Penalty | 1.0 | 0.75 | 0.4 | 0.0 |

*Highways received 0 (no deliveries). A street has 25% less deliveries per unit length than an avenue.*

**Zone (Z):**

| Zone | Commercial & Industrial | Mixed | Residential |
|------|------------------------|-------|-------------|
| Penalty | 1.0 | 0.7 | 0.4 |

*Google Maps was used to verify streets containing companies.*

#### Density Calculation

Each of the 422 streets received a value in Rg × T × Z according to expert knowledge.

Let `f: Streets → Rg × T × Z` be a function that attributes values to a street.

The relative density function **D: Streets → ℕ**:

```
D(Street) = Penal(Rg(Street)) × Penal(T(Street)) × Penal(Z(Street))
```

**Example 1: XV de Novembro Avenue**
- Classification: (central, Avenue, Mixed)
```
D(StreetXV) = Penal(central) × Penal(Avenue) × Penal(Mixed)
            = 1 × 1 × 0.7 = 0.7
```

**Example 2: Sibipirunas Alameda**
- Classification: (isolated, Alameda, Residential)
```
D(StreetSib) = Penal(isolated) × Penal(Alameda) × Penal(Residential)
             = 0.2 × 0.4 × 0.4 = 0.032
```

The probability density of XV de Novembro is 0.7/0.032 ≈ 22× larger than Sibipirunas Alameda.

### 3.3 Generating Delivery Points

Define variable weight **w**:
```
w(Street) = D(Street) × Length(Street)
```

Expected number of deliveries:
```
E[ne(Street)] = w(Street) × k
```

Total weight:
```
W = Σᵢ₌₁ⁿ w(Streetᵢ)
```

#### Algorithm 1: Generating Delivery Points

```
Input: Sequence of weights (w₁, w₂, ..., wₙ) ∈ ℝⁿ associated to streets
       Total number of deliveries m ∈ ℕ

Output: Number of deliveries for each street (ne₁, ne₂, ..., neₙ) ∈ ℕⁿ

1. Set W = Σᵢ₌₁ⁿ w(Streetᵢ)
2. for i = 1 to m do
3.     R ← random value in [0, W]
4.     for x = 1 to n do
5.         if Σⱼ₌₁ˣ⁻¹ wⱼ < R ≤ Σⱼ₌₁ˣ wⱼ then
6.             neₓ ← neₓ + 1
7.         end
8.     end
9. end
10. return (ne₁, ne₂, ..., neₙ)
```

Within a street, delivery points are **uniformly distributed**.

---

## 4. Using VRPBench to Model Manhattan Streets

*(Section placeholder in original paper)*

---

## 5. Results

**Generated Instances:**
- 10 sets of instances
- 10 instances per set
- **Total: 100 instances**

**Delivery points per set:**

| Set | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|-----|---|---|---|---|---|---|---|---|---|---|
| Points | 1,000 | 2,000 | 3,000 | 4,000 | 5,000 | 6,000 | 7,000 | 8,000 | 9,000 | 10,000 |

---

## 6. Conclusions

In this work, we created a benchmark based on a real-life situation. Once the solution used by post office is fixed with respect to the delivery points, there is a large gap to be explored.

**Key findings:**
- A feasible solution that reduces the number of postmen produces profit (postmen can be allocated to other tasks)
- A solution that reduces route length reduces delivery effort (also profit)
- This is the **first benchmark to VRP with 10,000 delivery points**

### Future Perspectives

1. Publish a paper
2. Develop free software system to validate and rank best solutions
3. Provide visualization of routes
4. Lower bounds validation (released with publishing)
5. Development of algorithms to solve presented instances

---

## Key References

1. **Dantzig & Ramser (1959)** - "The truck dispatching problem" - First VRP reference
2. **Christophides (1976)** - Coined the term "VRP"
3. **Solomon (1987)** - VRPTW benchmark (56 instances, 100 customers)
4. **Reinelt (1991)** - TSPLib benchmark
5. **Augerat (1995)** - ABEFMP classes A, B, P for CVRP
6. **Golden et al. (1998)** - CVRP instances (240-483 customers)
7. **Li, Golden & Wasil (2005)** - Large-scale VRP (560-1200 customers)
8. **Uchoa et al. (2014)** - CVRPLib consolidation

---

## Summary Table: Problem Parameters

| Parameter | Symbol | Description |
|-----------|--------|-------------|
| Graph | G(V, E) | Weighted graph representing road network |
| Depot | π | Starting/ending point for all routes |
| Customers | C = V \ {π} | Delivery points |
| Number of customers | n | \|C\| |
| Number of vehicles | k | Fleet size |
| Solution | S(C, k) | Permutation of customers + (k-1) depot markers |
| Route length | W(R) | Sum of edge weights in route + depot connections |
| Solution length | W(S) | Total length of all routes |
| Demand | d(c) | Customer demand/weight |
| Vehicle capacity | c(v) | Maximum load per vehicle |
| Max route length | Rmax(v) | Maximum distance/time per route |

---

## Benchmark Instance Summary

| Attribute | Value |
|-----------|-------|
| City | Artur Nogueira, Brazil |
| Graph vertices | 2,111 |
| Graph edges | 3,225 |
| Number of streets | 422 |
| Instance sets | 10 |
| Instances per set | 10 |
| Total instances | 100 |
| Delivery points range | 1,000 - 10,000 |
| Objectives | Minimize W(S), minimize k, minimize variance |
