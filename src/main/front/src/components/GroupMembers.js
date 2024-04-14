import React, {useEffect, useState} from 'react';
import {useParams} from 'react-router-dom';
import './GroupMembers.css';

const GroupMembers = () => {
    const {groupId} = useParams();
    const [loading, setLoading] = useState(true);
    const [groupMembers, setGroupMembers] = useState([]);

    const fetchGroupMembers = () => {
        fetch(`/api/lol/groups/group-infos/${groupId}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('서버로부터 데이터를 가져오는 중 오류가 발생했습니다.');
                }
                return response.json();
            })
            .then((data) => {
                setGroupMembers(data);
            })
            .catch((error) => {
                console.error('데이터를 가져오는 중 오류가 발생했습니다:', error);
            })
            .finally(() => {
                setLoading(false);
            });
    };

    useEffect(() => {
        fetchGroupMembers();
    }, [groupId]);

    return (
        <div className="groupMembers-background">

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


            {loading ? (
                <div className="groupMembers-message">Loading...</div>
            ) : (
                <>
                    {groupMembers.length === 0 ? (
                        <div className="groupMembers-message">No group members found.</div>
                    ) : (
                        <div className="groupMembers-matchInfo-container">
                            <div className="group-name">
                                {groupMembers.groupName}
                            </div>
                            <div className="group-container">
                                {groupMembers.findGroupMemberInfos.map((user, userIndex) => (
                                    <div key={userIndex} className="group-member">
                                        <div className="groupMembers-match-info">
                                            <div className="groupMembers-profile"
                                                 style={{display: 'flex', alignItems: 'center'}}>
                                                <img
                                                    src={"https://ddragon.leagueoflegends.com/cdn/14.3.1/img/profileicon/" + user.profileIconId + ".png"}
                                                    alt="이미지"
                                                    style={{width: '50px', height: '50px', marginRight: '10px'}}
                                                />
                                                <div>
                                                    <h4 style={{
                                                        margin: '0',
                                                        color: 'white',
                                                        fontSize: '20px'
                                                    }}>{user.summonerName}</h4>
                                                    <h4 style={{
                                                        margin: '0',
                                                        color: 'white',
                                                        fontSize: '20px'
                                                    }}>레벨: {user.summonerLevel}</h4>
                                                </div>
                                            </div>
                                            {user.matchInfos ? (
                                                user.matchInfos.map((gameData, gameIndex) => (
                                                    <div key={gameIndex}
                                                         className={`game-info ${gameData.searchSummonerInfo.win ? 'groupMembers-blue-bg' : 'groupMembers-pink-bg'}`}>
                                                        <ul className="group-game-info">
                                                            <p className={gameData.searchSummonerInfo.win ? 'group-win-text' : 'group-lose-text'}>
                                                                {gameData.searchSummonerInfo.win ? '승리' : '패배'}
                                                            </p>
                                                            <li className="group-game-time"> {Math.floor(gameData.gameTotalTime)}분</li>
                                                        </ul>
                                                        <li className="group-game-mode">{gameData.gameMode}</li>


                                                        <div>
                                                            <div>
                                                                <div className="group-champion-spell-container">
                                                                    <div className="group-champion-images">
                                                                        <img
                                                                            src={"https://ddragon.leagueoflegends.com/cdn/14.7.1/img/champion/" + gameData.searchSummonerInfo.championName + ".png"}
                                                                            alt="이미지"
                                                                            style={{width: '40px', height: '40px'}}
                                                                        />
                                                                    </div>
                                                                    <div className="group-spell-images">
                                                                        <img
                                                                            src={"https://ddragon.leagueoflegends.com/cdn/14.7.1/img/spell/" + gameData.searchSummonerInfo.spell1 + ".png"}
                                                                            alt="이미지"
                                                                            style={{width: '20px', height: '20px'}}
                                                                        />
                                                                        <img
                                                                            src={"https://ddragon.leagueoflegends.com/cdn/14.7.1/img/spell/" + gameData.searchSummonerInfo.spell2 + ".png"}
                                                                            alt="이미지"
                                                                            style={{width: '20px', height: '20px'}}
                                                                        />
                                                                    </div>
                                                                    <p className="group-game-mode group-game-stats">
                                                                        {gameData.searchSummonerInfo.kills} /
                                                                        <span
                                                                            className="group-deaths">{gameData.searchSummonerInfo.deaths}</span> /
                                                                        {gameData.searchSummonerInfo.assists}
                                                                    </p>
                                                                </div>
                                                                <div className="group-item-images">
                                                                    {gameData.searchSummonerInfo.items.map((item, index) => (
                                                                        item === 0 ? (
                                                                            <div className="group-empty-item"
                                                                                 key={index}></div>
                                                                        ) : (
                                                                            <img
                                                                                key={index}
                                                                                src={`https://ddragon.leagueoflegends.com/cdn/14.7.1/img/item/${item}.png`}
                                                                                alt="이미지"
                                                                                style={{width: '20px', height: '20px'}}
                                                                            />
                                                                        )
                                                                    ))}
                                                                </div>
                                                            </div>
                                                        </div>


                                                    </div>


                                                ))
                                            ) : (
                                                <div className="groupMembers-message"> No match information available
                                                    for this user.</div>
                                            )}
                                        </div>
                                    </div>
                                ))}
                            </div>
                        </div>
                    )}
                </>
            )}
        </div>
    );
};

export default GroupMembers;
