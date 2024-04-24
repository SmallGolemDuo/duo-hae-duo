import React, {useEffect, useState} from "react";
import './RotationChampions.css';
import {Link} from "react-router-dom";

function RotationChampions() {
    const [champions, setChampions] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('/api/lol/champions/rotations');
                if (!response.ok) {
                    throw new Error('서버로부터 데이터를 가져오는 중 오류가 발생했습니다.');
                }
                const data = await response.json();
                setChampions(data.rotationChampions);
                console.log(data.rotationChampions)
            } catch (error) {
                console.error('데이터를 가져오는 중 오류가 발생했습니다:', error);
            }
        };
        fetchData();
    }, []);

    return (
        <div className="rotation-container">
            <Link to="/" className="rotation-redirect-icon">
                <img
                    src={"https://image.shutterstock.com/image-vector/letters-duo-joint-logo-icon-250nw-1113311357.jpg"}
                    alt="home_icon" style={{
                    marginLeft: "5%",
                    marginTop: "3.5%",
                    width: "8%",
                    height: "12%",
                    position: "absolute",
                }}/>
            </Link>
            <h1 className="rotation-title">로테이션 챔피언</h1>
            <div className="rotation-champions-container">
                {champions.map((champion, index) => (
                    <div key={index} className="rotation-champion-item">
                        <img
                            src={champion.championIconUrl}
                            alt={champion.championNameKor}
                            className="rotation-champion-icon"/>
                        <div className="rotation-champion-name">{champion.championNameKor}</div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default RotationChampions;
