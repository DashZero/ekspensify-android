# Ekspensify (Fork) — Android

This repository is a forked and adapted Android expense tracker app (Jetpack Compose + Kotlin) targeted for Thailand-friendly localization and future AI features.

Current branch: `New-AI-Finance`

Summary

- Modern Android app using Jetpack Compose, Hilt, Retrofit, Room and Firebase (Analytics / Crashlytics / Performance).
- Focus of this branch: localization-first proof-of-concept and groundwork for AI features (transaction parsing, suggestions, smart budgets).

What I've changed in this branch

- Migrated several UI literals to Android string resources (`res/values/strings.xml`) and added a Thai translation file (`res/values-th/strings.xml`).
- Refactored onboarding pages and profile option models to reference string resources.
- Added an in-app language preference (stored via `SpUtils` and exposed through `SpUtilsManager` as a StateFlow) and a `LanguageScreen` + ViewModel with a `LanguageScreenRoute` navigation entry.

What's working now

- Onboarding reads titles/descriptions from resources.
- A language selection screen exists (System / English / Thai) and persists choice to preferences.

Remaining work (high level)

- Complete a repo-wide sweep to replace remaining hardcoded strings with resource keys.
- Implement runtime locale application so the selected language takes effect immediately (activity recreation or Compose locale provider).
- Translate remaining strings into Thai and review UI for layout adjustments (Thai text length may affect layouts).
- Add an AI quick-add POC and safe server-side proxy for AI features.

How to run (developer)

1. Open the project in Android Studio (Arctic Fox or later recommended).
2. Build & run on an emulator or device with API level compatible with project (check `app/build.gradle.kts` compile/min SDK settings).

Contributing notes

- This fork is intended to explore AI-assisted finance features and to localize the app for Thai users. Please follow the branching model and create PRs to the `New-AI-Finance` branch for experiments.

License

- See the top-level `LICENSE` file.

# 🎉 Ekspensify - Your Personal Finance Buddy

![Android](https://img.shields.io/badge/Android-%233DDC84.svg?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-%2300C853.svg?style=for-the-badge&logo=jetpack-compose&logoColor=white)
![Firebase](https://img.shields.io/badge/firebase-%23039BE5.svg?style=for-the-badge&logo=firebase)

[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](LICENSE)
[![Google Play](https://img.shields.io/endpoint?color=green&logo=google-play&url=https%3A%2F%2Fplay.cuzi.workers.dev%2Fplay%3Fi%3Dcom.ekspensify.app%26l%3DGoogle%2520Play%26m%3Dv%24version)](https://play.google.com/store/apps/details?id=com.ekspensify.app)
[![Google Play](https://img.shields.io/endpoint?color=green&logo=google-play&url=https%3A%2F%2Fplay.cuzi.workers.dev%2Fplay%3Fi%3Dcom.ekspensify.app%26l%3Ddownloads%26m%3D%24totalinstalls)](https://play.google.com/store/apps/details?id=com.ekspensify.app)
[![GitHub Downloads (all assets, all releases)](https://img.shields.io/github/downloads/dilipsuthar264/ekspensify/total?logo=github)](https://github.com/dilipsuthar264/ekspensify/releases/latest)
[![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/dilipsuthar264/ekspensify?logo=github&label=GitHub&cacheSeconds=3600)](https://github.com/dilipsuthar264/ekspensify/releases/latest)
![GitHub repo size](https://img.shields.io/github/repo-size/dilipsuthar264/ekspensify.svg?logo=github)

## **🚀 Overview**

Welcome to **Ekspensify**, your personal finance tracking app made with **Kotlin** and **Jetpack Compose**! This project is all about making financial management simple, fun, and stress-free. Whether you’re budgeting like a pro or just starting, **Ekspensify** helps you stay on top of your money! 💰✨

### **✨ Why I Built This**

I wanted a **clean, intuitive, and fun way** to track income and expenses. No more boring spreadsheets - just a smooth experience with a **beautiful UI, insightful analytics, and helpful budgeting tools**. This app is my solution to making finance tracking **enjoyable and effortless**! 🚀

## **🌟 Features**

- 📌 **Track Income & Expenses**: Effortlessly record and keep track of your income and expenses in real time.
- 🏷 **Categories for Income & Expenses**: Includes all standard categories and allows custom categories.
- 📩 **Automatic Tracking via SMS**: Detects transactions from SMS alerts and tracks them in pending transactions for review.
- 💰 **Budget Management**: Create budgets to limit spending and stay on track.
- 🔔 **Budget Alerts**: Get notified when you're approaching or exceeding your budget.
- 🎨 **Modern UI**: Built with **Jetpack Compose** for a sleek and intuitive user experience.
- 📊 **Dashboard & Analytics**: Break down expenses and income by category with visual insights.
- 🏦 **Multiple Account Tracking**: Manage and track finances separately for different bank accounts.
- ☁ **Cloud Storage:** Your transaction records are securely stored on the server, keeping them safe and accessible.
- 📄 **PDF & CSV Export**: Easily export transaction data for reporting and record-keeping.

## **🎉 Download the App**

You can get the latest version of the app from the Google Play Store:

[<img src="https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png" alt="Get it on Google Play" height="80"/>](https://play.google.com/store/apps/details?id=com.ekspensify.app)

## **🛠 Tech Stack**

- **Kotlin** – Used as the primary programming language for the app.
- **Jetpack Compose** – Used for building modern, declarative UI components.
- **MVVM Architecture** - Keeping code clean and maintainable.
- **Dagger Hilt** – Dependency injection framework to manage app dependencies efficiently.
- **Retrofit** – Used for making network requests and parsing API responses.
- **Firebase** – For analytics, performance monitoring, and crash reporting.
- **Google Credential Manager** – Manages authentication and credentials securely, including integration with Google accounts for sign-in.
- **Room Database** – Local database management for offline data storage.
- **OneSignal** – Push notifications service to engage users.
- **Coil** – For image loading and displaying in Compose-based UI.
- **Paging3** – For efficient paginated data retrieval and display in the UI.

## **📸 Screenshots**

<img src="https://ekspensify-aws-bucket.s3.ap-south-1.amazonaws.com/Feature+graphic-1.png" alt="preview"/>
<br>  
<img src="https://ekspensify-aws-bucket.s3.ap-south-1.amazonaws.com/Feature+graphic.png" alt="preview"/>

## **🔧 Installation & Setup**

This is a complete Android app that interacts with a backend server. While you can't fully run the app locally without the server (since it relies on server APIs), you can still use it for testing and experimentation.

### Setup Instructions

- Clone the repository:

    ```bash
    git clone https://github.com/memeusix/Ekspensify.git
    ```

- Open the project in **Android Studio**.
- **Build and run** the app.

<aside>
➡️

**Note**: You can explore and experiment with the app locally, though server-dependent features like network calls and Google auth will require the backend.

</aside>

## Related Repositories

### 🔧 Backend

You can find the backend code here:  
➡️ [Backend Repository | ekspensify-backend](https://github.com/gokulsuthar22/ekspensify-backend)

### 🌐 Website

You can find the landing web page code here:  
➡️ [Website Repository | ekspensify-web](https://github.com/vipulsuthar1144/ekspensify-web)

## **🤝 Contributing**

Love this project? Want to make it even better? Feel free to **open issues, submit pull requests, or just drop feedback**! Let’s build something amazing together. 💡💻

## **📬 Let's Connect!**

Got feedback or ideas? Reach out to me! I’d love to hear from you. 🎉

- 📧 Email: <team@ekspensify.in>
- 💼 LinkedIn:  [Dilip Kumar | LinkedIn](https://www.linkedin.com/in/dilipkumar264/)
