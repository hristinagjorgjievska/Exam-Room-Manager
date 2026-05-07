# 📚 Апликација за управување со просторни ресурси за испити
### Exam Room Manager

> Project for the course **Web Programming** at the Faculty of Computer Science and Engineering (FINKI), Ss. Cyril and Methodius University, Skopje.

---

## 📌 Project Description

A web application for professors and assistant professors to schedule and reserve classrooms for exams at the faculty. Professors / Assistant professors can log in, view their assigned subjects, pick an exam date using an interactive calendar, browse available classrooms, and reserve one or more rooms for a specific exam slot — with automatic conflict detection to prevent double-booking.

---

## 🎯 Core Features

- 🔐 **Professor Authentication** — Secure login with Spring Security
- 📋 **Subject Dashboard** — Each professor sees only their own subjects
- 📅 **Interactive Calendar** — Pick an exam date from an always-open inline calendar
- 🏫 **Classroom Browser** — View available classrooms as cards with capacity and computer availability info
- 🔍 **Filtering** — Filter classrooms by computer availability (`WITH_COMPUTERS` / `WITHOUT_COMPUTERS`)
- 📝 **Exam Type Selection** — Choose between `MIDTERM` and `FINAL_EXAM`
- ✅ **Reservation System** — Select one or more classrooms and reserve them for an exam
- ⚠️ **Conflict Detection** — Automatically detects and blocks overlapping reservations for the same classroom

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java 21 |
| Framework | Spring Boot 4.x |
| ORM | Spring Data JPA / Hibernate |
| Security | Spring Security |
| Templating | Thymeleaf |
| Database | PostgreSQL 17 |
| Migrations | Flyway |
| Build Tool | Maven |
| Utilities | Lombok |

---

## 🏗️ Architecture

The project follows a standard **layered architecture**:

```
mk.ukim.finki.wp.exam_room_manager
├── config/
│   └── SecurityConfig.java
├── model/
│   ├── Professor.java
│   ├── Subject.java
│   ├── Classroom.java
│   ├── Exam.java
│   ├── Reservation.java
│   └── enums/
│       ├── ComputerAvailability.java
│       ├── ExamType.java
│       └── ProfessorRole.java
├── repository/
│   ├── ProfessorRepository.java
│   ├── SubjectRepository.java
│   ├── ClassroomRepository.java
│   ├── ExamRepository.java
│   └── ReservationRepository.java
├── service/
│   ├── ProfessorService.java
│   ├── SubjectService.java
│   ├── ClassroomService.java
│   ├── ExamService.java
│   ├── ReservationService.java
│   └── impl/
│       ├── ProfessorServiceImpl.java
│       ├── SubjectServiceImpl.java
│       ├── ClassroomServiceImpl.java
│       ├── ExamServiceImpl.java
│       └── ReservationServiceImpl.java
└── web/
    ├── AuthController.java
    ├── DashboardController.java
    └── ExamController.java
```

---

## 🗄️ Database Schema

```
professors
├── id, username, password, full_name, email, professor_role

subjects
├── id, name, code, professor_id (FK → professors)

classrooms
├── id, name, capacity, computer_availability

exams
├── id, exam_date, start_time, duration, number_of_students, exam_type, subject_id (FK → subjects)

reservations
├── id, exam_id (FK → exams), classroom_id (FK → classrooms)
```

---

## 🚀 Getting Started

### Prerequisites

- Java 21+
- PostgreSQL 17+
- Maven

### Setup

**1. Clone the repository**
```bash
git clone https://github.com/your-username/exam-room-manager.git
cd exam-room-manager
```

**2. Create the database**
```sql
CREATE DATABASE exam_room_manager;
```

**3. Configure `application.properties`**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/exam_room_manager
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.thymeleaf.cache=false
```

**4. Run the application**
```bash
mvn spring-boot:run
```

**5. Open in browser**
```
http://localhost:8080/login
```

---

## 👤 Test Credentials

| Username | Password | Role |
|----------|----------|------|
| `sasho_gramatikov` | `sasho_gramatikov_123` | Professor |
| `ana_todorovska` | `ana_todorovska_123` | Assistant Professor |
| `darko_sasanski` | `darko_sasanski_123` | Assistant Professor |

---

## 📸 Application Flow

```
Login → Dashboard (subjects) → Calendar (pick date) → Classrooms (filter & select) → Exam Details (time, duration, students, exam type) → Reserve → Redirect to Dashboard
```

---

## 📄 Flyway Migrations

| Version | Description |
|---------|-------------|
| V1 | Create all tables |
| V2 | Insert seed data (professors, subjects, classrooms) |

---

## 👨‍💻 Authors

**Ognen Mladenovski - 233108**  
Faculty of Computer Science and Engineering (FINKI)  
Ss. Cyril and Methodius University, Skopje  
Course: Web Programming

**Hristina Gjorgjievska - 233215**  
Faculty of Computer Science and Engineering (FINKI)  
Ss. Cyril and Methodius University, Skopje  
Course: Web Programming

**Evica Isaevska - 233245**  
Faculty of Computer Science and Engineering (FINKI)  
Ss. Cyril and Methodius University, Skopje  
Course: Web Programming
