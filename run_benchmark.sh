#!/bin/bash
# Script to run the performance benchmark for optimized Double class methods

echo "Building project..."
./gradlew build -x test

echo ""
echo "Running performance benchmark..."
./gradlew -q --console=plain run -PmainClass=benchmark.DoubleBenchmark
