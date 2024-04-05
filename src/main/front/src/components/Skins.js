import React, {useState, useEffect} from 'react';
import './Skins.css';
import {Link} from 'react-router-dom';

function Skins() {
    const [champions, setChampions] = useState([]);

    const fetchData = () => {
        try {
            fetch('/api/lol/champions')
                .then((response) => response.json())
                .then((data) => {
                    setChampions(data);
                });
        } catch (error) {
            console.error("챔피언 조회 중 오류 발생:", error);
        }
    };

    useEffect(() => {
        fetchData();
    }, []);

    return (
        <div className="skin-gallery-background">
            <div className="banner-container">
                <h1>챔피언 스킨 갤러리</h1>
                <a href="/" className="home-redirect-icon">
                    <img
                        src={"https://image.shutterstock.com/image-vector/letters-duo-joint-logo-icon-250nw-1113311357.jpg"}
                        alt="home_icon"
                        style={{marginTop: '2%'}}
                    />
                </a>
            </div>
            <div className="champion-grid">
                {champions.map(champion => (
                    <Link to={`/champion/${champion.id}`} key={champion.id} className="champion-box">
                        <img
                            src={champion.championIconUrl}
                            alt={champion.championNameKor}
                            className="champion-icon"
                            style={{
                                width: '40%',
                                height: '40%',
                                border: '2px solid #9987eb',
                                borderRadius: '5px'
                            }}
                        />
                        <div className="champion-name">
                            {champion.championNameKor}
                        </div>
                    </Link>
                ))}
            </div>
        </div>
    );
}

export default Skins;
