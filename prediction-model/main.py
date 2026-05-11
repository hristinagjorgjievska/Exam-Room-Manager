from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
import pandas as pd
import joblib
import uvicorn


app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:8080"],
    allow_methods=["*"],
    allow_headers=["*"],
)

model = joblib.load("attendance_model.pkl")
subject_average_rates = pd.read_csv("subject_avg_rates.csv")

class PredictRequest(BaseModel):
    subject_id: int
    enrolled_survey: int

class PredictResponse(BaseModel):
    predicted_attendance: int
    attendance_rate: float

@app.post("/predict")
def predict(req: PredictRequest):
    subject_to_predict = subject_average_rates[subject_average_rates["subject_id"] == req.subject_id]

    if len(subject_to_predict) != 0:
        avg_rate = float(subject_to_predict["subject_avg_rate"].values[0])
        features = pd.DataFrame([{
            "subject_id": req.subject_id,
            "enrolled_survey": req.enrolled_survey,
            "subject_avg_rate": avg_rate,
        }])
        predicted_number_students = int(round(model.predict(features)[0]))
    else:
        avg_rate = float(subject_average_rates["subject_avg_rate"].mean())
        predicted_number_students = int(round(req.enrolled_survey * avg_rate))


    predicted_number_students = max(0, predicted_number_students)
    rate = round(predicted_number_students / req.enrolled_survey, 4)

    return PredictResponse(predicted_attendance = predicted_number_students, attendance_rate = rate)

if __name__ == "__main__":
    uvicorn.run("main:app", host="0.0.0.0", port=8000, reload=True)