# Taskly Android To-Do List App

> Pemrograman Perangkat Bergerak (Mobile App Development) · ITS Surabaya · 2025

A native Android to-do list application built with Kotlin, featuring full task management with deadlines, categories, reminders, and completion tracking.

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=flat&logo=android&logoColor=white)
![XML](https://img.shields.io/badge/XML_Layout-E44D26?style=flat&logo=android&logoColor=white)

---

## Overview

Taskly is a native Android to-do list app designed to help users organize daily tasks efficiently. Built entirely with Kotlin and standard XML layouts, it provides a clean and intuitive interface for creating, managing, and tracking tasks including deadline scheduling, category grouping, and local reminders.

---

## Features

- ✅ **Add Task** : Create new tasks with title and details
- ✏️ **Edit Task** : Update existing task information anytime
- 🗑️ **Delete Task** : Remove tasks that are no longer needed
- 📅 **Deadline / Due Date** : Set due dates to stay on schedule
- 🏷️ **Categories / Labels** : Organize tasks by category
- 🔔 **Notifications / Reminders** : Get reminded before task deadlines
- ☑️ **Mark as Done** : Track completion status for each task

---

## Tech Stack

| Technology | Usage |
|---|---|
| Kotlin | Primary programming language |
| XML Layouts | UI design and screen structure |
| Android SDK | Core Android APIs |
| AlarmManager / NotificationManager | Task reminders and notifications |
| SharedPreferences / Internal Storage | Local data persistence |

---

## Project Structure

```
taskly/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/agnespriscilla/taskly/
│   │       │   ├── MainActivity.kt
│   │       │   ├── model/
│   │       │   │   └── Task.kt
│   │       │   ├── adapter/
│   │       │   │   └── TaskAdapter.kt
│   │       │   └── activity/
│   │       │       ├── AddTaskActivity.kt
│   │       │       └── EditTaskActivity.kt
│   │       └── res/
│   │           ├── layout/
│   │           └── drawable/
│   └── build.gradle
└── README.md
```

> *Note: Update structure above to match your actual project layout.*

---

## Getting Started

### Prerequisites
- Android Studio (latest stable version)
- Android SDK (API 21+)
- Kotlin plugin

### Installation

```bash
# 1. Clone the repository
git clone https://github.com/agnespriscilla/taskly.git

# 2. Open in Android Studio
# File → Open → select the taskly folder

# 3. Sync Gradle and run
# Click Run ▶ or Shift+F10
```

The app can be run on a physical Android device or an emulator (API 21+).

---

## Course Context

This project was developed as part of the *Pemrograman Perangkat Bergerak* (Mobile App Development) course at Institut Teknologi Sepuluh Nopember (ITS) Surabaya. It demonstrates fundamental Android development concepts including activity lifecycle, intents, UI design with XML, and system notifications.

---

## Author

**Agnes Priscilla Sekartaji Hadikusuma**  
S1 Teknik Informatika · Institut Teknologi Sepuluh Nopember (ITS) Surabaya

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](https://linkedin.com/in/agnespriscilla33)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white)](https://github.com/agnespriscilla)
[![Email](https://img.shields.io/badge/Email-D14836?style=flat&logo=gmail&logoColor=white)](mailto:agnes.priscilla33@gmail.com)
