import React from 'react';
import {Routes, Route} from 'react-router-dom';
import Home from './components/Home';
import Recommendations from './components/Recommendations';
import RecommendResults from './components/RecommendResults';
import Skins from './components/Skins';

function App() {
    return (
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/recommendations" element={<Recommendations/>}/>
            <Route path="/recommendResults" element={<RecommendResults/>}/>
            <Route path="/skins" element={<Skins/>}/>
        </Routes>
    );
}

export default App;