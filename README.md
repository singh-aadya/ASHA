# AIsha – ASHA/Anganwadi Worker Assistant
*Empowering frontline healthcare with intelligent support*

---

## 📌 Overview

**Asha** is a Java-based intelligent assistant designed to support **ASHA** and **Anganwadi** workers in rural India. It streamlines key healthcare tasks such as:

- 📅 Vaccination scheduling & tracking  
- 📈 Child growth and nutrition monitoring  
- 🗃️ Beneficiary health record management  
- 🗺️ Route optimization for field visits  

Built with simplicity and scalability in mind, AIsha bridges the tech gap in grassroots healthcare systems.

---

## 🚀 Features

### ✅ Core Modules

| Module               | Functionality                                  |
|----------------------|------------------------------------------------|
| **Vaccine Scheduler** | Smart reminders and overdue alerts             |
| **Growth Monitor**    | WHO-compliant percentile calculations          |
| **Health Records**    | Longitudinal health data tracking              |
| **Route Planner**     | Optimized pathfinding for field efficiency     |

---

## 🧠 Technical Implementation

### 📦 Package Structure

```

src/
├── main/
│   ├── java/
│   │   ├── core/
│   │   │   ├── scheduler/     # Vaccine scheduling logic
│   │   │   ├── growth/        # WHO percentile engine
│   │   │   └── routing/       # Route optimization
│   │   ├── models/            # Data models (Beneficiary, HealthRecord)
│   │   └── Main.java          # Entry point
│   └── resources/             # CSVs, configs, data files

````

---

### 🧩 Key Algorithms

#### 🧪 1. Vaccination Scheduling
- **Min-Heap** based priority queue
- Checks overdue doses and notifies

#### 📊 2. Growth Monitoring
```java
public static GrowthAssessment assess(double weight, int ageMonths, boolean isMale) {
    double[] percentiles = getPercentiles(ageMonths, isMale);
    // Compare weight with standard thresholds
}
````

#### 🧭 3. Route Planning

* **Dijkstra’s Algorithm** for shortest path
* **Nearest-neighbor** heuristic for multi-village visits

---

## 💻 Getting Started

### 🔧 Prerequisites

* Java 8 or above
* VS Code or IntelliJ

### 📥 Installation

```bash
git clone https://github.com/yourusername/aisha.git
cd aisha/src/main/java
```

### ▶️ Running the App

```bash
# Compile
javac Main.java -d ../../../out

# Run
java -cp ../../../out Main
```

---

## 📋 Sample Output

```
Registered beneficiary: Priya Sharma (ID: B001)
Next vaccine due: BCG (Dose 0) for B001 due 2023-12-15
Nutrition status: NORMAL
Optimal route: [VillageA → VillageB → VillageC]
```

---

## 🗃️ Data Models

### ✅ Beneficiary Record

| Field     | Type   | Description         |
| --------- | ------ | ------------------- |
| `id`      | String | Unique ID           |
| `name`    | String | Full name           |
| `age`     | int    | Age in years/months |
| `village` | String | Home location       |

### ✅ Health Metrics

```java
public class HealthRecord {
    private double weightKg;
    private double heightCm;
    private LocalDate date;
}
```

---

## 🌐 Real-World Integration Possibilities

* 📱 **Mobile Interface** – Flutter or React Native app
* ☁️ **Cloud Sync** – Firebase or AWS DynamoDB
* 🆔 **Govt Integration** – Aadhaar/UHID-based identity linking

---

## 📜 License

MIT License – see [LICENSE.md](LICENSE.md) for full details.

