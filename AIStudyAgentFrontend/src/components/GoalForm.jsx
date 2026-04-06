import React, { useState } from "react";
import { createGoal } from "../services/api";
import "../App.css";

function GoalForm() {
  const [title, setTitle] = useState("");
  const [days, setDays] = useState(5);
  const [result, setResult] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async () => {
    if (!title) return alert("Please enter a topic");

    setLoading(true);
    setResult("");

    try {
      const res = await createGoal({ title, days });
      setResult(res.data);
    } catch (err) {
      setResult("❌ Error fetching response from backend");
    }

    setLoading(false);
  };

  // 🔥 FORMAT TEXT (FIXES YOUR ISSUE)
  const formatText = (text) => {
    if (!text) return "";

    return text
      .replace(/\*\*(.*?)\*\*/g, "<b>$1</b>")   // bold
      .replace(/\n/g, "<br>")                  // line break
      .replace(/`(.*?)`/g, "<code>$1</code>"); // code
  };

  // 🔥 SMART SPLIT
  const getSections = () => {
    if (!result) return { plan: "", quiz: "" };

    const lower = result.toLowerCase();

    return {
      plan: lower.includes("day") ? result : "",
      quiz: lower.includes("question") || lower.includes("mcq") ? result : ""
    };
  };

  const { plan, quiz } = getSections();

  return (
    <div className="container">

      {/* 🔥 FULLSCREEN LOADING */}
      {loading && (
        <div className="loading-screen">
          <div className="spinner"></div>
          <div className="loading-text">Generating AI Response...</div>
        </div>
      )}

      <div className="card">

        <div className="title">Agentic AI Study System 🚀</div>

        {/* INPUT */}
        <input
          className="input"
          placeholder="Enter topic (e.g. DBMS, AI, OS)"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />

        <input
          className="input"
          type="number"
          min="1"
          value={days}
          onChange={(e) => setDays(e.target.value)}
        />

        {/* BUTTON */}
        <button className="button" onClick={handleSubmit}>
          Generate Plan + Quiz
        </button>

        {/* RESPONSE */}
        {!loading && result && (
          <div className="response">

            {/* STUDY PLAN */}
            {plan && (
              <div className="section">
                <h3>📅 Study Plan</h3>
                <div
                  className="text"
                  dangerouslySetInnerHTML={{ __html: formatText(plan) }}
                ></div>
              </div>
            )}

            {/* QUIZ */}
            {quiz && (
              <div className="section">
                <h3>🧠 Quiz</h3>
                <div
                  className="text"
                  dangerouslySetInnerHTML={{ __html: formatText(quiz) }}
                ></div>
              </div>
            )}

            {/* FALLBACK */}
            {!plan && !quiz && (
              <div className="section">
                <h3>📄 AI Response</h3>
                <div
                  className="text"
                  dangerouslySetInnerHTML={{ __html: formatText(result) }}
                ></div>
              </div>
            )}

          </div>
        )}

      </div>
    </div>
  );
}

export default GoalForm;