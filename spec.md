# AI & Localization Spec — Ekspensify (New-AI-Finance)

This document outlines the proposed AI features, data contracts, privacy checklist, and an implementation roadmap for adding AI-powered capabilities and completing Thai localization.

1) Vision

- Provide lightweight, privacy-preserving AI features to help users add transactions faster (Quick-Add), categorize expenses automatically, and receive budget/insight recommendations localized to the user's language.

2) Candidate AI Features (priority)

- Quick-Add Parser (High)
  - User types natural text like "Lunch 150 THB Khao Gaeng" and the app extracts: amount, currency, merchant, category, date.
  - On-device heuristic fallback if network unavailable.
- Transaction Categorization (High)
  - Suggest category labels for uncategorized transactions (confidence score + user override).
- Smart Budgets & Insights (Medium)
  - Suggest budgets based on historical monthly spending and upcoming recurring payments.
- Receipt OCR & Auto-fill (Low)
  - Optional: capture receipt image, OCR text and populate Quick-Add fields. Consider on-device OCR, or server-proxied cloud OCR with explicit opt-in.

1) Architecture recommendations

- Use a server-side AI proxy to hold API keys (recommended) and to enforce rate limits and privacy controls.
- Minimal payloads: send only tokenized/text data and non-identifying metadata when possible. Avoid uploading raw receipts/images unless explicitly opted-in.
- Provide a client-side fallback (simple regex/heuristic) to enable Quick-Add offline.

1) Data contracts (examples)

- QuickAddRequest

```text
{
  "text": "Lunch 150 THB Khao Gaeng",
  "locale": "th",
  "userId": "<hashed>",
  "clientTimestamp": "2025-09-25T12:00:00Z"
}
```

- QuickAddResponse

```text
{
  "amount": 150.0,
  "currency": "THB",
  "merchant": "Khao Gaeng",
  "category": "Food",
  "date": "2025-09-25",
  "confidence": 0.92
}
```

1) Privacy & security checklist (must-haves)

- Explicit user opt-in for any AI feature that uploads user data.
- Use server-side proxy to hide AI API keys from clients.
- Anonymize user identifiers before sending (hash + salt or ephemeral tokens).
- Offer clear UI notices: what data is sent, why, and retention policy.
- Provide an option to purge AI-sent data associated with a user.

6) Localization plan

- Resource-first approach: Move UI strings to `res/values/strings.xml` and provide `values-th/strings.xml` translations.
- Implement runtime locale switching: either activity recreation on language change or a Compose-level locale provider.
- Test UI with Thai texts and adjust layout constraints (buttons, toolbars, text wrapping).

7) Implementation roadmap (short term)

1. Finish repo-wide resource migration and complete `values-th` translations for core flows.
2. Implement runtime locale application and immediate UI refresh on selection.
3. Create a Quick-Add UI and a Retrofit `AiApi` client that talks to a protected server endpoint (mock first).
4. Implement server proxy (small Node/Express or Cloud Function) that calls the chosen AI provider (OpenAI, Anthropic, or custom) and logs minimal telemetry.
5. Add analytics events and an A/B test framework to measure AI feature adoption and accuracy.

8) Next steps for this branch

- Add runtime locale application and complete translations.
- Create `AiApi` interfaces and local mock server for POC.
- Write unit tests for Quick-Add parser and Categorization suggestions.

Contact / Notes

- This spec is a living document. Update as we prototype and identify constraints (cost, privacy, accuracy).
