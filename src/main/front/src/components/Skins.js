import React, {useState, useEffect} from 'react';
import './Skins.css';
import {Link} from 'react-router-dom';
import {Navigate} from 'react-router-dom';


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

    // const handleChampionClick = (championNameEng) => {
    //     fetch(`/api/lol/champions/${championNameEng}/skins`)
    //         .then((response) => response.json())
    //         .then((data) => {
    //             return <Navigate to={`/champion/${championNameEng}/skins`}/>;
    //         })
    //         .catch((error) => {
    //             console.error("챔피언 스킨 정보를 가져오는 중 오류 발생:", error);
    //         });
    // };

    const filteredChampions = champions.filter(champion =>
        champion.championNameKor.toLowerCase().includes(searchTerm.toLowerCase())
    );

    return (
        <div className="skin-gallery-background">
            <div className="banner-container">
                <h1 style={{
                    color: 'white'
                }}>스킨 갤러리</h1>
                <a href="/" className="home-redirect-icon" style={{
                    marginLeft: '-75%',
                    marginTop: '0'
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
            <div className="champion-grid-owner" style={{height: '100vh'}}>
                <div className="champion-grid" style={{height: '70%', overflowY: 'auto'}}>
                    {searchTerm === '' ? (
                        champions.map(champion => (
                            <Link to={`/champions/${champion.championNameEng}/skins`} key={champion.championNameEng}
                                  className="champion-box">
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
                        filteredChampions.map(champion => (
                            <Link to={`/champions/${champion.championNameEng}/skins`} key={champion.championNameEng}
                                  className="champion-box">
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
        </div>
    );
}

export default Skins;
