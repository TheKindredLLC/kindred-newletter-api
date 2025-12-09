# Kindred Newsletter API

A fully extensible, open-source backend for managing modern newsletters.  
Built with **Ktor**, **Kotlin (JVM 24)**, and **Koin**, the Kindred Newsletter API is designed to be a
flexible foundation for creators, teams, and organizations that want a self-hosted,
modular, and privacy-respecting newsletter engine.

This backend powers subscription management, email delivery, content storage, theming,
and media handling — all using a clean abstraction layer so developers can plug in their
own SQL/NoSQL databases, email providers, and storage backends without changing core logic.

🚧 **This repository is currently in Phase 1: Infrastructure Setup (CI/CD + Docker + Repo Structure).**  
Application code will be added in Phase 2.

---

## ✨ Features (Planned)

### 📨 Newsletter Delivery Engine
- Subscription & opt-in / opt-out flows  
- Email sending abstraction (SendGrid, SES, Mailgun, SMTP, etc.)  
- Queue-ready delivery pipeline  

### 📝 Content Management
- Abstracted NoSQL backend (MongoDB, Cassandra, DynamoDB, etc.)  
- Rich-text or Markdown content storage  
- Server-side rendering of newsletter content (HTML)  

### 👤 Subscriber Management
- SQL-based subscriber store (PostgreSQL, Aurora, MySQL, SQLite, etc.)  
- Double opt-in support  
- GDPR-friendly deletion  

### 🎨 Theming & Branding
- JSON-based theme configuration  
- Light/dark palette support  
- Configurable via admin UI (in companion frontend repo)  

### 🖼️ Media Handling
- Abstracted image storage (S3, GCS, Cloudflare R2, local FS)  
- Automatic optimization pipeline (planned)  

### 🛠️ Administration API
- Create/edit newsletters  
- Toggle between Markdown or WYSIWYG content  
- Manage settings, themes, metadata  

---

## 🏗️ Technology Stack

### Backend
- **Kotlin (JVM 24)**
- **Ktor** (server / routing / serialization)
- **Koin** (dependency injection)
- **Coroutines** (async)
- **Docker** (containerized deployments)

### Storage Abstraction
- **SQL**: Any JDBC-compatible database (Postgres recommended)
- **NoSQL**: Pluggable driver system (MongoDB, DynamoDB, Cassandra)
- **Media Storage**: S3-compatible abstraction layer

### Email Providers
- Plug-and-play architecture for multiple email services

---

## 🧰 Repository CI/CD

This project includes a full, modern DevSecOps pipeline using GitHub Actions:

### 🔹 CI (`ci.yml`)
- Build  
- Ktlint  
- Detekt  
- Spotless  
- Test  
- Gradle wrapper validation  

### 🔹 Security (`security.yml`)
- Semgrep security scan  
- Gitleaks secret detection  
- GitHub dependency review  
- Weekly scheduled security scanning  

### 🔹 SBOM Generation (`sbom.yml`)
- Multi-stage Docker build  
- Syft CycloneDX Software Bill of Materials  
- Weekly supply-chain reporting  

### 🔹 Code Quality (`code-quality.yml`)
- Branch naming enforcement  
- Commit message linting (Conventional Commits)  
- Auto-labeling PRs  
- Auto-assign reviewer (`phoenixredwolf`)  

### 🔹 Terraform (`terraform.yml`)
- `fmt`, `validate`, `init`, `plan`  
- Workflow triggered only when infra files change  

### 🔹 Release Automation (`release.yml`)
- Triggered manually or by `v*.*.*` tag push  
- Auto-SemVer bump using commit history  
- Auto-generated `CHANGELOG.md`  
- Auto-created GitHub Release  

---

## 🐳 Docker

This repo ships with a fully working, multi-stage Dockerfile.

Build image manually:

```bash
docker build -t kindred-newsletter-api .
docker run -p 8080:8080 kindred-newsletter-api
```

## 📁 Project Structure
kindred-newsletter-api/
```
 ├─ Dockerfile
 ├─ .gitleaks.toml
 ├─ README.md
 ├─ infra/                    # (Terraform coming soon)
 └─ .github/
      └─ workflows/
         ├─ ci.yml
         ├─ code-quality.yml
         ├─ release.yml
         ├─ sbom.yml
         ├─ security.yml
         ├─ terraform.yml
```
## Branch Strategy
* main → protected, release-ready
* dev → primary development branch
* feature/* → new functionality
* bugfix/* → bug resolutions
* hotfix/* → emergency patches
* chore/* → maintenance tasks

Pull requests must follow naming conventions and commit message standards.

## 🤝 Contributing
Contributions are welcome!

 Before opening a PR, make sure that:
1. Your branch name follows the required format
2. Your commits follow Conventional Commits
3. CI passes locally (./gradlew build)
4. You run ./gradlew spotlessApply

## 📜 License
This project uses the MIT License, making it fully open and reusable for personal and commercial projects.