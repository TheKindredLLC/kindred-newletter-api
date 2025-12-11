# Kindred Newsletter API

A fully extensible, modular, open-source backend for managing modern newsletters.

Built with **Ktor**, **Kotlin (JVM 24)**, and **Koin**, the Kindred Newsletter API is designed as a
high-performance, privacy-respecting foundation for creators, teams, and organizations who want the
flexibility of a self-hosted newsletter platform without the lock-in of SaaS products.

The system is architected into isolated modules (email, campaigns, queueing, scheduling,
subscriber management, storage, analytics, extensions, and more) to ensure plug-and-play
customization with minimal coupling.

---

## ✨ Features 

### 📨 Newsletter Delivery Engine
- Subscriber lifecycle: subscribe, confirm, unsubscribe, GDPR erase  
- Pluggable email delivery: SMTP, SES, SendGrid, Mailgun, and custom providers  
- Queue-driven delivery pipeline with backpressure  
- Batch execution for large sends  

### 📝 Content & Campaign Management
- Markdown or rich-text storage  
- Template rendering engine (HTML)  
- Campaign scheduling (immediate, delayed, recurring)  
- Segmentation and audience filtering  

### 👤 Subscriber Management
- SQL-based subscriber store (PostgreSQL recommended)  
- NoSQL-based metadata (segmentation, events, attributes)  
- Compliance module (double opt-in, audit logging)  

### 🎨 Theming & Branding
- Template system defining layout, typography, colors  
- Multi-tenant theme isolation  
- JSON-based theme definitions  

### 🖼️ Media Handling
- Abstract blob storage interface (S3, GCS, R2, local FS)  
- Image sanitization pipeline (planned)  
- Automatic resizing and optimization (planned)  

### 🛠️ Administration & Multi-Tenancy
- Tenant onboarding (organizations)  
- API keys and scoped access  
- Admin console backend (for managing tenants, quotas, monitoring)  

### 📊 Analytics (Planned)
- Open tracking (pixel)  
- Click tracking + redirect engine  
- Event ingestion  
- Aggregated analytics summaries  

### 🧩 Extension System (Planned)
- Plugin architecture for custom integrations  
- User-defined workflows  
- Custom event processors  

---

## 🏗️ Architecture Overview

The platform is built from isolated modules to ensure scalability and flexibility.

```
admin/              → platform admin (not tenant admins)
analytics/          → tracking aggregation and reporting
campaign/           → campaign core, scheduling, batch execution
core/               → shared domain primitives
email/              → email providers, templating, mock providers
extension/          → plugin/extension framework
organization/       → multi-tenant models, API keys, auth
queueing/           → async queue abstraction + implementations
scheduling/         → CRON/timed job scheduler
server/             → Ktor API and startup
storage/            → SQL/NoSQL/blob storage abstraction layers
subscriber/         → subscriber core, segmentation, compliance
tracking/           → click tracking, pixel tracking, ingestion
```

Each module is optional and communicates via well-defined interfaces.

---

## 🏗️ Technology Stack

### Core Backend
- **Kotlin 2.2.21 (JVM 24)**
- **Ktor 3** (server, routing, config, serialization)
- **Koin 4** (DI)
- **Coroutines**
- **Gradle (Kotlin DSL)**

### Storage Abstractions
- **SQL**: JDBC 
- **NoSQL**: MongoDB, DynamoDB, Cassandra (pluggable)
- **Blob storage**: S3-compatible interfaces

### Email Providers
- SMTP (Jakarta Mail)
- Mock provider (for testing)
- Additional providers implemented via email-service

---

## 🧰 Repository CI/CD

### 🔹 CI (`ci.yml`)
- Build  
- Ktlint  
- Detekt  
- Spotless  
- Tests  
- Gradle wrapper validation  

### 🔹 Security (`security.yml`)
- Semgrep  
- Gitleaks  
- Dependency review  
- Scheduled weekly security scan  

### 🔹 SBOM (`sbom.yml`)
- Multi-stage Docker build  
- CycloneDX SBOM generation  
- Weekly supply-chain reports  

### 🔹 Code Quality (`code-quality.yml`)
- Branch name enforcement  
- Commit message linting  
- PR auto-labeling  
- Auto-assign reviewer (`phoenixredwolf`)  

### 🔹 Terraform (`terraform.yml`)
- `fmt`, `validate`, `init`, `plan`  
- Automatically triggers only for `infra/**` changes  

### 🔹 Release Automation (`release.yml`)
- Manual or tag-triggered  
- Auto SemVer bump  
- CHANGELOG generation  
- GitHub Release creation  

---

## 🐳 Docker

A full production-grade multi-stage Dockerfile is included.

```bash
docker build -t kindred-newsletter-api .
docker run -p 8080:8080 kindred-newsletter-api
```

---

## 📁 Project Structure

```
kindred-newsletter-api/
 ├─ README.md
 ├─ Dockerfile
 ├─ build.gradle.kts
 ├─ settings.gradle.kts
 ├─ core/
 ├─ admin/
 ├─ analytics/
 ├─ campaign/
 ├─ email/
 ├─ extension/
 ├─ organization/
 ├─ queueing/
 ├─ scheduling/
 ├─ server/
 ├─ storage/
 ├─ subscriber/
 ├─ tracking/
 └─ .github/
      └─ workflows/
         ├─ ci.yml
         ├─ code-quality.yml
         ├─ release.yml
         ├─ sbom.yml
         ├─ security.yml
         ├─ terraform.yml
```

---

## 🌿 Branch Strategy

- **main** → protected, release-ready  
- **dev** → active development  
- **feature/** → new functionality  
- **bugfix/** → bug resolution  
- **hotfix/** → emergency patch  
- **chore/** → maintenance tasks  

PRs must:
- Use Conventional Commits  
- Follow branch naming rules  
- Pass CI  
- Run `./gradlew spotlessApply`  

---

## 🤝 Contributing

Contributions are welcome!

Before opening a PR:
1. Confirm your branch follows naming rules  
2. Ensure your commits follow Conventional Commits  
3. Run tests (`./gradlew test`)  
4. Run formatters (`./gradlew spotlessApply`)  

---

## 📜 License

This project is licensed under the **MIT License**, allowing unrestricted commercial and personal use.

