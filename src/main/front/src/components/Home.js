import React from 'react';
import './Home.css';
import {useNavigate} from 'react-router-dom';

function Home() {
    let navigate = useNavigate();

    // 그룹 조회
    function handleGroupList() {
        navigate('/groupList');
    }

    function handleRecommendations() {
        navigate('/recommendations');
    }

    // 스킨 갤러리
    function handleSkins() {
        navigate('/skins');
    }

    return (
        <div className="home-background">
            <div className="home-comment">
                <h1>
                    <span>듀오해듀오</span>
                </h1>
                <p>
                    <span>듀오해듀오를 통해 그룹 조회 및 챔피언 추천등 다양한 컨텐츠를 확인해보세요.</span>
                </p>
            </div>
            <div className="home-input-text">
                <input type="text" placeholder="플레이어 닉네임을 입력해주세요."/>
                <div className="search-icon"></div>
                {/* 돋보기 아이콘 */}
            </div>
            <div className="home-button-location">
                <button className="home-button" onClick={handleGroupList}>그룹 관리</button>
                <button className="home-button" onClick={handleRecommendations}>챔피언 추천 테스트</button>
                <button className="home-button" onClick={handleSkins}>스킨 갤러리</button>
            </div>
        </div>
    );
}

export default Home;
