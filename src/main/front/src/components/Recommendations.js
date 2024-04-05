import React, {useState} from 'react';
import axios from 'axios';
import {useNavigate} from 'react-router-dom';
import "./Recommendations.css";

function Recommendations() {
    const [questions, setQuestions] = useState([]);
    const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
    const [selectedAnswers, setSelectedAnswers] = useState([]);
    const navigate = useNavigate();

    const fetchQuestions = async () => {
        try {
            const response = await axios.get('/api/lol/recommendations');
            setQuestions(response.data);
        } catch (error) {
            console.error("질문 조회 중 오류 발생:", error);
        }
    };

    const handleStart = async () => {
        console.log("시작하기 버튼이 클릭되었습니다.");
        await fetchQuestions();
    };

    const handleBack = () => {
        navigate('/');
    };

    const handleSelect = (answer) => {
        const updatedAnswers = [...selectedAnswers, answer];
        setSelectedAnswers(updatedAnswers);
        const nextQuestionIndex = currentQuestionIndex + 1;
        if (nextQuestionIndex < questions.length) {
            setCurrentQuestionIndex(nextQuestionIndex);
        } else {
            navigate('/recommendResults', {state: {selectedAnswers: updatedAnswers}});
        }
    };

    return (
        <div className="recommendation-background">
            <div className="recommendations-container">
                {questions.length > 0 && (
                    <div className="select-center-box">
                        <div>
                            <h2 className="select-count">{`${currentQuestionIndex + 1}/${questions.length}`}</h2>
                            <h2 className="select-text">{`Q ${currentQuestionIndex + 1}). ${questions[currentQuestionIndex].question}`}</h2>
                            <div className="options-container">
                                {Object.entries(questions[currentQuestionIndex].answers).map(([answer, type], index) => (
                                    <button className="select-button"
                                            key={index} onClick={() => handleSelect(type)}>{answer}
                                    </button>
                                ))}
                            </div>

                        </div>
                    </div>
                )}
                {questions.length === 0 && (
                    <div className="center-box">
                        <button className="start-button" onClick={handleStart}>시작하기</button>
                        <button className="back-button" onClick={handleBack}>돌아가기</button>
                    </div>
                )}
            </div>
        </div>
    );
}

export default Recommendations;
