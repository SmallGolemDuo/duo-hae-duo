// Home.js

import React, {useState} from 'react';
import './Home.css';
import {useNavigate} from 'react-router-dom';

function Home() {
    const [playerName, setPlayerName] = useState(''); // 플레이어 닉네임을 상태로 관리합니다

    let navigate = useNavigate();

    function handleInputChange(event) {
        setPlayerName(event.target.value); // 입력 필드의 값을 상태로 업데이트합니다.
    }

    function handleSubmit(event) {
        event.preventDefault();
        navigate(`/single?playerName=${encodeURIComponent(playerName)}`); // URL을 변경하고 playerName을 쿼리 문자열로 전달합니다.
    }

    // 그룹 조회
    function handleGroups() {
        navigate('/groups');
    }

    function handleRecommendations() {
        navigate('/recommendations');
    }

    // 스킨 갤러리
    function handleSkins() {
        navigate('/skins');
    }

    // 패치 노트 페이지
    function handlePatchNotes() {
        navigate('/patch-notes');
    }

    // 패치 노트 페이지
    function handleRotationChampions() {
        navigate('/rotation-champions');
    }

    // 패치 노트 페이지
    function handleVideoPosts() {
        navigate('/video-posts');
    }

    return (
        <div className="home-background">
            <div className="home-comment">
                <h1>듀오해듀오</h1>
                <p>듀오해듀오를 통해 그룹 조회 및 챔피언 추천등 다양한 컨텐츠를 확인해보세요.</p>
            </div>

            <form onSubmit={handleSubmit}> {/* 폼 제출 시 handleSubmit 함수를 호출합니다. */}
                <div className="home-input-text">
                    <input
                        type="text"
                        placeholder="ex) 플레이어 닉네임 + #KR1 를 입력해주세요."
                        value={playerName}
                        onChange={handleInputChange} // 입력 필드 값이 변경될 때 handleInputChange 함수를 호출합니다.
                    />
                    <div className="search-icon"></div>
                    {/* 돋보기 아이콘 */}
                </div>
            </form>

            <div className="home-button-location">
                <button className="home-button" onClick={handleGroups}>그룹 관리</button>
                <button className="home-button" onClick={handleRecommendations}>챔피언 추천 테스트</button>
                <button className="home-button" onClick={handleSkins}>스킨 갤러리</button>
            </div>
            <div className="home-button-location-2">
                <button className="home-button-patch" onClick={handlePatchNotes}>패치 노트</button>
                <button className="home-button-patch" onClick={handleRotationChampions}>로테이션 챔피언</button>
                <button className="home-button-patch" onClick={handleVideoPosts}>영상 게시판</button>
            </div>
        </div>
    );
}

export default Home;
