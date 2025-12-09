# GitHub Actions Workflows

This directory contains all CI/CD workflows for the **Kindred Newsletter API**.  
The workflows are designed to provide a secure, fully automated DevSecOps foundation for an open-source Kotlin/Ktor backend.

All workflows are modular, isolated, and safe to run on forks.

---

## 📦 CI Pipeline (`ci.yml`)

Runs on every PR and on pushes to `main`, `dev`, and feature branches.

Includes:
- Gradle build
- Ktlint formatting checks
- Detekt static analysis
- Spotless formatting validation
- Gradle caching
- Wrapper validation

Purpose: **Enforce code quality and ensure builds remain green.**

---

## 🔐 Security Pipeline (`security.yml`)

Runs on PRs and pushes to `main`.

Includes:
- **Semgrep** (static application security analysis)
- **Gitleaks** (secret scanning)
- **GitHub Dependency Review**
- Scheduled weekly security scans

Purpose:  
Ensure the codebase remains secure, secrets never leak, and dependencies are safe.

---

## 🧾 Software Bill of Materials (`sbom.yml`)

Builds the Docker image and generates a **CycloneDX SBOM** using Syft.

Purpose:  
Provide transparency and supply-chain integrity for downstream users and package auditors.

---

## 🧹 Code Quality Automation (`code-quality.yml`)

Enforces contributor and repository hygiene:

- Automatic PR labeling  
- Branch naming rules  
- Commit message linting (Conventional Commits)
- Automatic reviewer assignment (`phoenixredwolf`)
- PR metadata validation

Purpose:  
Maintain a predictable and clean contribution workflow.

---

## 🚀 Release Automation (`release.yml`)

Uses **release-please** to automate:

- Semantic Versioning (based on commit messages)
- CHANGELOG.md updates
- Git tag creation (e.g., `v1.2.0`)
- GitHub Release creation

Release trigger:
- Manually via GitHub UI (`workflow_dispatch`)
- Or automatically when a tag `v*.*.*` is pushed

Purpose:  
Ensure consistent, automated releases without manual version bumps.

---

## 🏗 Terraform Validation (`terraform.yml`)

Runs when files under `/infra` change.

Executes:
- `terraform fmt`
- `terraform init`
- `terraform validate`
- `terraform plan`

Purpose:  
Allow infrastructure code to evolve safely without impacting application workflows.

---

# ☁️ High-Level Guide: Adding Cloud Run Auto-Deployment

If a user wants to enable **automatic deployment to Google Cloud Run**, they can create a new workflow such as:

deploy.yml


Typical deployment steps (high level):

1. **Authenticate to Google Cloud**
   - Using `google-github-actions/auth`
   - Service Account with `roles/run.admin` and `roles/storage.admin`

2. **Build the Docker image**
   - Using `gcloud builds submit` or GitHub’s build/push actions

3. **Push to Artifact Registry**
   - Example: `us-central1-docker.pkg.dev/<project>/kindred-newsletter-api/api:latest`

4. **Deploy to Cloud Run**
   - Using `google-github-actions/deploy-cloudrun`

5. **(Optional) Tag releases or environments**
   - Production deployment on `main`
   - Staging deployment on `dev`

**Note**:  
Deployment is intentionally **not included** in this repository by default to keep the OSS project portable and platform-agnostic.

Users should configure deployment workflows based on:

- their cloud provider (GCP, AWS, Azure, Fly.io, Render, etc.)
- their project architecture
- their secrets and environment variables

---

# 🧩 How to Add Your Own Workflows

When contributors want to extend the pipeline, they should:

1. Create a new `.yml` file in this directory  
2. Use `on:` triggers appropriate for their workflow  
3. Reference official or trusted Actions  
4. Store secrets in GitHub Encrypted Secrets  
5. Use job isolation to avoid touching existing pipelines  

---

# 📁 Workflow Directory Structure
```
.github/
└─workflows/
├─ci.yml
├─security.yml
├─sbom.yml
├─code-quality.yml
├─release.yml
├─terraform.yml
└─README.md ← this file
```

---

# 🛡️ Notes for Contributors

- Do **not** hardcode credentials in workflows.  
- Do **not** modify `release.yml` unless you understand semantic release automation.  
- Always run changes through PRs — never push directly to `main` or `dev`.  

---

If you have questions about how the CI/CD system works or want to propose improvements, please open a discussion or issue in the repository.
