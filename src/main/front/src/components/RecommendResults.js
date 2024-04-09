import React, {useEffect, useState} from 'react';
import {useLocation} from "react-router-dom";
import "./RecommendResult.css";

function RecommendResults() {
    const [champions, setChampions] = useState([]);
    const location = useLocation();

    useEffect(() => {
        const selectedAnswers = location.state.selectedAnswers;
        if (selectedAnswers.length > 0) {
            fetchData(selectedAnswers);
        }
    }, []);

    const fetchData = (selectedAnswers) => {
        try {
            fetch('/api/lol/champions', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({answers: selectedAnswers})
            })
                .then((response) => response.json())
                .then((data) => {
                    setChampions(data)
                });
        } catch (error) {
            console.error("챔피언 조회 중 오류 발생:", error);
        }
    }

    if (!champions || champions.length === 0) {
        return <div> 챔피언이 존재하지 않습니다.</div>
    }
    return (
        <div className="recommend-result-background">
            <a href="/" className="home-redirect-icon" style={{
                position: "fixed",
                left: "8%",
                top: "3%",
            }}>
                <img
                    src={"https://image.shutterstock.com/image-vector/letters-duo-joint-logo-icon-250nw-1113311357.jpg"}
                    alt="home_icon"
                    style={{
                        width: '100px',
                        height: '100px',
                    }}
                />
            </a>
            <div className="background-image"></div>
            <div className="champion-image-center-box">
                {champions.championPayloads.slice(0, 3).map((champion, index) => (
                    <div key={index} className="champion-box">
                        <img
                            src={`https://ddragon.leagueoflegends.com/cdn/img/champion/splash/${champion.championNameEng}_0.jpg`}
                            alt={champion.championNameKor}/>
                        <div className="champion-info">
                            <h2>{champion.championNameKor} - {champion.championNameEng}</h2>
                            <p>주 포지션: {champion.position}</p>
                            <p>역활군: {champion.championType}</p>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default RecommendResults;
