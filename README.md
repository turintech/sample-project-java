# sample-project-java
This is a sample project for showcasing how optimization can be performed in a Java project using Artemis 

## Usage

Build:

```shell
./gradlew build -x test
```

Run Main:

```shell
./gradlew run
```

Run Unit Tests:

```shell
./gradlew test
```

Run Benchmarking (CSV output by default):

```shell
./gradlew run
```

Run Benchmarking with JSON output:

```shell
./gradlew run --args="json"
```

Results are written to `artemis_results.csv` or `artemis_results.json` depending on the format. Each row/object represents one full benchmark execution with all operations as columns (e.g. `sumRange_throughput`, `sumRange_latency_p50`, `sumRange_latency_p99`, etc.).
