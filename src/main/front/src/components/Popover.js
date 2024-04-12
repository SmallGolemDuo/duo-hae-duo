import React, {useEffect, useState} from 'react';
import ReactDOM from 'react-dom';

const Popover = ({content, targetRect}) => {
    const [style, setStyle] = useState({});

    useEffect(() => {
        if (targetRect) {
            // 팝오버의 스타일을 계산하고 설정합니다.
            const style = {
                position: 'absolute',
                top: `${targetRect.top + window.scrollY}px`, // 스크롤을 고려한 위치 계산
                left: `${targetRect.left + window.scrollX}px`, // 스크롤을 고려한 위치 계산
            };
            setStyle(style);
        }
    }, [targetRect]);

    return ReactDOM.createPortal(
        <div className="popover" style={style}>{content}</div>,
        document.body
    );
};

export default Popover;
