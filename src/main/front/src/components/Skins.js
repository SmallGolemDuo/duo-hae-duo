import React, {useState, useEffect} from 'react';
import './Skins.css';
import {Link} from 'react-router-dom';

function Skins() {
    const [champions, setChampions] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');

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

    const filteredChampions = champions.filter(champion =>
        champion.championNameKor.toLowerCase().includes(searchTerm.toLowerCase())
    );

    return (
        <div className="skin-gallery-background">
            <div className="banner-container">
                <h1 style={{
                    color: 'white'
                }}>스킨 갤러리</h1>
                <a href="/" className="home-redirect-icon">
                    <img
                        src={"https://image.shutterstock.com/image-vector/letters-duo-joint-logo-icon-250nw-1113311357.jpg"}
                        alt="home_icon"
                        style={{marginTop: '2%'}}
                    />
                </a>
            </div>
            <div className="search-bar">
                <label htmlFor="champion-search" style={{
                    color: 'white',
                    marginRight: '5px'
                }}>
                    챔피언 검색 :
                </label>

                <input
                    type="text"
                    id="champion-search"
                    onChange={(e) => setSearchTerm(e.target.value)}
                    placeholder="챔피언 이름을 입력하세요..."
                    style={{
                        width: '40%',
                        height: '20%',
                        padding: '10px'
                    }}
                />
            </div>
            <div className="champion-grid">
                {searchTerm === '' ? (
                    // 검색어가 비어 있을 때 모든 챔피언을 보여줍니다.
                    champions.map(champion => (
                        <Link to={`/champion/${champion.id}`} key={champion.id} className="champion-box">
                            <img
                                src={champion.championIconUrl}
                                alt={champion.championNameKor}
                                className="champion-icon"
                                style={{
                                    width: '40%',
                                    height: '40%',
                                    border: '2px solid #9987eb',
                                    borderRadius: '5px',
                                }}
                            />
                            <div className="champion-name">
                                {champion.championNameKor}
                            </div>
                        </Link>
                    ))
                ) : (
                    // 검색어가 입력되었을 때 검색된 챔피언만 보여줍니다.
                    filteredChampions.map(champion => (
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
                    ))
                )}
            </div>
        </div>
    );
}

export default Skins;
