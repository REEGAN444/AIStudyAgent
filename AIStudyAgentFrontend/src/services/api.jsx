import axios from "axios";

export const createGoal = async (goal) => {
  return await axios.post("http://localhost:8080/api/goals", goal);
};