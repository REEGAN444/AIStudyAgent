# 🧠 Agentic AI Study System

An **AI-powered multi-agent learning platform** that generates structured study plans and quizzes using **local LLMs (Ollama)** — built with **Spring Boot + React**.

---

## 🚀 Features

- 🧠 **Planner Agent** → Generates structured study plans  
- ❓ **Quiz Agent** → Creates MCQ-based quizzes  
- ⚡ **Local AI (Ollama)** → No API cost, fully offline  
- 🎯 **Adaptive UI** → Automatically formats AI responses  
- 🔄 **Loading Experience** → Fullscreen AI processing feedback  
- 🧩 **Multi-Agent Architecture** → Not just a chatbot  

---

## 🏗️ Tech Stack

### Backend
- Java Spring Boot  
- REST APIs  
- H2 Database  
- Ollama (Local LLM)

### Frontend
- React.js  
- Custom CSS (Dark SaaS UI)  
- Dynamic Rendering (HTML parsing)

---

## 🧠 Architecture
User (React UI)
↓
Spring Boot API
↓
| Planner Agent (LLM) |
| Quiz Agent (LLM) |
 ↓

Ollama (Local Models)
↓
Response → UI (Formatted)


---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/agentic-ai-study.git
cd agentic-ai-study

2️⃣ Start Ollama (Local LLM)

Install Ollama and run:

ollama pull llama3.1
ollama run llama3.1
3️⃣ Backend Setup (Spring Boot)
cd backend
mvn spring-boot:run

Backend runs on:

http://localhost:8080
4️⃣ Frontend Setup (React)
cd frontend
npm install
npm start

Frontend runs on:

http://localhost:5173
⚙️ Configuration
application.properties
server.port=8080

# H2 DB
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# Ollama
ollama.url=http://localhost:11434/api/generate
ollama.model=llama3.1
🧪 API Endpoint
Create Study Plan + Quiz
POST /goal
Request Body
{
  "title": "DBMS",
  "days": 5
}
💡 Key Highlights
✅ Uses Agentic AI (not a chatbot)
✅ Fully offline LLM system
✅ Scalable architecture (multi-agent ready)
✅ Clean developer-friendly UI
✅ Hackathon-ready project
📸 UI Preview
Dark modern dashboard
Fullscreen loading animation
Structured AI output (Plan + Quiz sections)
🔮 Future Improvements
🎯 Interactive quiz (clickable options)
📊 Score tracking system
🤖 Evaluator Agent (AI feedback)
📁 User progress saving
🌐 Cloud deployment
🏆 Why This Project?

This project demonstrates:

Real-world AI system design
Multi-agent architecture
Integration of LLMs with full-stack apps
Strong problem-solving + product thinking
🤝 Contributing

Feel free to fork and improve!

📜 License

MIT License

🔥 Final Note

This is not just another AI app —
👉 it’s a complete agentic system built for real-world use.
