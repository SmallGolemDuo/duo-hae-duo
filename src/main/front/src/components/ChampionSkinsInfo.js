// import React from 'react';
// import { Link } from 'react-router-dom';
// import './ChampionSkinsInfo.css';
//
// function ChampionSkinsInfo({ champion, skins }) {
//
//     const fetchGroupMembers = () => {
//         fetch(`/api/lol/champions/${championNameEng}/skins`, {
//             method: 'GET',
//             headers: {
//                 'Content-Type': 'application/json'
//             }
//         })
//             .then((response) => {
//                 if (!response.ok) {
//                     throw new Error('서버로부터 데이터를 가져오는 중 오류가 발생했습니다.');
//                 }
//                 return response.json();
//             })
//             .then((data) => {
//                 console.log('데이터를 성공적으로 가져왔습니다:', data);
//             })
//             .catch((error) => {
//                 console.error('데이터를 가져오는 중 오류가 발생했습니다:', error);
//             })
//             .finally(() => {
//                 setLoading(false);
//             });
//     };
//
//     return (
//         <Link to={`/champion/${champion.championNameEng}/skins`} className="champion-box">
//             <div className="champion-skins-info-container">
//                 {skins.map((skin, index) => (
//                     <div key={index} className="skin-info">
//                         <p>{skin.name}</p>
//                         <img src={skin.url} alt={skin.name} />
//                     </div>
//                 ))}
//             </div>
//         </Link>
//     );
// }
//
// export default ChampionSkinsInfo;
