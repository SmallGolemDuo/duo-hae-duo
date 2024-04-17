import React, {useState, useEffect} from 'react';
import './PatchNote.css';
import {Link} from "react-router-dom";


function PatchNotes() {
    const [patchNotes, setPatchNotes] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('/api/lol/patch-notes');
                if (!response.ok) {
                    throw new Error('서버로부터 데이터를 가져오는 중 오류가 발생했습니다.');
                }
                const data = await response.json();
                setPatchNotes(data);
                console.log(data)
            } catch (error) {
                console.error('데이터를 가져오는 중 오류가 발생했습니다:', error);
            }
        };
        fetchData();
    }, []);

    return (
        <div className="patch-note-page">
            <Link to="/" className="patch-redirect-icon">
                <img
                    src={"https://image.shutterstock.com/image-vector/letters-duo-joint-logo-icon-250nw-1113311357.jpg"}
                    alt="home_icon" style={{
                    marginLeft: "5%",
                    marginTop: "3.5%",
                    width: "8%",
                    height: "12%",
                    position: "absolute",
                }}/>
            </Link>
            <h1 className="patch-note-title">패치 노트</h1>
            <div className="patch-notes-container">
                {patchNotes.map((patchNote, index) => (
                    <div key={index} className="patch-note-item">
                        <a href={patchNote.patchNoteUrl}>
                            <img className="patch-note-img" src={patchNote.imageUrl} alt={patchNote.subject}/>
                            <span>{patchNote.subject}</span>
                        </a>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default PatchNotes;
