import React, {useState, useEffect} from 'react';
import {useParams, Link} from 'react-router-dom';
import './ChampionSkinsInfo.css';

function ChampionSkinsInfo() {
    const [skins, setSkins] = useState([]);
    const {championNameEng} = useParams();

    useEffect(() => {
        const fetchChampionSkins = async () => {
            try {
                const response = await fetch(`/api/lol/champions/${championNameEng}/skins`);
                if (!response.ok) {
                    throw new Error('서버로부터 데이터를 가져오는 중 오류가 발생했습니다.');
                }
                const data = await response.json();
                const modifiedSkins = data.skins.map(skin => {
                    if (skin.name === 'default') {
                        skin.name = data.championNameKor;
                    }
                    return skin;
                });
                setSkins(modifiedSkins);
            } catch (error) {
                console.error('데이터를 가져오는 중 오류가 발생했습니다:', error);
                alert('잘못된 요청입니다.');
            }
        };
        fetchChampionSkins();
    }, [championNameEng]);

    return (
        <div className="champion-skins-info-container">
            <Link to="/" className="home-redirect-icon">
                <img
                    src={"https://image.shutterstock.com/image-vector/letters-duo-joint-logo-icon-250nw-1113311357.jpg"}
                    alt="home_icon"
                    style={{
                        width: '100px',
                        height: '100px',
                        marginLeft: '25%'
                    }}
                />
            </Link>
            <Link to="/skins" className="skin-info-back-button">돌아가기</Link>
            <div className="champion-skins-container">
                {skins.map((skin, index) => (
                    <div key={index} className="skin-info">
                        <img src={skin.url} alt={skin.name}/>
                        <p>{skin.name}</p>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default ChampionSkinsInfo;
