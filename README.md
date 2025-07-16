# WhatsApp Business Platform Clone

[![CI](https://github.com/username/whatsapp-business-clone/actions/workflows/ci.yml/badge.svg)](https://github.com/username/whatsapp-business-clone/actions/workflows/ci.yml)
[![Android CI](https://github.com/username/whatsapp-business-clone/actions/workflows/android-ci.yml/badge.svg)](https://github.com/username/whatsapp-business-clone/actions/workflows/android-ci.yml)
[![Coverage](https://img.shields.io/badge/coverage-90%25-brightgreen)](https://github.com/username/whatsapp-business-clone)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

A production-ready WhatsApp Business Platform clone built with Spring Boot 3, Android (Kotlin), and Meta's WhatsApp Business Cloud API. Supports all 39 message types with real-time delivery, comprehensive observability, and enterprise-grade security.

## 🏗️ Architecture Overview

```
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│   Android App   │◄──►│  Spring Boot API │◄──►│ Meta WhatsApp   │
│                 │    │                  │    │   Cloud API     │
│ • MVVM + Clean  │    │ • WebFlux        │    │                 │
│ • Room DB       │    │ • R2DBC          │    │ • 39 Endpoints  │
│ • WebSocket     │    │ • Kafka          │    │ • Webhooks      │
│ • FCM Push      │    │ • Circuit Breaker│    │ • Media Upload  │
└─────────────────┘    └──────────────────┘    └─────────────────┘
         │                       │
         │              ┌────────▼────────┐
         │              │   PostgreSQL    │
         │              │                 │
         │              │ • Chat History  │
         │              │ • Message Store │
         │              │ • Media Meta    │
         │              └─────────────────┘
         │
    ┌────▼─────┐       ┌─────────────────┐
    │ Firebase │       │      Kafka      │
    │          │       │                 │
    │ • Auth   │       │ • Event Stream  │
    │ • FCM    │       │ • Message Queue │
    └──────────┘       │ • Webhooks      │
                       └─────────────────┘
```

## 🚀 Features

### Message Types (All 39 Meta API Endpoints)
- ✅ **Text Messages** - Rich text with formatting
- ✅ **Media Messages** - Images, videos, audio, documents
- ✅ **Location Sharing** - GPS coordinates with maps
- ✅ **Contact Cards** - vCard format contacts
- ✅ **Interactive Messages** - Buttons, lists, quick replies
- ✅ **Template Messages** - Business templates
- ✅ **Reactions** - Emoji reactions to messages
- ✅ **Message Status** - Delivery receipts and read status
- ✅ **Business Profile** - Company information management

### Real-time Features
- 🔄 **Live Synchronization** - WebSocket-based real-time updates
- 📱 **Push Notifications** - Firebase Cloud Messaging
- 📊 **Typing Indicators** - Real-time typing status
- ✅ **Read Receipts** - Message read confirmation
- 🔄 **Offline Support** - Message queuing and sync

### Security & Compliance
- 🔒 **HTTPS Enforcement** - TLS 1.3 with certificate pinning
- 🔐 **JWT Authentication** - Firebase Auth integration
- 🛡️ **HMAC Validation** - Webhook signature verification
- 🔍 **OWASP Compliance** - Security scanning and best practices
- 📝 **Data Protection** - Encryption at rest and in transit

## 📋 Prerequisites

- **Java 17+** - OpenJDK or Oracle JDK
- **Docker & Docker Compose** - For containerization
- **Android Studio** - Latest stable version
- **Node.js 18+** - For development tools
- **Git** - Version control

## 🚀 Quick Start

### 1. Clone Repository
```bash
git clone https://github.com/username/whatsapp-business-clone.git
cd whatsapp-business-clone
```

### 2. Environment Setup
```bash
cp .env.example .env
# Edit .env with your configuration
```

### 3. Start Services
```bash
docker-compose up --build
```

### 4. Build Android App
```bash
cd android-client
./gradlew assembleDebug
```

## 🔧 Configuration

### Environment Variables (.env)
```bash
# Meta WhatsApp Business API
WHATSAPP_ACCESS_TOKEN=your_access_token_here
WHATSAPP_PHONE_NUMBER_ID=your_phone_number_id
WHATSAPP_BUSINESS_ACCOUNT_ID=your_business_account_id
WHATSAPP_WEBHOOK_VERIFY_TOKEN=your_webhook_verify_token
WHATSAPP_WEBHOOK_SECRET=your_webhook_secret

# Database
DATABASE_URL=postgresql://localhost:5432/whatsapp_business
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=postgres

# Firebase
FIREBASE_PROJECT_ID=your_firebase_project_id
FIREBASE_PRIVATE_KEY_ID=your_private_key_id
FIREBASE_PRIVATE_KEY=your_private_key
FIREBASE_CLIENT_EMAIL=your_client_email
FIREBASE_CLIENT_ID=your_client_id
FCM_SERVER_KEY=your_fcm_server_key

# Security
JWT_SECRET=your_jwt_secret_key_here
ENCRYPTION_KEY=your_encryption_key_here

# Kafka
KAFKA_BOOTSTRAP_SERVERS=localhost:9092

# Observability
JAEGER_ENDPOINT=http://localhost:14268/api/traces
PROMETHEUS_ENDPOINT=http://localhost:9090
```

### Meta WhatsApp Business Setup
1. Create a [Meta Developer Account](https://developers.facebook.com/)
2. Set up WhatsApp Business API
3. Get your access token and phone number ID
4. Configure webhook URL: `https://your-domain.com/api/webhook`

### Firebase Setup
1. Create a [Firebase Project](https://console.firebase.google.com/)
2. Enable Authentication (Email/Password)
3. Enable Cloud Messaging (FCM)
4. Download service account key
5. Configure Android app with `google-services.json`

## 📊 Monitoring & Observability

### Grafana Dashboard
Access at: http://localhost:3000
- Username: `admin`
- Password: `admin`

### Prometheus Metrics
Access at: http://localhost:9090

### Jaeger Tracing
Access at: http://localhost:16686

## 🧪 Testing

### Backend Tests
```bash
cd backend
mvn test
mvn verify # Includes integration tests
```

### Android Tests
```bash
cd android-client
./gradlew test
./gradlew connectedAndroidTest
```

### Load Testing
```bash
# JMeter load test (500 concurrent users)
jmeter -n -t infra/loadtest.jmx -l results.jtl
```

## 🚀 Deployment

### Render
```bash
# Deploy using render.yaml
render deploy
```

### Fly.io
```bash
# Deploy using fly.toml
fly deploy
```

### AWS (Terraform)
```bash
cd infra/terraform
terraform init
terraform plan
terraform apply
```

## 📈 Performance Targets

- **Latency**: p99 ≤ 250ms under 500 concurrent users
- **Throughput**: 1000+ messages/second
- **Availability**: 99.9% uptime
- **Auto-scaling**: CPU > 50% triggers horizontal scaling

## 🔍 API Documentation

- **OpenAPI Spec**: [docs/openapi.yml](docs/openapi.yml)
- **Postman Collection**: [docs/postman/](docs/postman/)
- **Interactive Docs**: http://localhost:8080/swagger-ui.html

## 📚 Documentation

- **Architecture Decisions**: [docs/adr/](docs/adr/)
- **API Reference**: [docs/api/](docs/api/)
- **Deployment Guide**: [docs/deployment/](docs/deployment/)
- **Architecture Slides**: [docs/slides/](docs/slides/)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'feat: add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🎬 Project Demo

![Demo GIF](docs/demo.gif)

**Demo Flow:**
1. 📱 Android Login → Firebase authentication
2. 💬 Send Text Message → Real-time delivery
3. 📸 Send Media → Image with caption
4. 📍 Send Location → Interactive map
5. 🔘 Interactive Buttons → Customer engagement
6. ✅ Delivery Status → Read receipts
7. 📊 Monitoring → Grafana dashboard

## 🏆 Quality Gates

- ✅ 90%+ test coverage
- ✅ OWASP security compliance
- ✅ Load tested (500 concurrent users)
- ✅ Multi-cloud deployment ready
- ✅ Comprehensive monitoring
- ✅ Production-ready documentation

---

**Built with ❤️ using Spring Boot 3, Android Kotlin, and Meta WhatsApp Business API**