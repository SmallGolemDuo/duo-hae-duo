import React from 'react';
import Home from './components/Home';
import GroupList from './components/GroupList';
import GroupMembers from './components/GroupMembers';
import Single from "./components/Single";
import {Routes, Route} from 'react-router-dom';
import Recommendations from './components/Recommendations';
import RecommendResults from './components/RecommendResults';
import Skins from './components/Skins';

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
        </Routes>
    );
}

export default App;