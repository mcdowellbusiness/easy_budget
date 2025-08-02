# Easy Budget - Personal Finance Management App

A comprehensive personal finance management application with AI-powered insights to help users track spending, analyze patterns, and make better financial decisions.

## 🚀 Features

### Backend API (Spring Boot)
- **Transaction Management**: CRUD operations for personal transactions
- **AI-Powered Insights**: OpenAI integration for intelligent spending analysis
- **Category-based Analysis**: Track spending by categories (Food, Bills, Entertainment, etc.)
- **RESTful API**: Clean, documented endpoints for easy integration

### Mobile App (React Native/Expo)
- **Cross-platform**: Works on iOS and Android
- **Modern UI**: Beautiful, intuitive interface
- **Real-time Updates**: Sync with backend API
- **Offline Support**: Local data caching

### AI Insights
- **Spending Pattern Analysis**: Identifies excessive spending in specific categories
- **Personalized Recommendations**: AI-generated advice for saving money
- **Smart Categorization**: Automatic transaction categorization
- **Financial Health Monitoring**: Tracks overall financial wellness

## 🏗️ Architecture

```
easy_budget/
├── api/                    # Spring Boot Backend
│   ├── controller/        # REST API endpoints
│   ├── service/          # Business logic layer
│   ├── model/            # JPA entities
│   ├── repository/       # Data access layer
│   └── infrastructure/   # External service clients
├── mobile/               # React Native Frontend
│   ├── app/             # Main app screens
│   ├── components/      # Reusable UI components
│   └── hooks/          # Custom React hooks
└── docker-compose.yaml  # Database setup
```

## 🛠️ Technology Stack

### Backend
- **Java 21** with Spring Boot 3.5.3
- **Spring Data JPA** for database operations
- **PostgreSQL** for data persistence
- **OpenAI API** for AI-powered insights
- **Maven** for dependency management

### Frontend
- **React Native** with Expo
- **TypeScript** for type safety
- **Expo Router** for navigation
- **Custom UI Components** for consistent design

### Infrastructure
- **Docker Compose** for local development
- **PostgreSQL** database
- **RESTful API** design

## 🚀 Quick Start

### Prerequisites
- Java 21
- Node.js 18+
- Docker and Docker Compose
- OpenAI API key

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/easy_budget.git
cd easy_budget
```

### 2. Set Up Environment Variables
Create `api/src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/easy_budget
spring.datasource.username=postgres
spring.datasource.password=password
openai.api.key=your_openai_api_key_here
```

### 3. Start the Database
```bash
docker compose up -d
```

### 4. Run the Backend API
```bash
cd api
chmod +x ./mvnw
./mvnw clean install
mvn spring-boot:run
```

### 5. Run the Mobile App
```bash
cd mobile
npm install
npx expo start
```

## 📱 API Endpoints

### Transactions
- `GET /transactions` - Get all transactions
- `GET /transactions/{id}` - Get specific transaction
- `POST /transactions` - Create new transaction
- `PUT /transactions/{id}` - Update transaction
- `DELETE /transactions/{id}` - Delete transaction
- `GET /transactions/category/{category}` - Get transactions by category
- `GET /transactions/category/{category}/total` - Get total spending by category

### Insights
- `GET /transactions/insights` - Get AI-powered spending insights

## 🤖 AI Features

The app uses OpenAI's GPT-4 to provide intelligent financial insights:

- **Spending Pattern Recognition**: Identifies excessive spending in categories like fast food
- **Cost-Saving Recommendations**: Suggests alternatives and money-saving strategies
- **Financial Health Analysis**: Provides overall financial wellness assessment
- **Personalized Advice**: Tailored recommendations based on individual spending habits

## 🎯 Use Cases

- **Budget Tracking**: Monitor daily spending and stay within budget limits
- **Expense Analysis**: Understand where money is being spent
- **Financial Planning**: Use AI insights to make better financial decisions
- **Spending Optimization**: Identify areas to reduce unnecessary expenses

## 🔧 Development

### Backend Development
```bash
cd api
mvn spring-boot:run
```

### Frontend Development
```bash
cd mobile
npx expo start
```

### Database Management
```bash
docker compose up -d    # Start database
docker compose down     # Stop database
```

## 📊 Project Structure

### Backend Services
- **TransactionService**: Handles transaction CRUD operations
- **InsightsService**: Manages AI-powered financial insights
- **OpenAiService**: Integrates with OpenAI API for analysis

### Frontend Components
- **Tab Navigation**: Explore and main dashboard
- **Transaction List**: View and manage transactions
- **Insights Display**: Show AI-generated recommendations

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- OpenAI for providing the AI capabilities
- Spring Boot team for the excellent framework
- Expo team for the React Native development platform


