# HoneyPot (formerly Ekspensify) — Working TODO

This TODO file documents the current progress, remaining tasks, and next actionable steps so work can be resumed later.

## Current branch

- Branch: New-AI-Finance

## High-level goal

- Localize the app (English + Thai) and implement runtime language switching.
- Rebrand visible strings to "HoneyPot" and update launcher/icon assets.
- Add AI recommendations later (planned but out of scope for this immediate task).

## What was completed in this session

- Implemented runtime locale apply (MainActivity recreation when language changes).
- Implemented `LanguageScreen` and ViewModel wiring for selection (StateFlow backed by SpUtils).
- Rebrand: `app_name` -> "HoneyPot"; updated onboarding title; adaptive launcher icon replaced with bear assets.
- Batch 1 localization: Converted important Profile/About/Onboarding strings to resources and added Thai placeholders.
- Batch 2 (in-progress): Converted several commonly used components to use string resources:
  - `AlertDialog` — default text -> resource
  - `TextFieldRupeePrefix` — currency symbol -> resource
  - `FilterScreen` — Cancel/Apply/Reset -> resources
  - `SmsPermissionDialog` — strings -> resources
- Made small build script hardening changes (app/build.gradle.kts) and added a placeholder `google-services.json` for local builds.
- Local `./gradlew :app:assembleDebug -x lint` completed successfully after fixes.

## Remaining tasks (todo list)

1. Continue resource conversion (batch 2) [in-progress]

   - Remaining files to convert in this batch:
     - `ui/dashboard/budget/components/BudgetReportItem.kt` — dynamic text like "See %d Transactions" -> formatted resource
     - `ui/export/ExportSuccessDialog.kt` — convert inline strings/bullets to resources

   - After each small batch, run `./gradlew :app:assembleDebug -x lint` to catch issues early.

2. Rebrand sweep [not-started]

   - Find and replace visible "Ekspensify" occurrences with "HoneyPot" across strings and docs.
   - Consider whether to change applicationId/package name (impactful; plan separately).

3. Toolchain upgrade plan [not-started]

   - Analyze compatibility for Gradle/AGP/Kotlin/Compose/Hilt/Room and prepare a step-by-step upgrade plan to Gradle 9.10 and suitable JDK.

4. AI features (future)

   - Design where AI recommendations will appear (Dashboard, Add Transaction flow, Budget suggestions).
   - Decide offline vs on-device vs cloud model approach and privacy constraints.

## Build / environment notes

- Recommended JDK for local builds: 17 (system JDK 25 caused earlier tooling errors in the session).
- AGP: 8.5.2 (project warns about compileSdk=35). Consider updating AGP for compatibility when upgrading compileSdk.
- `app/google-services.json` is currently a placeholder for local builds; replace with real config for Firebase features.

## How to resume

1. Pick the next task from "Remaining tasks" above.

2. Create a short-lived feature branch from `New-AI-Finance` if needed.

3. Make small, focused commits (1 file or 2 files per change) and run `./gradlew :app:assembleDebug -x lint` after each batch.

4. Update this TODO.md and the in-memory todo list (if using the helper) as items progress.

## Contact / context

- Current working branch: `New-AI-Finance`

- If you need me to continue, tell me which item to pick next (e.g. "Finish BudgetReportItem" or "Start Rebrand sweep").

---
Generated: 2025-09-25
