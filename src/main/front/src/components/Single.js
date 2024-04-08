/* Single.js */

import React, {useState, useEffect} from 'react';
import './Home.css';
import './MatchInfo.css';
import {useLocation} from 'react-router-dom';
import Popover from './Popover'; // 현재 파일의 위치에 따라 경로를 조정해야 할 수 있습니다.


const Single = () => {
    const [gameNickname, setGameNickname] = useState('');
    const [searchResult, setSearchResult] = useState(null);
    const [loading, setLoading] = useState(false); // 로딩 상태 추가
    const [errorMessage, setErrorMessage] = useState(null);


    const location = useLocation();

    // 현재 마우스 오버된 참가자의 이름과 위치 정보를 저장하기 위한 상태
    const [hoveredParticipant, setHoveredParticipant] = useState(null);
    const [popoverTargetRect, setPopoverTargetRect] = useState(null);

    // 마우스가 참가자 이름 위에 올라간 경우를 처리하는 함수
    const handleMouseEnter = (participantName, targetElement) => {
        const rect = targetElement.getBoundingClientRect(); // 트리거 요소의 위치 정보 계산
        setHoveredParticipant(participantName); // 현재 마우스 오버된 참가자 이름 설정
        setPopoverTargetRect(rect); // 팝오버 트리거 요소의 위치 정보 설정
    };

    // 마우스가 참가자 이름에서 벗어난 경우를 처리하는 함수
    const handleMouseLeave = () => {
        setHoveredParticipant(null); // 마우스 오버된 참가자 이름 초기화
        setPopoverTargetRect(null); // 팝오버 트리거 요소의 위치 정보 초기화
    };

    //


    useEffect(() => {
        const playerName = new URLSearchParams(location.search).get('playerName');
        if (playerName) {
            console.log(playerName);
            setGameNickname(playerName);
            fetchData(playerName);
        }
    }, []);

    const handleInputChange = (e) => {
        setGameNickname(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        fetchData(gameNickname);
    };

    const fetchData = (playerName) => {
        setLoading(true); // 데이터 요청 전에 로딩 상태를 true로 설정
        fetch('http://localhost:8080/api/lol/singles', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({gameNickname: playerName}), // playerName을 gameNickname으로 수정
        })
            .then((response) => {
                if (!response.ok) {
                    const message = '플레이어를 찾을 수 없습니다.';
                    setErrorMessage(message);
                    throw new Error(message);
                }
                return response.json();
            })
            .then((data) => {
                const firstMatchInfo = data.convertedRiotData.matchInfos[0];
                if (firstMatchInfo.searchSummonerInfo) {
                    setSearchResult(data);
                } else {
                    console.log(data);
                    console.log(data.searchSummonerInfo);
                    setErrorMessage('닉네임 또는 태그를 확인해주세요.');
                    setSearchResult(null); // 데이터가 없을 경우 null로 설정
                }

                setLoading(false); // 데이터를 성공적으로 받은 후에 로딩 상태를 false로 설정
            })
            .catch((error) => {
                console.error('Error:', error);
                setLoading(false); // 오류 발생 시에도 로딩 상태를 false로 설정
            });
    };

    // errorMessage가 변경될 때마다 특정 시간이 지난 후에 errorMessage를 초기화합니다.
    useEffect(() => {
        if (errorMessage) {
            const timer = setTimeout(() => {
                setErrorMessage('');
            }, 3000); // 5초 후에 errorMessage를 초기화합니다.

            return () => clearTimeout(timer); // 컴포넌트가 unmount되거나 errorMessage가 변경될 때 타이머를 해제합니다.
        }
    }, [errorMessage]);


    return (
        <div className="single-background">
            {errorMessage && (
                <div className="error-alert">
                    <p>{errorMessage}</p>
                </div>
            )}


            <div>
                <a href="/">
                    <img
                        src={"https://image.shutterstock.com/image-vector/letters-duo-joint-logo-icon-250nw-1113311357.jpg"}
                        alt="이미지"
                        style={{
                            width: '100px',
                            height: '65px',
                            marginLeft: '20px',
                            borderRadius: '25%',
                            marginTop: '10px',
                            position: 'absolute',
                            cursor: 'pointer' // 마우스 커서를 포인터로 변경하여 클릭 가능한 상태를 나타냅니다.
                        }}
                    />
                </a>
            </div>


            <div className="home-container" style={{margin: '0 150px'}}>

                <form onSubmit={handleSubmit}>
                    <div className="single-input-text">
                        <input
                            type="text"
                            placeholder="ex) 플레이어 닉네임 + #KR1 를 입력해주세요."
                            value={gameNickname}
                            onChange={handleInputChange}
                        />
                        {/* 돋보기 아이콘 */}
                        <div className="single-search-icon" onClick={handleSubmit}></div>
                    </div>
                </form>


                {loading && (
                    <div style={{
                        position: 'fixed',
                        top: '50%',
                        left: '50%',
                        transform: 'translate(-50%, -50%)',
                        background: 'rgba(255,255,255,0.5)',
                        padding: '20px',
                        borderRadius: '8px',
                        boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
                        border: '2px solid #9987eb',
                        zIndex: '9999'
                    }}>
                        <p style={{fontSize: '20px', color: '#333', margin: '0'}}>
                            검색 결과를 찾는 중입니다...
                        </p>
                    </div>
                )}
                {/* 로딩 중 메시지 */}

                {searchResult ? (
                    <div style={{marginTop: '100px'}}>
                        {/*<h2>검색 결과</h2>*/}

                        <div className="profile" style={{display: 'flex', alignItems: 'center'}}>
                            <img
                                src={"https://ddragon.leagueoflegends.com/cdn/14.3.1/img/profileicon/" + searchResult.convertedRiotData.profileIconId + ".png"}
                                alt="이미지"
                                style={{width: '100px', height: '100px', marginLeft: '40px', borderRadius: '25%'}}
                            />
                            <div style={{marginLeft: '25px'}}>
                                <p style={{
                                    fontWeight: 'bold',
                                    fontSize: '25px',
                                    color: 'white'
                                }}> 이름: {searchResult.convertedRiotData.summonerName}</p>
                                <p style={{
                                    fontWeight: 'bold',
                                    fontSize: '25px',
                                    color: 'white'
                                }}> 레벨: {searchResult.convertedRiotData.summonerLevel}</p>
                                {/* 필요한 다른 정보들을 추가하세요 */}
                            </div>
                        </div>

                        {/*소환사 정보 그림*/}

                        {/*<h2>매치 결과</h2>*/}


                        <div className="match-info-container">
                            {searchResult.convertedRiotData.matchInfos.map((matchInfo, index) => (

                                <div key={index}
                                     className={`match-info game-box ${matchInfo.searchSummonerInfo.win ? 'blue-bg' : 'pink-bg'}`}
                                     style={{
                                         backgroundImage: `linear-gradient(rgba(255, 255, 255, 0.5), rgba(255, 255, 255, 0.5)), url(${'https://ddragon.leagueoflegends.com/cdn/img/champion/centered/' + (matchInfo.searchSummonerInfo.championName === 'Fiddlesticks' ? 'FiddleSticks' : matchInfo.searchSummonerInfo.championName) + '_1.jpg'})`,
                                         backgroundPosition: '25% 20%',
                                         backgroundSize: 'cover',
                                         backdropFilter: 'blur(4px)', // 배경에 블러 효과 추가
                                     }}>

                                    <div className="result-info">

                                        <div className="game-info">
                                            <p className={matchInfo.searchSummonerInfo.win ? 'win-text' : 'lose-text'}>
                                                {matchInfo.searchSummonerInfo.win ? '승리' : '패배'}
                                            </p>
                                            <p className="game-mode"> {matchInfo.gameCreatedDate}</p>
                                            <p className="game-mode"> {matchInfo.gameMode}</p>
                                            <p className="game-duration"> {Math.floor(matchInfo.gameTotalTime)}분</p>

                                        </div>

                                        {matchInfo.searchSummonerInfo ? (

                                            <div>
                                                <div>
                                                    <div className="champion-spell-container">
                                                        <div className="champion-images">
                                                            <img
                                                                src={"https://ddragon.leagueoflegends.com/cdn/14.4.1/img/champion/" + matchInfo.searchSummonerInfo.championName + ".png"}
                                                                alt="이미지"
                                                                style={{width: '80px', height: '80px'}}
                                                            />
                                                        </div>
                                                        <div className="spell-images">
                                                            <img
                                                                src={"https://ddragon.leagueoflegends.com/cdn/14.4.1/img/spell/" + matchInfo.searchSummonerInfo.spell1 + ".png"}
                                                                alt="이미지"
                                                                style={{width: '40px', height: '40px'}}
                                                            />
                                                            <img
                                                                src={"https://ddragon.leagueoflegends.com/cdn/14.4.1/img/spell/" + matchInfo.searchSummonerInfo.spell2 + ".png"}
                                                                alt="이미지"
                                                                style={{width: '40px', height: '40px'}}
                                                            />
                                                        </div>
                                                        <p className="game-mode game-stats">
                                                            {matchInfo.searchSummonerInfo.kills} /
                                                            <span
                                                                className="deaths">{matchInfo.searchSummonerInfo.deaths}</span> /
                                                            {matchInfo.searchSummonerInfo.assists}
                                                        </p>
                                                    </div>
                                                    <div className="item-images">
                                                        {matchInfo.searchSummonerInfo.items.map((item, index) => (
                                                            item === 0 ? (
                                                                <div className="empty-item" key={index}></div>
                                                            ) : (
                                                                <img
                                                                    key={index}
                                                                    src={`https://ddragon.leagueoflegends.com/cdn/14.4.1/img/item/${item}.png`}
                                                                    alt="이미지"
                                                                    style={{width: '35px', height: '35px'}}
                                                                />
                                                            )
                                                        ))}
                                                    </div>
                                                </div>
                                            </div>
                                        ) : (
                                            <p>데이터가 없습니다.</p>
                                        )}
                                        <div className="teams-container">
                                            <div className="team-list">
                                                <div>
                                                    <h4>승리 팀</h4>
                                                    <ul className="participants">
                                                        {matchInfo.matchParticipantInfos.filter(participant => participant.win).map((participant, index) => (
                                                            <li key={index}>
                                                                <div className="participant-info">
                                                                    <img
                                                                        src={"https://ddragon.leagueoflegends.com/cdn/14.4.1/img/champion/" + participant.championName + ".png"}
                                                                        alt="챔피언 이미지"
                                                                        style={{width: '20px', height: '20px'}}
                                                                    />
                                                                    {/* 팝오버 */}
                                                                    <span
                                                                        className="participant-name"
                                                                        onMouseEnter={(e) => handleMouseEnter(participant.participantName, e.target)}
                                                                        onMouseLeave={handleMouseLeave}>{participant.participantName}
                                                                </span>
                                                                </div>
                                                            </li>
                                                        ))}
                                                    </ul>
                                                    {/* 팝오버를 렌더링하는 부분 */}
                                                    {hoveredParticipant && (
                                                        <Popover content={hoveredParticipant}
                                                                 targetRect={popoverTargetRect}/>
                                                    )}
                                                </div>
                                                <div>
                                                    <h4>패배 팀</h4>
                                                    <ul className="participants">
                                                        {matchInfo.matchParticipantInfos.filter(participant => !participant.win).map((participant, index) => (
                                                            <li key={index}>
                                                                <div className="participant-info">
                                                                    <img
                                                                        src={"https://ddragon.leagueoflegends.com/cdn/14.4.1/img/champion/" + participant.championName + ".png"}
                                                                        alt="챔피언 이미지"
                                                                        style={{width: '20px', height: '20px'}}
                                                                    />

                                                                    {/* 팝오버 */}
                                                                    <span
                                                                        className="participant-name"
                                                                        onMouseEnter={(e) => handleMouseEnter(participant.participantName, e.target)}
                                                                        onMouseLeave={handleMouseLeave}>{participant.participantName}
                                                                </span>
                                                                </div>
                                                            </li>
                                                        ))}
                                                    </ul>
                                                    {/* 팝오버를 렌더링하는 부분 */}
                                                    {hoveredParticipant && (
                                                        <Popover content={hoveredParticipant}
                                                                 targetRect={popoverTargetRect}/>
                                                    )}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            ))}
                        </div>


                    </div>
                ) : (
                    errorMessage && (
                        <div>
                            <p>{errorMessage}</p>
                        </div>
                    )
                )}
            </div>
        </div>
    );
};

export default Single;
