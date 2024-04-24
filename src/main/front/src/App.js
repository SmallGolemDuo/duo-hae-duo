import React from 'react';
import {Routes, Route} from 'react-router-dom';
import Home from './components/Home';
import GroupList from './components/GroupList';
import GroupMembers from './components/GroupMembers';
import Single from "./components/Single";
import Recommendations from './components/Recommendations';
import RecommendResults from './components/RecommendResults';
import Skins from './components/Skins';
import ChampionSkinsInfo from './components/ChampionSkinsInfo';
import PatchNote from "./components/PatchNote";
import RotationChampions from "./components/RotationChampions"

function App() {
    return (
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/single" element={<Single/>}/>
            <Route path="/groups" element={<GroupList/>}/>
            <Route path="/group/groupMembers/:groupId" element={<GroupMembers/>}/>
            <Route path="/recommendations" element={<Recommendations/>}/>
            <Route path="/recommendResults" element={<RecommendResults/>}/>
            <Route path="/skins" element={<Skins/>}/>
            <Route path="/champions/:championNameEng/skins" element={<ChampionSkinsInfo/>}/>
            <Route path="/patch-notes" element={<PatchNote/>}/>
            <Route path="/rotation-champions" element={<RotationChampions/>}/>
        </Routes>
    );
}

export default App;